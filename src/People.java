/*
    People class
    Author: Kennedy
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

    /**
     * Getter method for the criminal array list
     * @return criminal array list
     */
    public ArrayList<Criminal> getCriminalList()
    {
        return criminalList;
    }

    /**
     * Sets the criminal array list
     * @param criminals
     */
    public void setCriminalList(ArrayList<Criminal> criminals)
    {
        this.criminalList = criminals;
    }

    /**
     * Getter method for the victim array list
     * @return victim array list
     */
    public ArrayList<Victim> getVictimList()
    {
        return victimList;
    }

    /**
     * Sets the victim array list
     * @param victims
     */
    public void setVictimList(ArrayList<Victim> victims)
    {
        this.victimList = victims;
    }

    /**
     * Getter method for the officer array list
     * @return officer array list
     */
    public ArrayList<Officer> getOfficerList()
    {
        return officerList;
    }

    /**
     * Sets the officer array list
     * @param officers
     */
    public void setOfficerList(ArrayList<Officer> officers)
    {
        this.officerList = officers;
    }

    /**
     * Getter method for the witness array list
     * @return witness array list
     */
    public ArrayList<Witness> getWitnessList()
    {
        return witnessList;
    }

    /**
     * Sets the witness array list
     * @param witnesses
     */
    public void setWitnessList(ArrayList<Witness> witnesses)
    {
        this.witnessList = witnesses;
    }

    /**
     * Gets an instance of People()
     * @return people
     */
    //change this to be one method for all types
    public static People getInstance(String personType)
    {
        if(people == null)
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

    /**
     * Searches through victimList to find a certain victim
     * @param name
     * @return boolean
     */
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

    /**
     * Searches through officerList to find a certain officer
     * @param name
     * @return boolean
     */
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

    /**
     * Searches through witnessList to find a certain witness
     * @param name
     * @return boolean
     */
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

    /**
     * Adds a criminal to the criminalList
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
     * @param showSize
     * @param piercings
     * @return boolean; return false if criminal is already in the list, return true if otherwise and criminal is added to the list
     */
    public boolean addCriminal(String firstName, String lastName, int age, String sex, String nickname, String height, double weight, 
    String race, ArrayList<String> tattoos, double shoeSize, ArrayList<String> piercings)
    {
        if(haveCriminal(firstName + " " + lastName))
            return false;
        criminalList.add(new Criminal(firstName, lastName, age, sex, nickname, height, weight, race, tattoos, shoeSize, piercings));
        return true;
    }

    /**
     * Adds a victim to the victimList
     * @param firstName
     * @param lastName
     * @param age
     * @param sex
     * @param report
     * @param hospital
     * @param phoneNum
     * @param address
     * @return boolean; return false if victim is already in the list, return true if otherwise and victim is added to the list
     */
    public boolean addVictim(String firstName, String lastName, int age, String sex, String report, String hospital, int phoneNum, String address)
    {
        if(haveVictim(firstName + " " + lastName))
            return false;
        victimList.add(new Victim(firstName, lastName, age, sex, report, hospital, phoneNum, address));
        return true;
    }

     /**
     * Adds an officer to the officerList
     * @param firstName
     * @param lastName
     * @param age
     * @param sex
     * @param rank
     * @param phoneNum
     * @param address
     * @param city
     * @return boolean; return false if officer is already in the list, return true if otherwise and officer is added to the list
     */
    public boolean addOfficer(String firstName, String lastName, int age, String sex, String rank, int officeNum, String address, String city)
    {
        if(haveOfficer(firstName + " " + lastName))
            return false;
        officerList.add(new Officer(firstName, lastName, age, sex, rank, city, officeNum, address));
        return true;
    }

     /**
     * Adds a witness to the witnessList
     * @param firstName
     * @param lastName
     * @param age
     * @param sex
     * @param testimony
     * @param phoneNum
     * @param address
     * @return boolean; return false if witness is already in the list, return true if otherwise and witness is added to the list
     */
    public boolean addWitness(String firstName, String lastName, int age, String sex, String testimony, int phoneNum, String address)
    {
        if(haveWitness(firstName + " " + lastName))
            return false;
        witnessList.add(new Witness(firstName, lastName, age, sex, testimony, phoneNum, address));
        return true;
    }

    /**
     * Searches and returns a criminal from the criminalList
     * @param name
     * @return Criminal, else returns null if not found
     */
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

    /**
     * Searches and returns a victim from the victimList
     * @param name
     * @return Victim, else returns null if not found
     */
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

    /**
     * Searches and returns an officer from the officerList
     * @param name
     * @return Officer, else returns null if not found
     */
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

    /**
     * Searches and returns a Witness from the witnessList
     * @param name
     * @return Witness, else returns null if not found
     */
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

    public void saveCriminals()
    {
        DataWriter.saveCriminals();
    }

    public void saveVictims()
    {
        DataWriter.saveVictims();
    }

    public void saveOfficers()
    {
        DataWriter.saveOfficers();
    }

    public void saveWitnesses()
    {
        DataWriter.saveWitnesses();
    }
}