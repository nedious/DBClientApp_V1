package model;


/**
 * Class: User.
 * Java POJO from Users table in database. User_ID, User_Name and Password columns from MySQL database (use for login authentication)
 * */
public class User {

    public int userId;
    public String userName;
    public String password;

// --------------- Constructors ---------------- //

    public User(int userId, String userName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
    }

// --------------- Getters ---------------- //

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

// --------------- Setters ---------------- //

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
