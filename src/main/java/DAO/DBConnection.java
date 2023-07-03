package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Class DBConnection: creates a connection to MySQL database
 * */
public class DBConnection {
    private static final String databaseName="client_schedule";
    private static final String DB_URL="jdbc:mysql://localhost:3306/"+databaseName;
    private static final String username="sqlUser";
    private static final String password="Passw0rd!";
    static Connection conn;
    public static void makeConnection() throws ClassNotFoundException, SQLException, Exception{
        conn = DriverManager.getConnection(DB_URL,username,password);
    }
    public static void closeConnection() throws ClassNotFoundException,SQLException, Exception{
        conn.close();
    }

}
