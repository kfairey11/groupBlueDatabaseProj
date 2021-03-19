/**
 * A DatabaseApp Class
 * @author Kennedy
 */
import java.util.*;
public class DatabaseApp {
    
    /**
     * Attributes for a DatabaseApp
     */
    private People people;
    private Cases cases;
    private Users users;

    /**
     * Constructor for DatabaseApp
     */
    public DatabaseApp()
    {
        people = People.getInstance();
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
    public void createCriminal(String firstName, String lastName, int age, String sex, String nickname, int feet, int inches,
    double weight, String race, String[] tattoos, double shoeSize, String[] piercings)
    {
        //adds criminal to the database based on this info
        //need to convert height info into the height format
        //need to add all elements of string arrays into arraylists
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
    public void createVictim(String firstName, String lastName, int age, String sex, String report, String hospital, int phoneNum, 
    String address)
    {
        //adds victim to the database
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
    public void createOfficer(String firstName, String lastName, int age, String sex, String rank,String city, int phoneNum, String address)
    {
        //adds officer to the database
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
    public void createWitness(String firstName, String lastName, int age, String sex, String testimony, int phoneNum, String address)
    {
        //adds witness to the database
    }

    /**
     * Creates a Case
     * @param crimeType
     * @param date
     * @param description
     * @param location
     */
    public void createCase(String crimeType, String date, String description, String location, ArrayList<String> criminals, ArrayList<String> 
    victims, ArrayList<String> officers, ArrayList<String> witnesses)
    {
        //adds a case to the database
    }

    /**
     * Changes a Criminal
     * @param criminal
     */
    public void changeCriminal(Person criminal)
    {
        //empty stub
    }

    /**
     * Changes a Victim
     * @param victim
     */
    public void changeVictim(Person victim)
    {
        //empty stub
    }

    /**
     * Changes an Officer
     * @param officer
     */
    public void changeOfficer(Person officer)
    {
        //empty stub
    }

    /**
     * Changes a Witness
     * @param witness
     */
    public void changeWitness(Person witness)
    {
        //empty stub
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
        //empty stub
        return null;
    }

    /**
     * Searches for a Victim
     * @param name
     * @return Victim
     */
    public Victim searchVictimByName(String name)
    {
        //empty stub
        return null;
    }

    /**
     * Searches for an Officer
     * @param name
     * @return Officer
     */
    public Officer searchOfficerByName(String name)
    {
        //empty stub
        return null;
    }

    /**
     * Searches for a Witness
     * @param name
     * @return Witness
     */
    public Witness searchWitnessByName(String name)
    {
        //empty stub 
        return null;
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
        //empty stub
        return null;
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
