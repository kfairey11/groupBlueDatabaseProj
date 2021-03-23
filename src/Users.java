/**
 * A class of Users
 * @author Kennedy
 */
import java.util.ArrayList;
import java.util.UUID;
public class Users {
    private static Users users;
    private static ArrayList<User> userList;

    /**
     * Constructor for Users
     */
    private Users()
    {
        userList = DataLoader.getUsers();
    }

    /**
     * Gets an instance of Users
     * @return Users
     */
    public static Users getInstance()
    {
        if(users == null)
            users = new Users();
        return users;
    }

    /**
     * Searches userList for a certain User
     * @param userName
     * @return boolean
     */
    public boolean haveUser(String userName)
    {
        for(int i=0;i<userList.size();i++)
        {
            if(userList.get(i).getUserName().equalsIgnoreCase(userName))
                return true;
        }
        return false; 
    }

    public User getUser(String username)
    {
        for(User user : userList)
        {
            if(user.getUserName().equals(username))
                return user;
        }
        return null;
    }

    public ArrayList<User> getUsers()
    {
        return userList;
    }
    

    public boolean addUser(UUID userID, String firstName, String lastName, String username, String password)
    {
        if(haveUser(username))
            return false;
        userList.add(new User(userID, firstName, lastName, username, password)); 
        return true;

    }

    public void saveUsers()
    {
        DataWriter.saveUsers();
    }
}