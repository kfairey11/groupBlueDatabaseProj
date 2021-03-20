/**
 * People Class
 * @Author Kennedy
 */
import java.util.ArrayList;
//will probably have to make 5 different classes for each type of person
public class People {
    private static People people;
    private ArrayList<Criminal> criminalList;
    private ArrayList<Victim> victimList;
    private ArrayList<Officer> officerList;
    private ArrayList<Witness> witnessList;

    /**
     * Constructor for People
     */
    private People(String personType)
    {
        if(personType.equalsIgnoreCase("criminal"))
           criminalList = DataLoader.getCriminals();
        else if(personType.equalsIgnoreCase("victim"))
            victimList = DataLoader.getVictims();
        else if(personType.equalsIgnoreCase("officer"))
            officerList = DataLoader.getOfficers();
        else if(personType.equalsIgnoreCase("witness"))
            witnessList = DataLoader.getWitnesses();
    }

    public ArrayList<Criminal> getCriminalList()
    {
        return criminalList;
    }

    public void setCriminalList(ArrayList<Criminal> criminals)
    {
        this.criminalList = criminals;
    }


    public ArrayList<Victim> getVictimList()
    {
        return victimList;
    }

    public void setVictimList(ArrayList<Victim> victims)
    {
        this.victimList = victims;
    }

    public ArrayList<Officer> getOfficerList()
    {
        return officerList;
    }

    public void setOfficerList(ArrayList<Officer> officers)
    {
        this.officerList = officers;
    }

    public ArrayList<Witness> getWitnessList()
    {
        return witnessList;
    }

    public void setWitnessList(ArrayList<Witness> witnesses)
    {
        this.witnessList = witnesses;
    }

    /**
     * Gets an instance of People()
     * @return people
     */
    public static People getInstance(String personType)
    {
        if(people == null && personType.equalsIgnoreCase("criminal"))
            people = new People(personType);
        return people;
    }

    /**
     * Searches through personList to find a certain person
     * @param name
     * @return boolean
     */
    public boolean haveCriminal(String name)
    {
        for(int i=0;i<criminalList.size();i++)
        {
            String fullName = ((criminalList.get(i)).getFirstName() + " " + (criminalList.get(i)).getLastName());
            if(name.equalsIgnoreCase(fullName))
                return true;
        }
        return false;
    }

    public boolean haveVictim(String name)
    {
        for(int i=0;i<victimList.size();i++)
        {
            String fullName = ((victimList.get(i)).getFirstName() + " " + (victimList.get(i)).getLastName());
            if(name.equalsIgnoreCase(fullName))
                return true;
        }
        return false;
    }

    public boolean haveOfficer(String name)
    {
        for(int i=0;i<officerList.size();i++)
        {
            String fullName = ((officerList.get(i)).getFirstName() + " " + (officerList.get(i)).getLastName());
            if(name.equalsIgnoreCase(fullName))
                return true;
        }
        return false;
    }

    public boolean haveWitness(String name)
    {
        for(int i=0;i<witnessList.size();i++)
        {
            String fullName = ((witnessList.get(i)).getFirstName() + " " + (witnessList.get(i)).getLastName());
            if(name.equalsIgnoreCase(fullName))
                return true;
        }
        return false;
    }    

    public boolean addCriminal(String firstName, String lastName, int age, String sex, String nickname, int feet, int inches, double weight, 
    String race, ArrayList<String> tattoos, double shoeSize, ArrayList<String> piercings)
    {
        if(haveCriminal(firstName + " " + lastName))
            return false;
        
        criminalList.add(new Criminal(firstName, lastName, age, sex, nickname, feet, inches, weight, race, tattoos, shoeSize, piercings));
        return true;
    }

    public boolean addVictim(String firstName, String lastName, int age, String sex, String report, String hospital, int phoneNum, String address)
    {
        if(haveVictim(firstName + " " + lastName))
            return false;
        victimList.add(new Victim(firstName, lastName, age, sex, report, hospital, phoneNum, address));
        return true;
    }

    public boolean addOfficer(String firstName, String lastName, int age, String sex, String rank, int officeNum, String address, String city)
    {
        if(haveOfficer(firstName + " " + lastName))
            return false;
        officerList.add(new Officer(firstName, lastName, age, sex, rank, city, officeNum, address));
        return true;
    }

    public boolean addWitness(String firstName, String lastName, int age, String sex, String testimony, int phoneNum, String address)
    {
        if(haveWitness(firstName + " " + lastName))
            return false;
        witnessList.add(new Witness(firstName, lastName, age, sex, testimony, phoneNum, address));
        return true;
    }

    public Criminal getCriminal(String name)
    {
        for(Criminal criminal : criminalList)
        {
            String fullName = criminal.getFirstName() + " " + criminal.getLastName();
            if(fullName.equalsIgnoreCase(name))
                return criminal;
        }
        return null;
    }

    public Victim getVictim(String name)
    {
        for(Victim victim : victimList)
        {
            String fullName = victim.getFirstName() + " " + victim.getLastName();
            if(fullName.equalsIgnoreCase(name))
                return victim;
        }
        return null;
    }

    public Officer getOfficer(String name)
    {
        for(Officer officer : officerList)
        {
            String fullName = officer.getFirstName() + " " + officer.getLastName();
            if(fullName.equalsIgnoreCase(name))
                return officer;
        }
        return null;
    }

    public Witness getWitness(String name)
    {
        for(Witness witness : witnessList)
        {
            String fullName = witness.getFirstName() + " " + witness.getLastName();
            if(fullName.equalsIgnoreCase(name))
                return witness;
        }
        return null;
    }

    //possibly getItem()?
}