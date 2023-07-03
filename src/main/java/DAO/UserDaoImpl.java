package DAO;

import helper.JDBC;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class: UserDaoImpl.
 * In this class we will have the Create, Read, Update and Delete files for the users table
 * */
public class UserDaoImpl {
    static boolean act;
    public static User getUser(String userName) throws SQLException, Exception{
        // type is name or phone, value is the name or the phone #
        DBConnection.makeConnection();
        String sqlStatement="select * FROM users WHERE User_Name  = '" + userName+ "'";
        //  String sqlStatement="select FROM address";
        Query.makeQuery(sqlStatement);
        User userResult;
        ResultSet result=Query.getResult();
        while(result.next()){
            int userid=result.getInt("User_ID");
            String userNameG=result.getString("User_Name");
            String password=result.getString("Password");
            userResult= new User(userid, userName, password);
            return userResult;
        }
        DBConnection.closeConnection();
        return null;
    }


    /**
      * Method: validateLogin. From login screen, take username and user password, make into string, create prepared statement, generate resultSet if prepared Statement is successful and test if true
      * @param userName from login user text field
      * @param password from login user password field
      * @return boolean
      */
    public static Boolean validateLogin(String userName, String password) throws SQLException {
        String sqlSelect = "SELECT * FROM users WHERE user_name = '" + userName + "' AND password = '" + password +"'";     // sql string for query
//        System.out.println("sqlSelect: " + sqlSelect);
        PreparedStatement preparedStatement = JDBC.getConnection().prepareStatement(sqlSelect);     // make database connection, pass prepareStatement()
//        System.out.println("preparedStatement: " + preparedStatement);
        ResultSet resultSet = preparedStatement.executeQuery();         // result set of query from database *if prepared statement returns any results

        try {
            if(resultSet.next()){           // the next() method moves the ResultSet cursor down
                System.out.println("successful login attempt");
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }



    /**
     * Gets all user data
     * @return allUsers
     * @throws SQLException
     */
    public static ObservableList<User> getAllUsers() throws SQLException, Exception{
        ObservableList<User> allUsers= FXCollections.observableArrayList();
        DBConnection.makeConnection();
        String sqlStatement="select * from users";
        Query.makeQuery(sqlStatement);
        ResultSet result=Query.getResult();
        while(result.next()){
            int userid=result.getInt("User_ID");
            String userName=result.getString("User_Name");
            String password=result.getString("Password");
            User userResult= new User(userid, userName, password);
            allUsers.add(userResult);

        }
        DBConnection.closeConnection();
        return allUsers;
    }
}
