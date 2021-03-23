import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class DataLoader extends DataConstants{
    private static FileReader reader;
    private static JSONParser parser;
    private static JSONArray peopleJSON;
    private static JSONObject personJSON;
    private static JSONArray jsonPeople;

    public static ArrayList<User> getUsers()
    {
        ArrayList<User> users = new ArrayList<User>();

        try
        {
            reader = new FileReader(USER_FILE_NAME);
            parser = new JSONParser();
            peopleJSON = (JSONArray)parser.parse(reader);

            for(int i=0; i< peopleJSON.size(); i++)
            {
                personJSON = (JSONObject)peopleJSON.get(i);
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

    public static void main(String[] args)
    {
        ArrayList<Case> criminals = getCases();
        criminals.get(0).print();
    }

    //can make main method in this class to test
    public static ArrayList<Criminal> getCriminals()
    {
        ArrayList<Criminal> criminals = new ArrayList<Criminal>();

        try
        {
            reader = new FileReader(CRIMINAL_FILE_NAME);
            parser = new JSONParser();
            peopleJSON = (JSONArray)parser.parse(reader);

            for(int i=0; i<peopleJSON.size(); i++)
            {
                personJSON = (JSONObject)peopleJSON.get(i);
                String firstName = (String)personJSON.get(CRIMINAL_FIRST_NAME);
                String lastName = (String)personJSON.get(CRIMINAL_LAST_NAME);
                int age = (((Long) personJSON.get(CRIMINAL_AGE)).intValue());
                String sex = (String)personJSON.get(CRIMINAL_SEX);
                String nickname = (String)personJSON.get(CRIMINAL_NICKNAME);
                String height = (String)personJSON.get(CRIMINAL_HEIGHT);
                double weight = ((Number)personJSON.get(CRIMINAL_WEIGHT)).doubleValue();
                String race = (String)personJSON.get(CRIMINAL_RACE);
                JSONArray jsonTattoos = (JSONArray)personJSON.get(CRIMINAL_TATTOOS);
                ArrayList<String> tattoos = new ArrayList<String>();
                if(jsonTattoos != null)
                {
                for(i=0; i < jsonTattoos.size(); i++)
                 {
                    String text  = (String)jsonTattoos.get(i);
                    tattoos.add(text);
                }
                }
                double shoeSize = ((Number)personJSON.get(CRIMINAL_SHOE_SIZE)).doubleValue();
                JSONArray jsonPiercings = (JSONArray)personJSON.get(CRIMINAL_PIERCINGS);
                ArrayList<String> piercings = new ArrayList<String>();
                if(jsonPiercings != null)
                {
                for(i=0; i < jsonPiercings.size(); i++)
                 {
                    String text  = (String)jsonPiercings.get(i);
                    tattoos.add(text);
                }
                }
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
            reader = new FileReader(VICTIM_FILE_NAME);
            parser = new JSONParser();
            peopleJSON = (JSONArray)parser.parse(reader);

            for(int i=0; i<peopleJSON.size();i++)
            {
                personJSON = (JSONObject)peopleJSON.get(i);
                String firstName = (String)personJSON.get(VICTIM_FIRST_NAME);
                String lastName = (String)personJSON.get(VICTIM_LAST_NAME);
                int age = (((Long) personJSON.get(VICTIM_AGE)).intValue());
                String sex = (String)personJSON.get(VICTIM_SEX);
                String report = (String)personJSON.get(VICTIM_REPORT);
                String hospital = (String)personJSON.get(VICTIM_HOSPITAL);
                int phoneNum = (((Long) personJSON.get(VICTIM_PHONE_NUM)).intValue());
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
            reader = new FileReader(OFFICER_FILE_NAME);
            parser = new JSONParser();
            peopleJSON = (JSONArray)parser.parse(reader);

            for(int i=0;i<peopleJSON.size();i++)
            {
                personJSON = (JSONObject)peopleJSON.get(i);
                String firstName = (String)personJSON.get(OFFICER_FIRST_NAME);
                String lastName = (String)personJSON.get(OFFICER_LAST_NAME);
                int age = (((Long) personJSON.get(OFFICER_AGE)).intValue());
                String sex = (String)personJSON.get(OFFICER_SEX);
                String rank = (String)personJSON.get(OFFICER_RANK);
                String city = (String)personJSON.get(OFFICER_CITY);
                int officeNum = (((Long) personJSON.get(OFFICER_OFFICE_NUM)).intValue());
                String address = (String)personJSON.get(OFFICER_ADDRESS);

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
        reader = new FileReader(WITNESS_FILE_NAME);
        parser = new JSONParser();
        peopleJSON = (JSONArray)parser.parse(reader);
        for(int i=0;i<peopleJSON.size();i++)
        {
            personJSON = (JSONObject)peopleJSON.get(i);
            String firstName = (String)personJSON.get(WITNESS_FIRST_NAME);
            String lastName = (String)personJSON.get(WITNESS_LAST_NAME);
            int age = (((Long) personJSON.get(WITNESS_AGE)).intValue());
            String sex = (String)personJSON.get(WITNESS_SEX);
            String testimony = (String)personJSON.get(WITNESS_TESTIMONY);
            int phoneNum = (((Long) personJSON.get(WITNESS_PHONE_NUM)).intValue());
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
        reader = new FileReader(CASE_FILE_NAME);
        parser = new JSONParser();
        peopleJSON = (JSONArray)parser.parse(reader);

        for(int i=0; i<peopleJSON.size();i++)
        {
            personJSON = (JSONObject)peopleJSON.get(i);
            int caseNum = (((Long) personJSON.get(CASE_CASE_NUM)).intValue());
            String crimeType = (String)personJSON.get(CASE_CRIME_TYPE);
            String date = (String)personJSON.get(CASE_DATE);
            String description = (String)personJSON.get(CASE_DESCRIPTION);
            String location = (String)personJSON.get(CASE_LOCATION);
            jsonPeople = (JSONArray)personJSON.get(CASE_CRIMINALS);
                ArrayList<String> criminals = new ArrayList<String>();
            if(jsonPeople != null)
            {
                for(i=0; i < jsonPeople.size(); i++)
                 {
                    String text  = (String)jsonPeople.get(i);
                    criminals.add(text);
                }
            }
                jsonPeople = (JSONArray)personJSON.get(CASE_VICTIMS);
                ArrayList<String> victims = new ArrayList<String>();
            if(jsonPeople != null)
            {
                for(i=0; i < jsonPeople.size(); i++)
                {
                    String text  = (String)jsonPeople.get(i);
                    victims.add(text);
                }
            }
                jsonPeople = (JSONArray)personJSON.get(CASE_OFFICERS);
                ArrayList<String> officers = new ArrayList<String>();
            if(jsonPeople != null)
            {
                for(i=0; i < jsonPeople.size(); i++)
                 {
                    String text  = (String)jsonPeople.get(i);
                    officers.add(text);
                }
            }
                jsonPeople = (JSONArray)personJSON.get(CASE_WITNESSES);
                ArrayList<String> witnesses = new ArrayList<String>();
            if(jsonPeople != null)
            {
                for(i=0; i < jsonPeople.size(); i++)
                 {
                    String text  = (String)jsonPeople.get(i);
                    witnesses.add(text);
                }
            }

            cases.add(new Case(caseNum, crimeType, date, description, location, criminals, victims, officers, witnesses));
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