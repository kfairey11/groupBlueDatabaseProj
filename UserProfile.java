public class UserProfile 
{
    protected String username;
    protected String password;
    private User user;
    
    public void createUser(User aUser)
    {
        //empty
    }

    public User getUser()
    {
        //ask about validating password/username
        return user;
    }
}
