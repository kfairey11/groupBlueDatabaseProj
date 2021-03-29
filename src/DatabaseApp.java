/**
 * A DatabaseApp Class
 * @author Kennedy
 */
import java.util.*;
import java.io.*;
public class DatabaseApp {
    
    /**
     * Attributes for DatabaseApp
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
     * Logs in a user
     * @param username
     * @param password
     * @return boolean; true if found user's username and password match, false if otherwise
     */
     public boolean login(String username, String password)
     {
         User user = users.getUser(username);

         if(user == null)
            return false;
        if(user.getPassword().equals(password))
            return true;
        else    
            return false;
     }

     /**
      * Creates a user
      * @param firstName
      * @param lastName
      * @param userName
      * @param password
      * @return boolean
      */

     public boolean createUser(UUID userID, String firstName, String lastName, String userName, String password)
     {
         return users.addUser(userID, firstName, lastName, userName, password);
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
     * @return boolean
     */

    public boolean createCriminal(String firstName, String lastName, int age, String sex, String nickname, String height,
    double weight, String race, String hairColor, String eyeColor, String description, ArrayList<String> tattoos, double shoeSize, ArrayList<String> piercings, boolean inJail)
    {
        //adds criminal to the database based on this info
        //need to convert height info into the height format
        //need to add all elements of string arrays into arraylists
        return people.addCriminal(firstName, lastName, age, sex, nickname, height, weight, race,hairColor, eyeColor, description, tattoos, shoeSize, piercings, inJail);
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
     * @return boolean
     */
    public boolean createVictim(String firstName, String lastName, int age, String sex, String report, String hospital, long phoneNum, 
    String address)
    {
        //adds victim to the database
        return people.addVictim(firstName, lastName, age, sex, report, hospital, phoneNum, address);
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
     * @return boolean
     */
    public boolean createOfficer(String firstName, String lastName, int age, String sex, String rank,String city, long officeNum, String address)
    {
        //adds officer to the database
        return people.addOfficer(firstName, lastName, age, sex, rank, officeNum, address, city);
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
    public boolean createWitness(String firstName, String lastName, int age, String sex, String testimony, long phoneNum, String address)
    {
        //adds witness to the database
        return people.addWitness(firstName, lastName, age, sex, testimony, phoneNum, address);
    }

    /**
     * Creates a Case
     * @param crimeType
     * @param date
     * @param description
     * @param location
     */
    public boolean createCase(int caseNum, String crimeType, String date, String description, String location, ArrayList<String> evidence, ArrayList<String> criminals, ArrayList<String> 
    victims, ArrayList<String> officers, ArrayList<String> witnesses)
    {
        //adds a case to the database
        return cases.addCase(caseNum, crimeType, date, description, location, evidence,  criminals, victims, officers, witnesses);
    }

    /**
     * Changes a Criminal
     * @param criminal
     */
    public void changeCriminal(Criminal criminal)
    {
            Criminal oldCriminal = searchCriminalByName(criminal.getFirstName() + " " + criminal.getLastName());
            String oldCriminalName = oldCriminal.getFirstName() + " " + oldCriminal.getLastName();
            ArrayList<Criminal> criminalList = people.getCriminalList();
            
            for(int i=0; i<criminalList.size(); i++)
            {
                if((criminalList.get(i).getFirstName() + " " + criminalList.get(i).getLastName()).equalsIgnoreCase(oldCriminalName))
                {
                    criminalList.set(i, criminal);
                }
            }
            people.setCriminalList(criminalList);

    }

    /**
     * Changes a Victim
     * @param victim
     */
    public void changeVictim(Victim victim)
    {
        Victim oldVictim = searchVictimByName(victim.getFirstName() + " " + victim.getLastName());
            String oldVictimName = oldVictim.getFirstName() + " " + oldVictim.getLastName();
            ArrayList<Victim> victimList = people.getVictimList();
            
            for(int i=0; i<victimList.size(); i++)
            {
                if((victimList.get(i).getFirstName() + " " + victimList.get(i).getLastName()).equalsIgnoreCase(oldVictimName))
                {
                    victimList.set(i, victim);
                }
            }
            people.setVictimList(victimList);
    }

    /**
     * Changes an Officer
     * @param officer
     */
    public void changeOfficer(Officer officer)
    {
            Officer oldOfficer = searchOfficerByName(officer.getFirstName() + " " + officer.getLastName());
            String oldOfficerName  = oldOfficer.getFirstName() + " " + oldOfficer.getLastName();
            ArrayList<Officer> officerList = people.getOfficerList();
            
            for(int i=0; i<officerList.size(); i++)
            {
                if((officerList.get(i).getFirstName() + " " + officerList.get(i).getLastName()).equalsIgnoreCase(oldOfficerName))
                {
                    officerList.set(i, officer);
                }
            }
            people.setOfficerList(officerList);
    }

    /**
     * Changes a Witness
     * @param witness
     */
    public void changeWitness(Witness witness)
    {
        Witness oldWitness = searchWitnessByName(witness.getFirstName() + " " + witness.getLastName());
        String oldWitnessName  = oldWitness.getFirstName() + " " + oldWitness.getLastName();
        ArrayList<Witness> witnessList = people.getWitnessList();
        
        for(int i=0; i<witnessList.size(); i++)
        {
            if((witnessList.get(i).getFirstName() + " " + witnessList.get(i).getLastName()).equalsIgnoreCase(oldWitnessName))
                witnessList.set(i, witness);
        }
        people.setWitnessList(witnessList);
    }

    /**
     * Changes a Case
     * @param caseToChange
     */
    public void changeCase(Case caseToChange)
    {
        Case oldCase = searchCaseByCaseNum(caseToChange.getCaseNum());
        int oldCaseNum = oldCase.getCaseNum();
        ArrayList<Case> caseList = cases.getCaseList();

        for(int i=0; i<caseList.size(); i++)
        {
            if(caseList.get(i).getCaseNum() == oldCaseNum)
                caseList.set(i, caseToChange);
        }
        cases.setCaseList(caseList);
    }

    /**
     * Searches for a Criminal
     * @param name
     * @return Criminal
     */
    public Criminal searchCriminalByName(String name)
    {
        return people.getCriminal(name);
    }

    /**
     * Searches for a Victim
     * @param name
     * @return Victim
     */
    public Victim searchVictimByName(String name)
    {
        return people.getVictim(name);
    }

    /**
     * Searches for an Officer
     * @param name
     * @return Officer
     */
    public Officer searchOfficerByName(String name)
    {
        return people.getOfficer(name);
    }

    /**
     * Searches for a Witness
     * @param name
     * @return Witness
     */
    public Witness searchWitnessByName(String name)
    {
         return people.getWitness(name);
    }

    /**
     * Searches for a Criminal using their first name
     * @param firstName
     * @return array list of possible criminals with the matching first name
     */
    public ArrayList<Criminal> searchCriminalByFirstName(String firstName)
    {
        ArrayList<Criminal> criminalMatches = new ArrayList<Criminal>();
        ArrayList<Criminal> currentCriminals = people.getCriminalList();

        for(int i=0; i<currentCriminals.size();i++)
        {
            if(currentCriminals.get(i).getFirstName().equalsIgnoreCase(firstName))
                criminalMatches.add(currentCriminals.get(i));
        }
        return criminalMatches;
    }

    /**
     * Searches for a Criminal using their last name
     * @param lastName
     * @return array list of possible criminals with the matching last name
     */
    public ArrayList<Criminal> searchCriminalByLastName(String lastName)
    {
        ArrayList<Criminal> criminalMatches = new ArrayList<Criminal>();
        ArrayList<Criminal> currentCriminals = people.getCriminalList();

        for(int i=0; i<currentCriminals.size(); i++)
        {
            if(currentCriminals.get(i).getLastName().equalsIgnoreCase(lastName))
                criminalMatches.add(currentCriminals.get(i));
        }
        return criminalMatches;
    }

    /**
     * Searches for a Criminal using an age range
     * @param lowAge
     * @param highAge
     * @return array list of possible criminals within the matching age range
     */
    public ArrayList<Criminal> searchCriminalByAge(int lowAge, int highAge)
    {
        ArrayList<Criminal> criminalMatches = new ArrayList<Criminal>();
        ArrayList<Criminal> currentCriminals = people.getCriminalList();

        for(int i=0; i<currentCriminals.size(); i++)
        {
            if(currentCriminals.get(i).getAge() >= lowAge && currentCriminals.get(i).getAge() <= highAge)
                criminalMatches.add(currentCriminals.get(i));
        }
        return criminalMatches;
    }

    /**
     * Searches for a Criminal using their sex
     * @param sex
     * @return array list of possible criminals with the matching sex
     */
    public ArrayList<Criminal> searchCriminalBySex(String sex)
    {
        ArrayList<Criminal> criminalMatches = new ArrayList<Criminal>();
        ArrayList<Criminal> currentCriminals = people.getCriminalList();

        for(int i=0; i<currentCriminals.size(); i++)
        {
            if(currentCriminals.get(i).getSex().equalsIgnoreCase(sex))
                criminalMatches.add(currentCriminals.get(i));
        }
        return criminalMatches;
    }

    /**
     * Searches for a Criminal using their nickname
     * @param nickname
     * @return array list of possible criminals with the matching nickname
     */
    public ArrayList<Criminal> searchCriminalByNickname(String nickname)
    {
        ArrayList<Criminal> criminalMatches = new ArrayList<Criminal>();
        ArrayList<Criminal> currentCriminals = people.getCriminalList();

        for(int i=0; i<currentCriminals.size(); i++)
        {
            if(currentCriminals.get(i).getNickname().equalsIgnoreCase(nickname))
                criminalMatches.add(currentCriminals.get(i));
        }
        return criminalMatches;
    }

    /**
     * Searches for a Criminal using their height
     * @param feet
     * @param inches
     * @return array list of possible criminals with the matching height
     */
    public ArrayList<Criminal> searchCriminalByHeight(int feet, int inches)
    {
        ArrayList<Criminal> criminalMatches = new ArrayList<Criminal>();
        ArrayList<Criminal> currentCriminals = people.getCriminalList();
        String height = feet + "'" + inches + "\"";

        for(int i=0; i<currentCriminals.size(); i++)
        {
            if(currentCriminals.get(i).getHeight().equalsIgnoreCase(height))
                criminalMatches.add(currentCriminals.get(i));
        }
        return criminalMatches;
    }

    /**
     * Searches for a Criminal using a weight range
     * @param lowWeight
     * @param highWeight
     * @return array list of possible criminals within the matching weight range
     */
    public ArrayList<Criminal> searchCriminalByWeight(double lowWeight, double highWeight)
    {
        ArrayList<Criminal> criminalMatches = new ArrayList<Criminal>();
        ArrayList<Criminal> currentCriminals = people.getCriminalList();

        for(int i=0; i<currentCriminals.size(); i++)
        {
            if(currentCriminals.get(i).getWeight() >= lowWeight && currentCriminals.get(i).getWeight() <= highWeight)
                criminalMatches.add(currentCriminals.get(i));
        }
        return criminalMatches;
    }

    /**
     * Searches for a Criminal using their race
     * @param race
     * @return array list of possible criminals that match the race
     */
    public ArrayList<Criminal> searchCriminalByRace(String race)
    {
        ArrayList<Criminal> criminalMatches = new ArrayList<Criminal>();
        ArrayList<Criminal> currentCriminals = people.getCriminalList();

        for(int i=0; i<currentCriminals.size(); i++)
        {
            if(currentCriminals.get(i).getRace().equalsIgnoreCase(race))
                criminalMatches.add(currentCriminals.get(i));
        }
        return criminalMatches;
    }

    /**
     * Searches for a Criminal using their hair color
     * @param hairColor
     * @return array list of possible criminals that match the hair color
     */
    public ArrayList<Criminal> searchCriminalByHairColor(String hairColor)
    {
        ArrayList<Criminal> criminalMatches = new ArrayList<Criminal>();
        ArrayList<Criminal> currentCriminals = people.getCriminalList();

        for(int i=0; i<currentCriminals.size(); i++)
        {
            if(currentCriminals.get(i).getHairColor().equalsIgnoreCase(hairColor))
                criminalMatches.add(currentCriminals.get(i));
        }
        return criminalMatches;
    }

    /**
     * Searches for a Criminal using their eye color
     * @param eyeColor
     * @return array list of possible criminals that match the eye color
     */
    public ArrayList<Criminal> searchCriminalByEyeColor(String eyeColor)
    {
        ArrayList<Criminal> criminalMatches = new ArrayList<Criminal>();
        ArrayList<Criminal> currentCriminals = people.getCriminalList();

        for(int i=0; i<currentCriminals.size(); i++)
        {
            if(currentCriminals.get(i).getEyeColor().equalsIgnoreCase(eyeColor))
                criminalMatches.add(currentCriminals.get(i));
        }
        return criminalMatches;
    }


    /**
     * Searches for a Criminal using their tattoos
     * @param tattoo
     * @return array list of possible criminals with the matching tattoo
     */
    public ArrayList<Criminal> searchCriminalByTattoo(String tattoo)
    {
        ArrayList<Criminal> criminalMatches = new ArrayList<Criminal>();
        ArrayList<Criminal> currentCriminals = people.getCriminalList();

        for(int i=0; i<currentCriminals.size(); i++)
        {
            ArrayList<String> tattoos = currentCriminals.get(i).getTattoos();
            for(int j=0; j<tattoos.size(); j++)
            {
                if(tattoos.get(j).equalsIgnoreCase(tattoo))
                    criminalMatches.add(currentCriminals.get(i));
            }
        }
        return criminalMatches;
    }

    /**
     * Searches for a Criminal using a their range of a shoe size
     * @param lowShoeSize
     * @param highShoeSize
     * @return array list of possible criminals within the matching shoe size range
     */
    public ArrayList<Criminal> searchCriminalByShoeSize(double lowShoeSize, double highShoeSize)
    {
        ArrayList<Criminal> criminalMatches = new ArrayList<Criminal>();
        ArrayList<Criminal> currentCriminals = people.getCriminalList();

        for(int i=0; i<currentCriminals.size(); i++)
        {
            if(currentCriminals.get(i).getShoeSize() >= lowShoeSize && currentCriminals.get(i).getShoeSize() <= highShoeSize)
                criminalMatches.add(currentCriminals.get(i));
        }
        return criminalMatches;
    }

    /**
     * Searches for a Criminal using their piercing
     * @param piercing
     * @return array list of possible criminals with the matching piercing
     */
    public ArrayList<Criminal> searchCriminalByPiercing(String piercing)
    {
        ArrayList<Criminal> criminalMatches = new ArrayList<Criminal>();
        ArrayList<Criminal> currentCriminals = people.getCriminalList();
        ArrayList<String> piercings = new ArrayList<String>();
        for(int i=0; i<currentCriminals.size(); i++)
        {
            piercings = currentCriminals.get(i).getPiercing();
            
            for(int j=0; j<piercings.size(); j++)
            {
                if(piercings.get(j).equalsIgnoreCase(piercing))
                    criminalMatches.add(currentCriminals.get(i));
            }
            
        }

        return criminalMatches;
    }

    /**
     * Searches for a Criminal based on if they're in jail
     * @param inJail
     * @return array list of possible criminals that are in jail
     */
    public ArrayList<Criminal> searchCriminalInJail(boolean inJail)
    {
        ArrayList<Criminal> criminalMatches = new ArrayList<Criminal>();
        ArrayList<Criminal> currentCriminals = people.getCriminalList();

        for(int i=0; i<currentCriminals.size(); i++)
        {
            if(currentCriminals.get(i).getInJail() == inJail)
                criminalMatches.add(currentCriminals.get(i));
        }
        return criminalMatches;
    }

    /**
     * Searches for a Criminal based on if they're underage
     * @return array list of possible criminals that are underage
     */
    public ArrayList<Criminal> searchCriminalByUnderage()
    {
        ArrayList<Criminal> criminalMatches = new ArrayList<Criminal>();
        ArrayList<Criminal> currentCriminals = people.getCriminalList();

        for(int i=0; i<currentCriminals.size(); i++)
        {
            if(currentCriminals.get(i).getAge() < 18)
                criminalMatches.add(currentCriminals.get(i));
        }
        return criminalMatches;
    }

    /**
     * Searches for a Victim using their first name
     * @param firstName
     * @return array list of possible victims that match the first name
     */
    public ArrayList<Victim> searchVictimByFirstName(String firstName)
    {
        ArrayList<Victim> victimMatches = new ArrayList<Victim>();
        ArrayList<Victim> currentVictims = people.getVictimList();

        for(int i=0; i<currentVictims.size(); i++)
        {
            if(currentVictims.get(i).getFirstName().equalsIgnoreCase(firstName))
                victimMatches.add(currentVictims.get(i));
        }
        return victimMatches;
    }

    /**
     * Searches for a Victim using their last name
     * @param lastName
     * @return array list of possible victims that match the last name
     */
    public ArrayList<Victim> searchVictimByLastName(String lastName)
    {
        ArrayList<Victim> victimMatches = new ArrayList<Victim>();
        ArrayList<Victim> currentVictims = people.getVictimList();

        for(int i=0; i<currentVictims.size(); i++)
        {
            if(currentVictims.get(i).getLastName().equalsIgnoreCase(lastName))
                victimMatches.add(currentVictims.get(i));
        }
        return victimMatches;
    }

    /**
     * Searches for a Victim using the age range
     * @param lowAge
     * @param highAge 
     * @return array list of possible victims that match the age range
     */
    public ArrayList<Victim> searchVictimByAge(int lowAge, int highAge)
    {
        ArrayList<Victim> victimMatches = new ArrayList<Victim>();
        ArrayList<Victim> currentVictims = people.getVictimList();

        for(int i=0; i<currentVictims.size(); i++)
        {
            if(currentVictims.get(i).getAge() >= lowAge && currentVictims.get(i).getAge() <= highAge)
                victimMatches.add(currentVictims.get(i));
        }
        return victimMatches;
    }

    /**
     * Searches for a Victim using their sex
     * @param sex
     * @return array list of possible victims that match the sex
     */
    public ArrayList<Victim> searchVictimBySex(String sex)
    {
        ArrayList<Victim> victimMatches = new ArrayList<Victim>();
        ArrayList<Victim> currentVictims = people.getVictimList();

        for(int i=0; i<currentVictims.size(); i++)
        {
            if(currentVictims.get(i).getSex().equalsIgnoreCase(sex))
                victimMatches.add(currentVictims.get(i));
        }
        return victimMatches;
    }

    /**
     * Searches for a Victim based on their hospital
     * @param hospital
     * @return array list of possible victims that match the hospital
     */
    public ArrayList<Victim> searchVictimByHospital(String hospital)
    {
        ArrayList<Victim> victimMatches = new ArrayList<Victim>();
        ArrayList<Victim> currentVictims = people.getVictimList();

        for(int i=0; i<currentVictims.size(); i++)
        {
            if(currentVictims.get(i).getHopsital().equalsIgnoreCase(hospital))
                victimMatches.add(currentVictims.get(i));
        }
        return victimMatches;
    }

    /**
     * Searches for a Victim using their phone number
     * @param phoneNum
     * @return array list of possible victims that match the phone number
     */
    public ArrayList<Victim> searchVictimByPhoneNum(long phoneNum)
    {
        ArrayList<Victim> victimMatches = new ArrayList<Victim>();
        ArrayList<Victim> currentVictims = people.getVictimList();

        for(int i=0; i<currentVictims.size(); i++)
        {
            if(currentVictims.get(i).getPhoneNum() == phoneNum)
                victimMatches.add(currentVictims.get(i));
        }
        return victimMatches;
    }

    /**
     * Searches for a Victim based on their address
     * @param address
     * @return array list of possible victims that match the address
     */
    public ArrayList<Victim> searchVictimByAddress(String address)
    {
        ArrayList<Victim> victimMatches = new ArrayList<Victim>();
        ArrayList<Victim> currentVictims = people.getVictimList();

        for(int i=0; i<currentVictims.size(); i++)
        {
            if(currentVictims.get(i).getAddress().equalsIgnoreCase(address))
                victimMatches.add(currentVictims.get(i));
        }
        return victimMatches;
    }

    /**
     * Searches for an Officer using their first name
     * @param firstName
     * @return array list of possible Officers that match the first name
     */
    public ArrayList<Officer> searchOfficerByFirstName(String firstName)
    {
        ArrayList<Officer> officerMatches = new ArrayList<Officer>();
        ArrayList<Officer> currentOfficers = people.getOfficerList();

        for(int i=0; i<currentOfficers.size(); i++)
        {
            if(currentOfficers.get(i).getFirstName().equalsIgnoreCase(firstName))
                officerMatches.add(currentOfficers.get(i));
        }
        return officerMatches;
    }

    /**
     * Searches for an Officer using their last name
     * @param lastName
     * @return array list of possible Officers that match the last name
     */
    public ArrayList<Officer> searchOfficerByLastName(String lastName)
    {
        ArrayList<Officer> officerMatches = new ArrayList<Officer>();
        ArrayList<Officer> currentOfficers = people.getOfficerList();

        for(int i=0; i<currentOfficers.size(); i++)
        {
            if(currentOfficers.get(i).getLastName().equalsIgnoreCase(lastName))
                officerMatches.add(currentOfficers.get(i));
        }
        return officerMatches;
    }

    /**
     * Searches for an Officer using an age range
     * @param lowAge
     * @param highAge
     * @return array list of possible Officers that match the age range
     */
    public ArrayList<Officer> searchOfficerByAge(int lowAge, int highAge)
    {
        ArrayList<Officer> officerMatches = new ArrayList<Officer>();
        ArrayList<Officer> currentOfficers = people.getOfficerList();

        for(int i=0; i<currentOfficers.size(); i++)
        {
            if(currentOfficers.get(i).getAge() >= lowAge && currentOfficers.get(i).getAge() <= highAge)
                officerMatches.add(currentOfficers.get(i));
        }
        return officerMatches;
    }

    /**
     * Searches for an Officer using their sex
     * @param sex
     * @return array list of possible Officers that match the sex
     */
    public ArrayList<Officer> searchOfficerBySex(String sex)
    {
        ArrayList<Officer> officerMatches = new ArrayList<Officer>();
        ArrayList<Officer> currentOfficers = people.getOfficerList();

        for(int i=0; i<currentOfficers.size(); i++)
        {
            if(currentOfficers.get(i).getSex().equalsIgnoreCase(sex))
                officerMatches.add(currentOfficers.get(i));
        }
        return officerMatches;
    }

    /**
     * Searches for an Officer using their rank
     * @param rank
     * @return array list of possible Officers that match the rank
     */
    public ArrayList<Officer> searchOfficerByRank(String rank)
    {
        ArrayList<Officer> officerMatches = new ArrayList<Officer>();
        ArrayList<Officer> currentOfficers = people.getOfficerList();

        for(int i=0; i<currentOfficers.size(); i++)
        {
            if(currentOfficers.get(i).getRank().equalsIgnoreCase(rank))
                officerMatches.add(currentOfficers.get(i));
        }
        return officerMatches;
    }

    /**
     * Searches for an Officer using a city
     * @param city
     * @return array list of possible Officers that match the city
     */
    public ArrayList<Officer> searchOfficerByCity(String city)
    {
        ArrayList<Officer> officerMatches = new ArrayList<Officer>();
        ArrayList<Officer> currentOfficers = people.getOfficerList();

        for(int i=0; i<currentOfficers.size(); i++)
        {
            if(currentOfficers.get(i).getCity().equalsIgnoreCase(city))
                officerMatches.add(currentOfficers.get(i));
        }
        return officerMatches;
    }

    /**
     * Searches for an Officer using their office number
     * @param officeNum
     * @return array list of possible Officers that match the office number
     */
    public ArrayList<Officer> searchOfficerByOfficeNum(long officeNum)
    {
        ArrayList<Officer> officerMatches = new ArrayList<Officer>();
        ArrayList<Officer> currentOfficers = people.getOfficerList();

        for(int i=0; i<currentOfficers.size(); i++)
        {
            if(currentOfficers.get(i).getOfficeNum() == officeNum)
                officerMatches.add(currentOfficers.get(i));
        }
        return officerMatches;
    }

    /**
     * Searches for an Officer using their office address
     * @param officeAddress
     * @return array list of possible Officers that match the office address
     */
    public ArrayList<Officer> searchOfficerByOfficeAddress(String officeAddress)
    {
        ArrayList<Officer> officerMatches = new ArrayList<Officer>();
        ArrayList<Officer> currentOfficers = people.getOfficerList();

        for(int i=0; i<currentOfficers.size(); i++)
        {
            if(currentOfficers.get(i).getOfficeAddress().equalsIgnoreCase(officeAddress))
                officerMatches.add(currentOfficers.get(i));
        }
        return officerMatches;
    }

    /**
     * Searches for a Witness using their first name
     * @param firstName
     * @return array list of possible witnesses that match the first name
     */
    public ArrayList<Witness> searchWitnessByFirstName(String firstName)
    {
        ArrayList<Witness> witnessMatches = new ArrayList<Witness>();
        ArrayList<Witness> currentWitnesses = people.getWitnessList();

        for(int i=0; i<currentWitnesses.size(); i++)
        {
            if(currentWitnesses.get(i).getFirstName().equalsIgnoreCase(firstName))
                witnessMatches.add(currentWitnesses.get(i));
        }
        return witnessMatches;
    }

    /**
     * Searches for a Witness using their last name
     * @param lastName
     * @return array list of possible witnesses that match the last name
     */
    public ArrayList<Witness> searchWitnessByLastName(String lastName)
    {
        ArrayList<Witness> witnessMatches = new ArrayList<Witness>();
        ArrayList<Witness> currentWitnesses = people.getWitnessList();

        for(int i=0; i<currentWitnesses.size(); i++)
        {
            if(currentWitnesses.get(i).getLastName().equalsIgnoreCase(lastName))
                witnessMatches.add(currentWitnesses.get(i));
        }
        return witnessMatches;
    }

    /**
     * Searches for a Witness using an age range
     * @param lowAge
     * @param highAge
     * @return array list of possible witnesses that match the age range
     */
    public ArrayList<Witness> searchWitnessByAge(int lowAge, int highAge)
    {
        ArrayList<Witness> witnessMatches = new ArrayList<Witness>();
        ArrayList<Witness> currentWitnesses = people.getWitnessList();

        for(int i=0; i<currentWitnesses.size(); i++)
        {
            if(currentWitnesses.get(i).getAge() >= lowAge && currentWitnesses.get(i).getAge() <= highAge)
                witnessMatches.add(currentWitnesses.get(i));
        }
        return witnessMatches;
    }

    /**
     * Searches for a Witness using their sex
     * @param sex
     * @return array list of possible Witnesses that match the sex
     */
    public ArrayList<Witness> searchWitnessBySex(String sex)
    {
        ArrayList<Witness> witnessMatches = new ArrayList<Witness>();
        ArrayList<Witness> currentWitnesses = people.getWitnessList();

        for(int i=0; i<currentWitnesses.size(); i++)
        {
            if(currentWitnesses.get(i).getSex().equalsIgnoreCase(sex))
                witnessMatches.add(currentWitnesses.get(i));
        }
        return witnessMatches;
    }

    /**
     * Searches for a Witness using their phone number
     * @param phoneNum
     * @return array list of possible witnesses that match the phone number
     */
    public ArrayList<Witness> searchWitnessByPhoneNum(long phoneNum)
    {
        ArrayList<Witness> witnessMatches = new ArrayList<Witness>();
        ArrayList<Witness> currentWitnesses = people.getWitnessList();

        for(int i=0; i<currentWitnesses.size(); i++)
        {
            if(currentWitnesses.get(i).getPhoneNum() == phoneNum)
                witnessMatches.add(currentWitnesses.get(i));
        }
        return witnessMatches;
    }

    /**
     * Searches for a Witness based on their address
     * @param address
     * @return array list of possible witnesses that match the address
     */
    public ArrayList<Witness> searchWitnessByAddress(String address)
    {
        ArrayList<Witness> witnessMatches = new ArrayList<Witness>();
        ArrayList<Witness> currentWitnesses = people.getWitnessList();

        for(int i=0; i<currentWitnesses.size(); i++)
        {
            if(currentWitnesses.get(i).getAddress().equalsIgnoreCase(address))
                witnessMatches.add(currentWitnesses.get(i));
        }
        return witnessMatches;
    }

    /**
     * Searches for a Case using its crime type
     * @param crimeType
     * @return array list of possible cases that match the crime type
     */ 
    public ArrayList<Case> searchCaseByCrimeType(String crimeType)
    {
        ArrayList<Case> caseMatches = new ArrayList<Case>();
        ArrayList<Case> currentCases = cases.getCaseList();

        for(int i=0; i<currentCases.size(); i++)
        {
            if(currentCases.get(i).getCrimeType().equalsIgnoreCase(crimeType))
                caseMatches.add(currentCases.get(i));
        }
        return caseMatches;
    }

    /**
     * Searches for a Case using its date
     * @param month
     * @param day
     * @param year
     * @return array list of possible cases that match the date
     */
    public ArrayList<Case> searchCaseByDate(int month, int day, int year)
    {
        ArrayList<Case> caseMatches = new ArrayList<Case>();
        ArrayList<Case> currentCases = cases.getCaseList();
        String date = month + "/" + day + "/" + year;
        for(int i=0; i<currentCases.size(); i++)
        {
            if(currentCases.get(i).getDate().equalsIgnoreCase(date))
                caseMatches.add(currentCases.get(i));
        }
        return caseMatches;
    }

    /**
     * Searches for a Case based of the location
     * @param location
     * @return array list of possible cases that match the location
     */
    public ArrayList<Case> searchCaseByLocation(String location)
    {
        ArrayList<Case> caseMatches = new ArrayList<Case>();
        ArrayList<Case> currentCases = cases.getCaseList();

        for(int i=0; i<currentCases.size(); i++)
        {
            if(currentCases.get(i).getLocation().equalsIgnoreCase(location))
                caseMatches.add(currentCases.get(i));
        }
        return caseMatches;
    }

    public ArrayList<Case> searchCaseByEvidence(String evidence)
    {
        ArrayList<Case> caseMatches = new ArrayList<Case>();
        ArrayList<Case> currentCases = cases.getCaseList();

        for(int i=0; i<currentCases.size(); i++)
        {
            ArrayList<String> evidenceList = currentCases.get(i).getEvidence();
            for(int j=0; j<evidenceList.size(); j++)
            {
                if(evidenceList.get(j).equalsIgnoreCase(evidence))
                    caseMatches.add(currentCases.get(i));
            }
        }
        return caseMatches;
    }

    /**
     * Searches for a Case based of the Criminal
     * @param criminal
     * @return array list of possible cases that match the Criminal
     */
    public ArrayList<Case> searchCaseByCriminal(String criminal)
    {
        ArrayList<Case> caseMatches = new ArrayList<Case>();
        ArrayList<Case> currentCases = cases.getCaseList();

        for(int i=0; i<currentCases.size(); i++)
        {
            ArrayList<String> criminalList = currentCases.get(i).getCriminals();
            for(int j=0; j<criminalList.size(); j++)
            {
                if(criminalList.get(j).equalsIgnoreCase(criminal))
                    caseMatches.add(currentCases.get(i));
            }
        }
        return caseMatches;
    }

    /**
     * Searches for a Case based on the Victim
     * @param victim
     * @return array list of possible cases that match the victim
     */
    public ArrayList<Case> searchCaseByVictim(String victim)
    {
        ArrayList<Case> caseMatches = new ArrayList<Case>();
        ArrayList<Case> currentCases = cases.getCaseList();

        for(int i=0; i<currentCases.size(); i++)
        {
            ArrayList<String> victimList = currentCases.get(i).getVictims();
            for(int j=0; j<victimList.size(); j++)
            {
                if(victimList.get(j).equalsIgnoreCase(victim))
                    caseMatches.add(currentCases.get(i));
            }
        }
        return caseMatches;
    }

    /**
     * Searches for a Case based on the Officer
     * @param officer
     * @return array list of possible cases that match the Officer
     */
    public ArrayList<Case> searchCaseByOfficer(String officer)
    {
        ArrayList<Case> caseMatches = new ArrayList<Case>();
        ArrayList<Case> currentCases = cases.getCaseList();

        for(int i=0; i<currentCases.size(); i++)
        {
            ArrayList<String> officerList = currentCases.get(i).getOfficers();
            for(int j=0; j<officerList.size(); j++)
            {
                if(officerList.get(j).equalsIgnoreCase(officer))
                    caseMatches.add(currentCases.get(i));
            }
        }
        return caseMatches;
    }

    /**
     * Searches for a Case based on the Witness
     * @param witness
     * @return array list of possible cases that match the Witness
     */
    public ArrayList<Case> searchCaseByWitness(String witness)
    {
        ArrayList<Case> caseMatches = new ArrayList<Case>();
        ArrayList<Case> currentCases = cases.getCaseList();

        for(int i=0; i<currentCases.size(); i++)
        {
            ArrayList<String> witnessList = currentCases.get(i).getWitnesses();
            for(int j=0; j<witnessList.size(); j++)
            {
                if(witnessList.get(j).equalsIgnoreCase(witness))
                    caseMatches.add(currentCases.get(i));
            }
        }
        return caseMatches;
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
     * Logs out the user
     */
    public void logout()
    {
        users.saveUsers();
        people.saveCriminals();
        people.saveVictims();
        people.saveOfficers();
        people.saveWitnesses();
        cases.saveCases();
    }

    public void generateCriminalFile(Criminal criminal, String fileName)
    {
       try
       { 
        File file = new File(fileName + ".txt");
        PrintStream stream = new PrintStream(file);

        System.setOut(stream);

        System.out.println("First name: " + criminal.getFirstName());
        System.out.println("Last name: " + criminal.getLastName());
        System.out.println("Age: " + criminal.getAge());
        System.out.println("Sex: " + criminal.getSex());
        System.out.println("Nickname: " + criminal.getNickname());
        System.out.println("Height: " + criminal.getHeight());
        System.out.println("Weight: " + criminal.getWeight());
        System.out.println("Race: " + criminal.getRace());
        System.out.println("Tattoos: ");
        for(int i=0; i<criminal.getTattoos().size();i++)
            System.out.println(criminal.getTattoos().get(i) + " ");
        System.out.println("Shoe size: " + criminal.getShoeSize());
        System.out.println("Piercings: ");
        for(int j=0; j< criminal.getPiercing().size(); j++)
            System.out.println(criminal.getPiercing().get(j) + " ");
        if(criminal.getUnderAge())

            System.out.println("Underage: yes");
        else
            System.out.println("Underage: no");
        if(criminal.getInJail())
            System.out.println("Jail Status: in prison");
        else    
            System.out.println("Jail status: not in prison");

        System.setOut(System.out);
        stream.close();

       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
    }

    /**
     * Mehtod to collect details for case and print to txt file
     * @return text file to display
     */
    public void generateCaseFile(Case caseToPrint, String fileName)
    {
       try
       { 
        File file = new File(fileName + ".txt");
        PrintStream stream = new PrintStream(file);

        System.setOut(stream);

        System.out.println("Case number: " + caseToPrint.getCaseNum());
        System.out.println("Crime type: " + caseToPrint.getCrimeType());
        System.out.println("Date: " + caseToPrint.getDate());
        System.out.println("Description: " + caseToPrint.getDescription());
        System.out.println("Location: " + caseToPrint.getLocation());
        System.out.println("Evidence: ");
        for(int h=0; h<caseToPrint.getEvidence().size(); h++)
            System.out.println(caseToPrint.getEvidence().get(h));
        System.out.println("Criminal(s): ");
        for(int i=0; i<caseToPrint.getCriminals().size(); i++)
            System.out.println(caseToPrint.getCriminals().get(i));
        System.out.println("Victims(s): ");
        for(int j=0;j<caseToPrint.getVictims().size(); j++)
            System.out.println(caseToPrint.getVictims().get(j));
        System.out.println("Officer(s): ");
        for(int k=0; k<caseToPrint.getOfficers().size(); k++)
            System.out.println(caseToPrint.getOfficers().get(k));
        System.out.println("Witness(es): ");
        for(int l=0; l<caseToPrint.getWitnesses().size(); l++)
            System.out.println(caseToPrint.getWitnesses().get(l));

        System.setOut(System.out);
        stream.close();

       }

       catch(Exception e)
       {
           e.printStackTrace();
       }
    }

    /**
     * Method to collect details and print
     * @param victim
     * @param fileName
     */
    public void generateVictimFile(Victim victim, String fileName)
    {
        try
        {
            File file = new File(fileName +".txt");
            PrintStream stream = new PrintStream(file);

            System.setOut(stream);

            System.out.println("First name: " + victim.getFirstName());
            System.out.println("Last name: " + victim.getLastName());
            System.out.println("Age: " + victim.getAge());
            System.out.println("Sex: " + victim.getSex());
            System.out.println("Report: " + victim.getReport());
            System.out.println("Hospital: " + victim.getHopsital());
            System.out.println("Phone number: " + victim.getPhoneNum());
            System.out.println("Address: " + victim.getAddress());

            System.setOut(System.out);
            stream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    
}

/**
     * Method to collect details and print
     * @param witness
     * @param fileName
     */
    public void generateWitnessFile(Witness witness, String fileName)
    {
        try
        {
            File file = new File(fileName +".txt");
            PrintStream stream = new PrintStream(file);

            System.setOut(stream);

            System.out.println("First name: " + witness.getFirstName());
            System.out.println("Last name: " + witness.getLastName());
            System.out.println("Age: " + witness.getAge());
            System.out.println("Sex: " + witness.getSex());
            System.out.println("Testimony: " + witness.getTestimony());
            System.out.println("Phone number: " + witness.getPhoneNum());
            System.out.println("Address: " + witness.getAddress());
           

            System.setOut(System.out);
            stream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    /**
     * Method to collect details and print
     * @param officer
     * @param fileName
     */
    public void generateOfficerFile(Officer officer, String fileName)
    {
        try
        {
            File file = new File(fileName +".txt");
            PrintStream stream = new PrintStream(file);

            System.setOut(stream);

            System.out.println("First name: " + officer.getFirstName());
            System.out.println("Last name: " + officer.getLastName());
            System.out.println("Age: " + officer.getAge());
            System.out.println("Sex: " + officer.getSex());
            System.out.println("Rank: " + officer.getRank());
            System.out.println("City: " + officer.getCity());
            System.out.println("Office number: " + officer.getOfficeNum());
            System.out.println("Office Address: " + officer.getOfficeAddress());

            System.setOut(System.out);
            stream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

}
