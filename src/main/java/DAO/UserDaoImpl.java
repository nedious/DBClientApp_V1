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
     * Confirm the user for login
     * @param user
     * @param password
     * @return
     */
    public static int validateLogin (String user, String password){
        try {
            String sqlSelect = "SELECT * FROM users WHERE user_name = '" + user + "' AND password = '" + password +"'";
            PreparedStatement preparedStatement = JDBC.getConnection().prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                if (
                        (resultSet.getString("User_Name").equals(user))
                        &&
                        (resultSet.getString("Password").equals(password))
                ) {
                        return resultSet.getInt("User_ID");
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
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
