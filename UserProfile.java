public class UserProfile 
{
    protected String username;
    protected String password;
    private User user;
    
    public void createUser(User aUser)
    {
        this.username = aUser.getUserName();
        this.password = aUser.getPassword();
        this.user = aUser;
    }

    public User getUser()
    {
        
        if (username == user.getUserName() && password == user.getPassword()) {
            return user;
        }

    }
}
