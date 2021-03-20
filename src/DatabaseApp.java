/**
 * A DatabaseApp Class
 * @author Kennedy
 */
import java.util.*;
public class DatabaseApp {
    
    /**
     * Attributes for a DatabaseApp
     */
    private People criminals;
    private People victims;
    private People officers;
    private People witnesses;
    private Cases cases;
    private Users users;

    /**
     * Constructor for DatabaseApp
     */
    public DatabaseApp()
    {
        criminals = People.getInstance("criminal");
        victims = People.getInstance("victim");
        officers = People.getInstance("officer");
        witnesses = People.getInstance("witness");
        cases = Cases.getInstance();
        users = Users.getInstance();
    }

    /**
     * Creates a criminal
     * @param firstName
     * @param lastName
     * @param age
     * @param sex
     * @param nickname
     * @param feet
     * @param inches
     * @param weight
     * @param race
     * @param tattoos
     * @param shoeSize
     * @param piercings
     */

     public boolean login(String username, String password)
     {
         User user = users.getUser(username);

         if(user == null)
            return false;
        if(user.getPassword().equals("password"))
            return true;
        else    
            return false;
     }

     public boolean createUser(String firstName, String lastName, String userName, String password)
     {
         return users.addUser(firstName, lastName, userName, password);
     }
    public boolean createCriminal(String firstName, String lastName, int age, String sex, String nickname, int feet, int inches,
    double weight, String race, ArrayList<String> tattoos, double shoeSize, ArrayList<String> piercings)
    {
        //adds criminal to the database based on this info
        //need to convert height info into the height format
        //need to add all elements of string arrays into arraylists
        return criminals.addCriminal(firstName, lastName, age, sex, nickname, feet, inches, weight, race, tattoos, shoeSize, piercings);
    }

    /**
     * Creates a Victim
     * @param firstName
     * @param lastName
     * @param age
     * @param sex
     * @param report
     * @param hospital
     * @param phoneNum
     * @param address
     */
    public boolean createVictim(String firstName, String lastName, int age, String sex, String report, String hospital, int phoneNum, 
    String address)
    {
        //adds victim to the database
        return victims.addVictim(firstName, lastName, age, sex, report, hospital, phoneNum, address);
    }

    /**
     * Creates an Officer
     * @param firstName
     * @param lastName
     * @param age
     * @param sex
     * @param rank
     * @param city
     * @param phoneNum
     * @param address
     */
    public boolean createOfficer(String firstName, String lastName, int age, String sex, String rank,String city, int officeNum, String address)
    {
        //adds officer to the database
        return officers.addOfficer(firstName, lastName, age, sex, rank, officeNum, address, city);
    }

    /**
     * Creates a Witness
     * @param firstName
     * @param lastName
     * @param age
     * @param sex
     * @param testimony
     * @param phoneNum
     * @param address
     */
    public boolean createWitness(String firstName, String lastName, int age, String sex, String testimony, int phoneNum, String address)
    {
        //adds witness to the database
        return witnesses.addWitness(firstName, lastName, age, sex, testimony, phoneNum, address);
    }

    /**
     * Creates a Case
     * @param crimeType
     * @param date
     * @param description
     * @param location
     */
    public boolean createCase(String crimeType, int month, int day, int year, String description, String location, ArrayList<String> criminals, ArrayList<String> 
    victims, ArrayList<String> officers, ArrayList<String> witnesses)
    {
        //adds a case to the database
        return cases.addCase(crimeType, month, day, year, description, location, criminals, victims, officers, witnesses);
    }

