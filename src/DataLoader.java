import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class DataLoader extends DataConstants{

    public static ArrayList<User> getUsers()
    {
        ArrayList<User> users = new ArrayList<User>();

        try
        {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i< peopleJSON.size(); i++)
            {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                UUID id = UUID.fromString((String)personJSON.get(USER_ID));
                String firstName = (String)personJSON.get(USER_FIRST_NAME);
                String lastName = (String)personJSON.get(USER_LAST_NAME);
                String userName = (String)personJSON.get(USER_USERNAME);
                String password = (String)personJSON.get(USER_PASSWORD);

                users.add(new User(id, firstName, lastName, userName, password));
            }

            return users;
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    //can make main method in this class to test
    public static ArrayList<Criminal> getCriminals()
    {
        ArrayList<Criminal> criminals = new ArrayList<Criminal>();

        try
        {
            FileReader reader = new FileReader(CRIMINAL_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i<peopleJSON.size(); i++)
            {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                String firstName = (String)personJSON.get(CRIMINAL_FIRST_NAME);
                String lastName = (String)personJSON.get(CRIMINAL_LAST_NAME);
                //cast as a long then .inValue()
                int age = Integer.parseInt((String)personJSON.get(CRIMINAL_AGE));
                String sex = (String)personJSON.get(CRIMINAL_SEX);
                String nickname = (String)personJSON.get(CRIMINAL_NICKNAME);
                String height = (String)personJSON.get(CRIMINAL_HEIGHT);
                double weight = Double.parseDouble((String)personJSON.get(CRIMINAL_WEIGHT));
                String race = (String)personJSON.get(CRIMINAL_RACE);
                //need to interator
                ArrayList<String> tattoos = (ArrayList<String>)personJSON.get(CRIMINAL_TATTOOS);
                double shoeSize = Double.parseDouble((String)personJSON.get(CRIMINAL_SHOE_SIZE));
                ArrayList<String> piercings = (ArrayList<String>)personJSON.get(CRIMINAL_PIERCINGS);
                
                criminals.add(new Criminal(firstName, lastName, age, sex, nickname, height, weight, race, tattoos, shoeSize, piercings));
            }
            return criminals;
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Victim> getVictims()
    {
        ArrayList<Victim> victims = new ArrayList<Victim>();

        try
        {
            FileReader reader = new FileReader(VICTIM_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0; i<peopleJSON.size();i++)
            {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                String firstName = (String)personJSON.get(VICTIM_FIRST_NAME);
                String lastName = (String)personJSON.get(VICTIM_LAST_NAME);
                int age = Integer.parseInt((String)personJSON.get(VICTIM_AGE));
                String sex = (String)personJSON.get(VICTIM_SEX);
                String report = (String)personJSON.get(VICTIM_REPORT);
                String hospital = (String)personJSON.get(VICTIM_HOSPITAL);
                int phoneNum = Integer.parseInt((String)personJSON.get(VICTIM_PHONE_NUM));
                String address = (String)personJSON.get(VICTIM_ADDRESS);
                
                victims.add(new Victim(firstName, lastName, age, sex, report, hospital, phoneNum, address));
            }
            return victims;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public static ArrayList<Officer> getOfficers(){
        ArrayList<Officer> officers = new ArrayList<Officer>();

        try{
            FileReader reader = new FileReader(OFFICER_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);

            for(int i=0;i<peopleJSON.size();i++)
            {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                String firstName = (String)personJSON.get(OFFICER_FIRST_NAME);
                String lastName = (String)personJSON.get(OFFICER_LAST_NAME);
                int age = Integer.parseInt((String)personJSON.get(OFFICER_AGE));
                String sex = (String)personJSON.get(OFFICER_SEX);
                String rank = (String)personJSON.get(OFFICER_RANK);
                int officeNum = Integer.parseInt((String)personJSON.get(OFFICER_OFFICE_NUM));
                String address = (String)personJSON.get(OFFICER_ADDRESS);
                String city = (String)personJSON.get(OFFICER_CITY);

                officers.add(new Officer(firstName, lastName, age, sex, rank,city, officeNum, address));
            }
            return officers;
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public static ArrayList<Witness> getWitnesses()
    {
        ArrayList<Witness> witnesses = new ArrayList<Witness>();
        try
        {
        FileReader reader = new FileReader(WITNESS_FILE_NAME);
        JSONParser parser = new JSONParser();
        JSONArray peopleJSON = (JSONArray)new JSONParser().parse(reader);
        for(int i=0;i<peopleJSON.size();i++)
        {
            JSONObject personJSON = (JSONObject)peopleJSON.get(i);
            String firstName = (String)personJSON.get(WITNESS_FIRST_NAME);
            String lastName = (String)personJSON.get(WITNESS_LAST_NAME);
            int age = Integer.parseInt((String)personJSON.get(WITNESS_AGE));
            String sex = (String)personJSON.get(WITNESS_SEX);
            String testimony = (String)personJSON.get(WITNESS_TESTIMONY);
            int phoneNum = Integer.parseInt((String)personJSON.get(WITNESS_PHONE_NUM));
            String address = (String)personJSON.get(WITNESS_ADDRESS);

            witnesses.add(new Witness(firstName, lastName, age, sex, testimony, phoneNum, address));
        }
        return witnesses;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public static ArrayList<Case> getCases()
    {
        ArrayList<Case> cases = new ArrayList<Case>();
        try
        {
        FileReader reader = new FileReader(CASE_FILE_NAME);
        JSONParser parser = new JSONParser();
        JSONArray peopleJSON = (JSONArray) new JSONParser().parse(reader);

        for(int i=0; i<peopleJSON.size();i++)
        {
            JSONObject personJSON = (JSONObject)peopleJSON.get(i);
            int caseNum = Integer.parseInt((String)personJSON.get(CASE_CASE_NUM));
            String crimeType = (String)personJSON.get(CASE_CRIME_TYPE);
            String date = (String)personJSON.get(CASE_DATE);
            String description = (String)personJSON.get(CASE_DESCRIPTION);
            String location = (String)personJSON.get(CASE_LOCATION);
            boolean inJail = (boolean)personJSON.get(CASE_JAIL_STATUS);
            ArrayList<String> criminals = (ArrayList<String>)personJSON.get(CASE_CRIMINALS);
            ArrayList<String> victims = (ArrayList<String>)personJSON.get(CASE_VICTIMS);
            ArrayList<String> officers = (ArrayList<String>)personJSON.get(CASE_OFFICERS);
            ArrayList<String> witnesses = (ArrayList<String>)personJSON.get(CASE_WITNESSES);

            cases.add(new Case(caseNum, crimeType, date, description, location, inJail, criminals, victims, officers, witnesses));
        }
        return cases;
        }   
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}