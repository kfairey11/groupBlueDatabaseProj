import java.util.*;
public class DatabaseApp {
    
    private People people;
    private Cases cases;
    private Users users;

    public DatabaseApp()
    {
        people = people.getInstance();
        cases = cases.getInstance();
        users = users.getInstance();
    }

    public void createCriminal(String firstName, String lastName, int age, String sex, String nickname, int feet, int inches,
    double weight, String race, String[] tattoos, double shoeSize, String[] piercings)
    {
        //adds criminal to the database based on this info
        //need to convert height info into the height format
        //need to add all elements of string arrays into arraylists
    }

    public void createVictim(String firstName, String lastName, int age, String sex, String report, String hospital, int phoneNum, 
    String address)
    {
        //adds victim to the database
    }

    public void createOfficer(String firstName, String lastName, int age, String sex, String rank,String city, int phoneNum, String address)
    {
        //adds officer to the database
    }

    public void createWitness(String firstName, String lastName, int age, String sex, String testimony, int phoneNum, String address)
    {
        //adds witness to the database
    }

    public void createCase(String crimeType, String date, String description, String location)
    {
        //adds a case to the database
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
    public Criminal searchCriminalByName(String name)
    {
        //empty stub
        return null;
    }

    public Victim searchVictimByName(String name)
    {
        //empty stub
        return null;
    }

    public Officer searchOfficerByName(String name)
    {
        //empty stub
        return null;
    }

    public Witness searchWitnessByName(String name)
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


    public void addToCase(Case newCase)
    {
        //empty stub
    }


}
