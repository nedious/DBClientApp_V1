package helper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** to drop nutrition tables
 * USE client_schedule;
 * DROP TABLE IF EXISTS FRUITS, COLORS;
 * */

public abstract class FruitsQuery {
// abstract class to take care of running operations on the SQL Fruits table

    public static int insert(String fruitName, int colorId) throws SQLException {
        // static method will handle our insert
        // we will use the executeUpdate() method and that returns an int representing the num of rows affected
        // so public static will return an int
        // this method will have 2 parameters, 1) for fruitName 2) Foreign Key for fruit, the colorId
        // first parameter is String type, name: fruitName. second: int type, name: colorId

        String sql = "INSERT INTO FRUITS (Fruit_Name, Color_ID) VALUES(?, ?)";
        // insert statement: String type, variable: sql
        // inside we can write our SQL statement "INSERT INTO (tableName) FRUITS (column1YouWantForYourInsertStatement, column2)
        // VALUES(bindVariableIndex1, bindVariableIndex2)";
        // remember, bind Variables are question marks '?'
        // bind Variables are indexed, starting at 1

        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        // create a prepareStatement
        // PreparedStatement variable
        // to create a preparedStatement, we use a connection reference to call the prepareStatement() method
        // back in our JDBC class we have the 'connection' variable, so, when the database connection is successful by
        // calling the openConnection() method the connection variable will be assigned a connection reference
        // remember the connection variable is public so we can reference it directly through the JDBC class.
        // inside of the prepareStatement(inside we pass the SQL statement we want to execute so it is being referenced by the SQL variable from String sql variable)
        // the `.prepareStatement()` threw an error, and was fixed by adding the `throws SQLException` in header

        ps.setString(1, fruitName);
        // now that we have the preparedStatement, we can call the prepareStatement setter methods to assign the bind Variables values
        // ps.setString() is a bind Variable. there will be 2 bind variables. They are:
        // Fruit_Name at index 1, Color_ID at index 2
        // ps varaible wants to assign a value to Fruit_Name, and Fruit_Name is a varchar type in MySQL so that means
        // we will need to assign a string to it. = .setString()
        // setString() is a prepareStatement Setter Method, and we pass in 2 things: 1) the bind Var index '1' the parameter index
        // 2) the Bind Variable value: we call the insert method outside of the class and pass a value to the fruitName parameter

        ps.setInt(2, colorId);
        // the next bind Variable is Color_ID at index 2 and it has a type of int
        // ps.setInt() takes a parameter index, and takes the parameter value (colorId)

        int rowsAffected = ps.executeUpdate();
        // next is the executeUpdate() method which will return the number of rows affected by the INSERT
        // in this case we are affecting one row, so we should have one row returned
        // executeUpdate() will also insert the record(s) into the database table FRUITS

        return rowsAffected;
    }

    public static int update(int fruitId, String fruitName) throws SQLException {
        // write a method that does our update
        // what we are updating is the name of the fruit but we will need the id of the fruit so we can find and update it.
        // 2 parameters are needed: fruitId, fruitName

        String sql = "UPDATE FRUITS SET Fruit_Name = ? WHERE Fruit_ID = ?";
        // update statement: UPDATE tableYouWantUpdate SET specifyColumnYouWantUpdated = ?BindVar WHERE Fruit_ID = ?BindVar
        // we want to update a column (Fruit_Name) with a value (?) WHERE Fruit_Name's primary key (Fruit_ID) is set to the value we pass (?)
        // Fruit_Name bind Variable ? will take the fruitName, and Fruit_ID bind variable ? will take the fruitId

        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setString(1, fruitName);
        ps.setInt(2, fruitId);
        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

    // delete method
    public static int delete(int fruitId) throws SQLException {
        // the delete method will accept the id of the record you want to delete (in this case fruitId)

        String sql = "DELETE FROM FRUITS WHERE FRUIT_ID = ?";
        // this will delete from FRUITS where FRUIT_ID = the bind variable ?

        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, fruitId);
        // there is only bind variable, so index is 1, and the fruitId parameter

        int rowsAffected = ps.executeUpdate();
        return rowsAffected;
    }

    public static void select() throws SQLException {
        // declared void because I don't plan to have it return anything

        String sql = "SELECT * FROM FRUITS";
        // SQL statement, with variable 'sql'
        // * means select ALL

        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        // to create the ResultSet we use the executeQuery() method. This will create a ResultSet (the 2dimensional list)

        while(rs.next()){
            // inside of the while loop header, we will call the next() method
            // the next() method moves the ResultSet cursor through the ResultSet list, it returns true if there is data in
            // the set, and false if there is no data in the set
            // provided we have data in our rs.next(), we can go through the data, in this case we will get the column data for the resultSet
            // we are running through records from the FRUITS table

            int fruitId = rs.getInt("Fruit_ID");
            // variables to represent the columns in the FRUITS Table
            // fruitId = ResultSet Getter (rs.getInt) and use the ResultSet reference for this
            // rs.getInt ResultSet we are getting the integer from the Fruit_ID label because that's the SQL type
            // rs.getInt("Fruit_ID") will retrieve the data from the REsultSET the Fruit_ID and assign it to variable fruitId

            String fruitName = rs.getString("Fruit_Name");
            // lets go get the fruit_Name column data

            System.out.print(fruitId + " | ");
            // display the results
            System.out.print(fruitName + "\n");
            // print fruitName and a linebreak
        }
    }

    // use a bind Variable with the select statement. you may have a situation where you have records that you want to match to a certain condition
    public static void select(int colorId) throws SQLException {
        // this creates an overloaded select statement, this one will accept an ID
        // purpose is to select all the fruits that have a particular colorID

        String sql = "SELECT * FROM FRUITS WHERE Color_ID = ?";
        // SELECT all FROM FRUITS WHERE Color_IDcolumn = ?BindVariable

        PreparedStatement ps = JDBC.connection.prepareStatement(sql);
        ps.setInt(1, colorId);
        // because we are using a bind Variable, we want to use a setter to assign a value to the bind variable
        // only 1 bind variable so parameter index is 1, and the colorId parameter.

        ResultSet rs = ps.executeQuery();
        // to create the ResultSet we use the executeQuery() method. This will create a ResultSet (the 2dimensional list)

        while(rs.next()){
            // inside of the while loop header, we will call the next() method
            // the next() method moves the ResultSet cursor through the ResultSet list, it returns true if there is data in
            // the set, and false if there is no data in the set
            // provided we have data in our rs.next(), we can go through the data, in this case we will get the column data for
            // the resultSet we are running through records from the FRUITS table

            int fruitId = rs.getInt("Fruit_ID");
            // variables to represent the columns in the FRUITS Table
            // fruitId = ResultSet Getter (rs.getInt) and use the ResultSet reference for this
            // rs.getInt ResultSet we are getting the integer from the Fruit_ID label because that's the SQL type
            // rs.getInt("Fruit_ID") will retrieve the data from the REsultSET the Fruit_ID and assign it to variable fruitId

            String fruitName = rs.getString("Fruit_Name");
            // goes to get the fruit_Name column data

            int colorIdFK = rs.getInt("Color_ID");
            // goes to get the colorIdForeignKey(FK) column data

            System.out.print(fruitId + " | ");
            System.out.print(fruitName + " | ");
            System.out.print(colorIdFK + "\n");
        }
    }
}