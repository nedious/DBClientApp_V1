package helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class: JDBC is an abstract class that allows access to the static members placed inside it.
 * This class will have code in it that will connect it to the database.
 *
 * `Connection` connection is a part of the MySQL Connector / J jar so it needs to be imported. `Connection` is a part
 * of the JDK but it is used to reference what is inside of the MySQL Connector / J jar.
 */
public abstract class JDBC {
    private static final String protocol = "jdbc";
    private static final String vendor = ":mysql:";
    private static final String location = "//localhost/";
    private static final String databaseName = "client_schedule";
    private static final String jdbcUrl = protocol + vendor + location + databaseName + "?connectionTimeZone = UTC"; // LOCAL  // points to database
    private static final String driver = "com.mysql.cj.jdbc.Driver"; // Driver reference
    private static final String userName = "sqlUser"; // MySQL database Username
    private static String password = "Passw0rd!"; // MySQL database Password
    public static Connection connection;  // Connection Interface

    public static void openConnection()
    {
        try {
            Class.forName(driver); // Locate Driver  // used to load driver to class
            connection = DriverManager.getConnection(jdbcUrl, userName, password); // Reference Connection object // established connection
            System.out.println("Connection successful!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("Error:" + e.getMessage());
        }
    }

    public static Connection getConnection() {
        return connection;
    }
    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed!");
        }
        catch(Exception e)
        {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
