import java.util.*;

public class User {
    private UUID userID;
    private String firstName;
    private String lastName;

    public User(UUID userID, String firstName, String lastName){
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
}
