/**
 * A User Class
 * @Author Casey, Kennedy
 */
import java.util.*;

public class User {
    /**
     * Attributes of a User
     */
    private UUID userID;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    /**
     * Constructor for a User
     * @param userID
     * @param firstName
     * @param lastName
     * @param userName
     * @param password
     */
    public User(String firstName, String lastName, String userName, String password){
        //empty stub
        setUserID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    /**
     * Gets the userID
     * @return userID
     */
    public UUID getUserID()
    {
        return userID;
    }

    /**
     * Sets the userID
     * @param userID
     */
    public void setUserID()
    {
        this.userID = UUID.randomUUID();
    }

    /**
     * Gets the first name of the User
     * @return
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the first name of the User
     * @param firstName
     */
    public void setFirstName(String firstName)
    {
       this.firstName = firstName;
    }

    /**
     * Gets the last name of the User
     * @return last name 
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the last name for the User
     * @param lastName
     */
    public void setLastName(String lastName)
    {
       this.lastName = lastName;
    }

    /**
     * Gets the user name of the User
     * @return user name
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * Sets the user name for the User
     * @param userName
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * Gets the password of the User
     * @return password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Sets the password for the User
     * @param password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    }
