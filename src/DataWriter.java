import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class DataWriter extends DataConstants{
    /**
     * instance call for people of class people
     */
    private static People people = People.getInstance();
    
    /**
     * Creating an Json array to save users when creating a profile
     */
    public static void saveUsers()
    {
        Users users = Users.getInstance();
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

    /**
     * a method to put user details within a json file
     * @param user user profile from log in
     * @return user details
     */
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

    /**
     * creates array list of people for criminal data
     */
    public static void saveCriminals()
    {
        ArrayList<Criminal> criminalList = people.getCriminalList();
        JSONArray jsonCriminals = new JSONArray();

        for(int i=0;i<criminalList.size();i++)
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

    /**
     * creation of json object full of criminal details, such as name, age, and sex
     * @param criminal criminal attributes
     * @return criminal detail variable
     */
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
        criminalDetails.put(CRIMINAL_HAIR_COLOR, criminal.getHairColor());
        criminalDetails.put(CRIMINAL_EYE_COLOR, criminal.getEyeColor());
        criminalDetails.put(CRIMINAL_DESCRIPTION, criminal.getDescription());
        //for(int i=0;i<criminal.getTattoos().size();i++)
        criminalDetails.put(CRIMINAL_TATTOOS, criminal.getTattoos());
        criminalDetails.put(CRIMINAL_SHOE_SIZE, criminal.getShoeSize());
        //for(int j=0;j<criminal.getPiercing().size();j++)
        criminalDetails.put(CRIMINAL_PIERCINGS, criminal.getPiercing());
        criminalDetails.put(CRIMINAL_IN_JAIL, jailStatus(criminal));

        return criminalDetails;
    }

    /**
     * checks for if the criminal is in jail
     * @param criminal criminal variable
     * @return boolean inJail status
     */
    private static String jailStatus(Criminal criminal)
    {
        String inJail = "";
        if(criminal.getInJail())
            inJail = "true";
        else    
            inJail = "false";
        return inJail;
    }

    /**
     * creates a person array list for victims
     */
    public static void saveVictims()
    {
        
        ArrayList<Victim> victimsList= people.getVictimList();
        JSONArray jsonVictims = new JSONArray();

        for(int i=0;i<victimsList.size();i++)
            jsonVictims.add(getVictimJSON(victimsList.get(i)));
        
            try(FileWriter file = new FileWriter(VICTIM_FILE_NAME))
            {
                file.write(jsonVictims.toJSONString());
                file.flush();
            }

            catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    /**
     *  creates a json object to fill with information about the victim
     * @param victim victim variable attributes
     * @return victim details
     */
    public static JSONObject getVictimJSON(Victim victim)
    {
        JSONObject victimDetails = new JSONObject();
        victimDetails.put(VICTIM_FIRST_NAME, victim.getFirstName());
        victimDetails.put(VICTIM_LAST_NAME, victim.getLastName());
        victimDetails.put(VICTIM_AGE, victim.getAge());
        victimDetails.put(VICTIM_SEX, victim.getSex());
        victimDetails.put(VICTIM_REPORT, victim.getReport());
        victimDetails.put(VICTIM_HOSPITAL, victim.getHopsital());
        victimDetails.put(VICTIM_PHONE_NUM, victim.getPhoneNum());
        victimDetails.put(VICTIM_ADDRESS, victim.getAddress());

        return victimDetails;
    }

    /**
     * Creates array list of people to save officers 
     */
    public static void saveOfficers()
    {
        ArrayList<Officer> officersList= people.getOfficerList();
        JSONArray jsonOfficers = new JSONArray();

        for(int i=0;i<officersList.size();i++)
            jsonOfficers.add(getOfficerJSON(officersList.get(i)));
        
            try(FileWriter file = new FileWriter(OFFICER_FILE_NAME))
            {
                file.write(jsonOfficers.toJSONString());
                file.flush();
            }

            catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    /**
     * Creates a json object to fill with officer information
     * @param officer officer variable
     * @return officer details
     */
    public static JSONObject getOfficerJSON(Officer officer)
    {
        JSONObject officerDetails = new JSONObject();
        officerDetails.put(OFFICER_FIRST_NAME, officer.getFirstName());
        officerDetails.put(OFFICER_LAST_NAME, officer.getLastName());
        officerDetails.put(OFFICER_AGE, officer.getAge());
        officerDetails.put(OFFICER_SEX, officer.getSex());
        officerDetails.put(OFFICER_RANK, officer.getRank());
        officerDetails.put(OFFICER_CITY, officer.getCity());
        officerDetails.put(OFFICER_OFFICE_NUM, officer.getOfficeNum());
        officerDetails.put(OFFICER_ADDRESS, officer.getOfficeAddress());

        return officerDetails;
    }

    /**
     * Creates array list of people type for witness
     */
    public static void saveWitnesses()
    {
        ArrayList<Witness> witnessesList= people.getWitnessList();
        JSONArray jsonWitnesses = new JSONArray();

        for(int i=0;i<witnessesList.size();i++)
            jsonWitnesses.add(getWitnessJSON(witnessesList.get(i)));
        
            try(FileWriter file = new FileWriter(WITNESS_FILE_NAME))
            {
                file.write(jsonWitnesses.toJSONString());
                file.flush();
            }

            catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    /**
     * creates witness json object to hold information on witness
     * @param witness witness variable
     * @return witness detail
     */
    public static JSONObject getWitnessJSON(Witness witness)
    {
        JSONObject witnessDetails = new JSONObject();
        witnessDetails.put(WITNESS_FIRST_NAME, witness.getFirstName());
        witnessDetails.put(WITNESS_LAST_NAME, witness.getLastName());
        witnessDetails.put(WITNESS_AGE, witness.getAge());
        witnessDetails.put(WITNESS_SEX, witness.getSex());
        witnessDetails.put(WITNESS_TESTIMONY, witness.getTestimony());
        witnessDetails.put(WITNESS_PHONE_NUM, witness.getPhoneNum());
        witnessDetails.put(WITNESS_ADDRESS, witness.getAddress());

        return witnessDetails;
    }

    /**
     * Creates case file to hold case link information
     */
    public static void saveCases()
    {
        Cases cases = Cases.getInstance();
        ArrayList<Case> casesList= cases.getCaseList();
        JSONArray jsonCases = new JSONArray();

        for(int i=0;i<casesList.size();i++)
            jsonCases.add(getCaseJSON(casesList.get(i)));
        
            try(FileWriter file = new FileWriter(CASE_FILE_NAME))
            {
                file.write(jsonCases.toJSONString());
                file.flush();
            }

            catch(Exception e)
            {
                e.printStackTrace();
            }
    }

    /**
     * Creates json object for cases
     * @return case details
     */
    public static JSONObject getCaseJSON(Case cases)
    {
        JSONObject caseDetails = new JSONObject();
        caseDetails.put(CASE_CASE_NUM, cases.getCaseNum());

        caseDetails.put(CASE_CRIME_TYPE, cases.getCrimeType());
        caseDetails.put(CASE_DATE, cases.getDate());
        caseDetails.put(CASE_DESCRIPTION, cases.getDescription());
        caseDetails.put(CASE_LOCATION, cases.getLocation());
        caseDetails.put(CASE_EVIDENCE, cases.getEvidence());
        //for(int i=0;i<cases.getCriminals().size();i++)
        caseDetails.put(CASE_CRIMINALS, cases.getCriminals());
        //for(int j=0;j<cases.getVictims().size();j++)
        caseDetails.put(CASE_VICTIMS, cases.getVictims());
        //for(int k=0;k<cases.getOfficers().size();k++)
        caseDetails.put(CASE_OFFICERS, cases.getOfficers());
        //for(int l=0;l<cases.getWitnesses().size();l++)
        caseDetails.put(CASE_WITNESSES, cases.getWitnesses());

        return caseDetails;
    }


}   
