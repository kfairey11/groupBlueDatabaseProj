import java.util.ArrayList;
public class Users {
    private static Users users;
    private static ArrayList<User> userList;

    private Users()
    {
        userList = Database.getUsers();
    }

    public static Users getInstance()
    {
        if(users == null)
            users = new Users();
        return users;
    }

    public boolean haveUser(String userName)
    {
        for(int i=0;i<userList.size();i++)
        {
            if(userList.get(i).getUserName().equalsIgnoreCase(userName))
                return true;
        }
        return false; 
    }

    //maybe getUser?
}