    /**
     * Changes a Criminal
     * @param criminal
     */
    public void changeCriminal(Criminal criminal)
    {
            Criminal oldCriminal = searchCriminalByName(criminal.getFirstName() + " " + criminal.getLastName());
            String oldCriminalName = oldCriminal.getFirstName() + " " + oldCriminal.getLastName();
            ArrayList<Criminal> criminalList = criminals.getCriminalList();
            
            for(int i=0; i<criminalList.size(); i++)
            {
                if((criminalList.get(i).getFirstName() + " " + criminalList.get(i).getLastName()).equalsIgnoreCase(oldCriminalName))
                {
                    criminalList.set(i, criminal);
                }
            }
            criminals.setCriminalList(criminalList);

    }

    /**
     * Changes a Victim
     * @param victim
     */
    public void changeVictim(Victim victim)
    {
        Victim oldVictim = searchVictimByName(victim.getFirstName() + " " + victim.getLastName());
            String oldVictimName = oldVictim.getFirstName() + " " + oldVictim.getLastName();
            ArrayList<Victim> victimList = victims.getVictimList();
            
            for(int i=0; i<victimList.size(); i++)
            {
                if((victimList.get(i).getFirstName() + " " + victimList.get(i).getLastName()).equalsIgnoreCase(oldVictimName))
                {
                    victimList.set(i, victim);
                }
            }
            victims.setVictimList(victimList);
    }

    /**
     * Changes an Officer
     * @param officer
     */
    public void changeOfficer(Officer officer)
    {
            Officer oldOfficer = searchOfficerByName(officer.getFirstName() + " " + officer.getLastName());
            String oldOfficerName  = oldOfficer.getFirstName() + " " + oldOfficer.getLastName();
            ArrayList<Officer> officerList = officers.getOfficerList();
            
            for(int i=0; i<officerList.size(); i++)
            {
                if((officerList.get(i).getFirstName() + " " + officerList.get(i).getLastName()).equalsIgnoreCase(oldOfficerName))
                {
                    officerList.set(i, officer);
                }
            }
            officers.setOfficerList(officerList);
    }

    /**
     * Changes a Witness
     * @param witness
     */
    public void changeWitness(Witness witness)
    {
        Witness oldWitness = searchWitnessByName(witness.getFirstName() + " " + witness.getLastName());
        String oldWitnessName  = oldWitness.getFirstName() + " " + oldWitness.getLastName();
        ArrayList<Witness> witnessList = witnesses.getWitnessList();
        
        for(int i=0; i<witnessList.size(); i++)
        {
            if((witnessList.get(i).getFirstName() + " " + witnessList.get(i).getLastName()).equalsIgnoreCase(oldWitnessName))
            {
                witnessList.set(i, witness);
            }
        }
        witnesses.setWitnessList(witnessList);
    }

    /**
     * Changes a Case
     * @param caseToChange
     */
    public void changeCase(Case caseToChange)
    {
        //empty stub
    }

    /**
     * Searches for a Criminal
     * @param name
     * @return Criminal
     */
    public Criminal searchCriminalByName(String name)
    {
        return criminals.getCriminal(name);
    }

    /**
     * Searches for a Victim
     * @param name
     * @return Victim
     */
    public Victim searchVictimByName(String name)
    {
        return victims.getVictim(name);
    }

    /**
     * Searches for an Officer
     * @param name
     * @return Officer
     */
    public Officer searchOfficerByName(String name)
    {
        return officers.getOfficer(name);
    }

    /**
     * Searches for a Witness
     * @param name
     * @return Witness
     */
    public Witness searchWitnessByName(String name)
    {
         return witnesses.getWitness(name);
    }

    /**
     * Searches for a Person
     */
    public void searchPerson()
    {
        //empty stub
    }

    /**
     * Searches for a Case
     */
    public void searchCase()
    {
        //empty stub
    }

    /**
     * Searches for a Case by Case Number
     * @param caseNum
     * @return Case
     */
    public Case searchCaseByCaseNum(int caseNum)
    {
        return cases.getCase(caseNum);
    }

    /**
     * Add to a Case
     * @param newCase
     */
    public void addToCase(Case newCase)
    {
        //empty stub
    }


}
