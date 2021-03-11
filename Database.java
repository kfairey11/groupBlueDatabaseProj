import java.util.*;
public class Database {
    
    private ArrayList<Person> people;
    private ArrayList<Case> cases;
    private static Database database;

    private Database(ArrayList<Person> people, ArrayList<Case> cases)
    {}

    public static Database getInstance()
    {
        //empty stub
        return database;
    }

    public void changeCriminal(Criminal criminal)
    {
        //empty stub
    }

    public void changeVictim(Victim victim)
    {
        //empty stub
    }

    public void changeOfficer(Officer officer)
    {
        //empty stub
    }

    public void changeWitness(Witness witness)
    {
        //empty stub
    }

    public Criminal searchCriminalByLastName(String name)
    {
        //empty stub
        return null;
    }

    public Victim searchVictimByLastName(String name)
    {
        //empty stub
        return null;
    }

    public Officer searchOfficerByLastName(String name)
    {
        //empty stub
        return null;
    }

    public Witness searchWitnessByLastName(String name)
    {
        //empty stub 
        return null;
    }

    public void searchPerson()
    {
        //empty stub
    }

    public void searchCase()
    {
        //empty stub
    }

    public Case searchCaseByCaseNum(int caseNum)
    {
        //empty stub
        return null;
    }
    public void addToPeople(Person person)
    {
        //empty stub
    }

    public void addToCase(Case case)
    {
        //empty stub
    }


}
