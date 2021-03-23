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
    private static JSONArray jsonPeople;
    private static JSONArray jsonTattoos;
    private static JSONArray jsonPiercings;

    public static void main(String[] args)
    {
        ArrayList<User> user = getUsers();
        ArrayList<Criminal> criminals = getCriminals();
        ArrayList<Victim> victims = getVictims();
        ArrayList<Officer> officers = getOfficers();
        ArrayList<Witness> witnesses = getWitnesses(); 
        ArrayList<Case> cases = getCases();
        System.out.println(user.get(0).getUserName());
        criminals.get(0).print();
        victims.get(0).print();
        officers.get(0).print();
        witnesses.get(0).print();
        cases.get(0).print();
    }
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
            reader = new FileReader(CRIMINAL_FILE_NAME);
            parser = new JSONParser();
            peopleJSON = (JSONArray)parser.parse(reader);

            for(int i=0; i<peopleJSON.size(); i++)
            {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
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
                for(int j=0; j < jsonTattoos.size(); j++)
                 {
                    String text  = (String)jsonTattoos.get(j);
                    tattoos.add(text);
                }

                double shoeSize = ((Number)personJSON.get(CRIMINAL_SHOE_SIZE)).doubleValue();
                jsonPiercings = (JSONArray)personJSON.get(CRIMINAL_PIERCINGS);
                ArrayList<String> piercings = new ArrayList<String>();
                for(int k=0; k < jsonPiercings.size(); k++)
                 {
                    String text  = (String)jsonPiercings.get(k);
                    tattoos.add(text);
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
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
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
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
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
            JSONObject personJSON = (JSONObject)peopleJSON.get(i);
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
            JSONObject personJSON = (JSONObject)peopleJSON.get(i);
            int caseNum = (((Long) personJSON.get(CASE_CASE_NUM)).intValue());
            String crimeType = (String)personJSON.get(CASE_CRIME_TYPE);
            String date = (String)personJSON.get(CASE_DATE);
            String description = (String)personJSON.get(CASE_DESCRIPTION);
            String location = (String)personJSON.get(CASE_LOCATION);
            jsonPeople = (JSONArray)personJSON.get(CASE_CRIMINALS);
                ArrayList<String> criminals = new ArrayList<String>();
                for(int j=0; j < jsonPeople.size(); j++)
                 {
                    String text  = (String)jsonPeople.get(j);
                    criminals.add(text);
                }
                jsonPeople = (JSONArray)personJSON.get(CASE_VICTIMS);
                ArrayList<String> victims = new ArrayList<String>();
                for(int k=0; k < jsonPeople.size(); k++)
                {
                    String text  = (String)jsonPeople.get(k);
                    victims.add(text);
                }
                jsonPeople = (JSONArray)personJSON.get(CASE_OFFICERS);
                ArrayList<String> officers = new ArrayList<String>();
                for(int l=0; l < jsonPeople.size(); l++)
                 {
                    String text  = (String)jsonPeople.get(l);
                    officers.add(text);
                }
                jsonPeople = (JSONArray)personJSON.get(CASE_WITNESSES);
                ArrayList<String> witnesses = new ArrayList<String>();
                for(int m=0; m < jsonPeople.size(); m++)
                 {
                    String text  = (String)jsonPeople.get(m);
                    witnesses.add(text);
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