import java.util.*;

public class User {
    private UUID userID;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public User(UUID userID, String firstName, String lastName, String userName, String password){
        //empty stub
    }

        public UUID getUserID()
        {
            return userID;
        }

        public void setUserID(UUID userID)
        {
            this.userID = userID;
        }

        public String getFirstName()
        {
            return firstName;
        }

        public void setFirstName(String firstName)
        {
            this.firstName = firstName;
        }

        public String getLastName()
        {
            return lastName;
        }

        public void setLastName(String lastName)
        {
            this.lastName = lastName;
        }

        public String getUserName()
        {
            return userName;
        }

        public void setUserName(String userName)
        {
            this.userName = userName;
        }

        public String getPassword()
        {
            return password;
        }

        public void setPassword(String password)
        {
            this.password = password;
        }

    }
