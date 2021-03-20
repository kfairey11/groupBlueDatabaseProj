/**
 * A Database Class
 * @author Kennedy
 */
import java.util.*;
public class Database {
    
    /**
     * Gets a list of Users
     * @return ArrayList<User>
     */
    public static ArrayList<User> getUsers()
    {
        return new ArrayList<User>();
    }
    
    /**
     * Gets a list of Person
     * @return ArrayList<Person>
     */
    public static ArrayList<Criminal> getCriminals()
    {
        return new ArrayList<Criminal>();
    }

    public static ArrayList<Victim> getVictims()
    {
        return new ArrayList<Victim>();
    }

    public static ArrayList<Officer> getOfficers()
    {
        return new ArrayList<Officer>();
    }
    public static ArrayList<Witness> getWitnesses()
    {
        return new ArrayList<Witness>();
    }

    /**
     * Gets a list of Cases
     * @return ArrayList<Case>
     */
    public static ArrayList<Case> getCases()
    {
        return new ArrayList<Case>();
    }

}
