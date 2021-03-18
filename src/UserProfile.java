/**
 * A UserProfile Class
 * @author Aubrey, Casey
 */
public class UserProfile 
{
    /**
     * Attributes of the UserProfile
     */
    protected String username;
    protected String password;
    private User user;
    
    /**
     * Creates a User Profile
     * @param aUser
     */
    public void createUser(User aUser)
    {
        this.username = aUser.getUserName();
        this.password = aUser.getPassword();
        this.user = aUser;
    }

    /**
     * Gets a User
     * @return User
     */
    public User getUser()
    {
        
        if (username == user.getUserName() && password == user.getPassword()) {
            return user;
        }

    }
}
