import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class DataWriter extends DataConstants{
    
    public static void saveUsers()
    {
        Users users = users.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for(int i=0;i<userList.size();i++)
            jsonUsers.add(getUserJSON(userList.get(i)));

        try(FileWriter file = new FileWriter(USER_FILE_NAME))
        {
            file.write(jsonUsers.toJSONString());
            file.flush();
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(User user)
    {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getUserID().toString());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_USERNAME, user.getUserName());
        userDetails.put(USER_PASSWORD, user.getPassword());

        return userDetails;
    }

    public static void saveCriminals()
    {
        People criminals = criminals.getInstance();
        ArrayList<Criminal> criminalList = criminals.getPeople();
        JSONArray jsonCriminals = new JSONArray();

        for(int i=0;i<criminalsList.size();i++)
            jsonCriminals.add(getCriminalJSON(criminalList.get(i)));
        
            try(FileWriter file = new FileWriter(CRIMINAL_FILE_NAME))
            {
                file.write(jsonCriminals.toJSONString());
                file.flush();
            }

            catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    public static JSONObject getCriminalJSON(Criminal criminal)
    {
        JSONObject criminalDetails = new JSONObject();
        criminalDetails.put(CRIMINAL_FIRST_NAME, criminal.getFirstName());
        criminalDetails.put(CRIMINAL_LAST_NAME, criminal.getLastName());
        criminalDetails.put(CRIMINAL_AGE, criminal.getAge());
        criminalDetails.put(CRIMINAL_SEX, criminal.getSex());
        criminalDetails.put(CRIMINAL_NICKNAME, criminal.getNickname());
        criminalDetails.put(CRIMINAL_HEIGHT, criminal.getHeight());
        criminalDetails.put(CRIMINAL_WEIGHT, criminal.getWeight());
        criminalDetails.put(CRIMINAL_RACE, criminal.getRace());
        criminalDetails.put(CRIMINAL_TATTOOS, criminal.getTattoos());
        criminalDetails.put(CRIMINAL_SHOE_SIZE, criminal.getShoeSize());
        criminalDetails.put(CRIMINAL_PIERCINGS, criminal.getPiercing());

        return criminalDetails;
    }

}
