import java.util.*;
public class Database {
    
    private static ArrayList<Person> people;
    private static ArrayList<Case> cases;
    private static Database database;

    private Database(ArrayList<Person> people, ArrayList<Case> cases)
    {}

    public static Database getInstance()
    {
        //creates one database
        if(database == null) 
            database = new Database(people, cases);
        return database;
    }

    public void changeCriminal(Person criminal)
    {
        //empty stub
    }

    public void changeVictim(Person victim)
    {
        //empty stub
    }

    public void changeOfficer(Person officer)
    {
        //empty stub
    }

    public void changeWitness(Person witness)
    {
        //empty stub
    }

    public void changeCase(Case caseToChange)
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

    public void addToCase(Case newCase)
    {
        //empty stub
    }


}
