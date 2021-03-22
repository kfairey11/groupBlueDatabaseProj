/**
 * A DatabaseApp Class
 * @author Kennedy
 */
import java.util.*;
public class DatabaseApp {
    
    /**
     * Attributes for DatabaseApp
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
        if(user.getPassword().equals("password"))
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
    double weight, String race, ArrayList<String> tattoos, double shoeSize, ArrayList<String> piercings)
    {
        //adds criminal to the database based on this info
        //need to convert height info into the height format
        //need to add all elements of string arrays into arraylists
        return criminals.addCriminal(firstName, lastName, age, sex, nickname, height, weight, race, tattoos, shoeSize, piercings);
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
     * @return boolean
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
    public boolean createCase(int caseNum, String crimeType, String date, String description, String location, ArrayList<String> criminals, ArrayList<String> 
    victims, ArrayList<String> officers, ArrayList<String> witnesses)
    {
        //adds a case to the database
        return cases.addCase(caseNum, crimeType, date, description, location, criminals, victims, officers, witnesses);
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
                witnessList.set(i, witness);
        }
        witnesses.setWitnessList(witnessList);
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
     * Searches for a Criminal using their first name
     * @param firstName
     * @return array list of possible criminals with the matching first name
     */
    public ArrayList<Criminal> searchCriminalByFirstName(String firstName)
    {
        ArrayList<Criminal> criminalMatches = new ArrayList<Criminal>();
        ArrayList<Criminal> currentCriminals = criminals.getCriminalList();

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
        ArrayList<Criminal> currentCriminals = criminals.getCriminalList();

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
        ArrayList<Criminal> currentCriminals = criminals.getCriminalList();

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
        ArrayList<Criminal> currentCriminals = criminals.getCriminalList();

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
        ArrayList<Criminal> currentCriminals = criminals.getCriminalList();

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
        ArrayList<Criminal> currentCriminals = criminals.getCriminalList();
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
        ArrayList<Criminal> currentCriminals = criminals.getCriminalList();

        for(int i=0; i<currentCriminals.size(); i++)
        {
            if(currentCriminals.get(i).getWeight() >= lowWeight && currentCriminals.get(i).getWeight() <= highWeight)
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
        ArrayList<Criminal> currentCriminals = criminals.getCriminalList();

        for(int i=0; i<currentCriminals.size(); i++)
        {
            ArrayList<String> tattoos = currentCriminals.get(i).getTattoos();
            for(int j=0; j<tattoos.size(); j++)
            {
                if(tattoos.get(i).equalsIgnoreCase(tattoo))
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
        ArrayList<Criminal> currentCriminals = criminals.getCriminalList();

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
        ArrayList<Criminal> currentCriminals = criminals.getCriminalList();

        for(int i=0; i<currentCriminals.size(); i++)
        {
            ArrayList<String> piercings = currentCriminals.get(i).getPiercing();
            for(int j=0; j<currentCriminals.size(); j++)
            {
                if(piercings.get(i).equalsIgnoreCase(piercing))
                    criminalMatches.add(currentCriminals.get(i));
            }
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
        ArrayList<Criminal> currentCriminals = criminals.getCriminalList();

        for(int i=0; i<currentCriminals.size(); i++)
        {
            if(currentCriminals.get(i).getAge() < 18)
                criminalMatches.add(currentCriminals.get(i));
        }
        return criminalMatches;
    }

    public ArrayList<Victim> searchVictimByFirstName(String firstName)
    {
        ArrayList<Victim> victimMatches = new ArrayList<Victim>();
        ArrayList<Victim> currentVictims = victims.getVictimList();

        for(int i=0; i<currentVictims.size(); i++)
        {
            if(currentVictims.get(i).getFirstName().equalsIgnoreCase(firstName))
                victimMatches.add(currentVictims.get(i));
        }
        return victimMatches;
    }

    public ArrayList<Victim> searchVictimByLastName(String lastName)
    {
        ArrayList<Victim> victimMatches = new ArrayList<Victim>();
        ArrayList<Victim> currentVictims = victims.getVictimList();

        for(int i=0; i<currentVictims.size(); i++)
        {
            if(currentVictims.get(i).getLastName().equalsIgnoreCase(lastName))
                victimMatches.add(currentVictims.get(i));
        }
        return victimMatches;
    }

    public ArrayList<Victim> searchVictimByAge(int lowAge, int highAge)
    {
        ArrayList<Victim> victimMatches = new ArrayList<Victim>();
        ArrayList<Victim> currentVictims = victims.getVictimList();

        for(int i=0; i<currentVictims.size(); i++)
        {
            if(currentVictims.get(i).getAge() >= lowAge && currentVictims.get(i).getAge() <= highAge)
                victimMatches.add(currentVictims.get(i));
        }
        return victimMatches;
    }

    public ArrayList<Victim> searchVictimBySex(String sex)
    {
        ArrayList<Victim> victimMatches = new ArrayList<Victim>();
        ArrayList<Victim> currentVictims = victims.getVictimList();

        for(int i=0; i<currentVictims.size(); i++)
        {
            if(currentVictims.get(i).getSex().equalsIgnoreCase(sex))
                victimMatches.add(currentVictims.get(i));
        }
        return victimMatches;
    }

    public ArrayList<Victim> searchVictimByHospital(String hospital)
    {
        ArrayList<Victim> victimMatches = new ArrayList<Victim>();
        ArrayList<Victim> currentVictims = victims.getVictimList();

        for(int i=0; i<currentVictims.size(); i++)
        {
            if(currentVictims.get(i).getHopsital().equalsIgnoreCase(hospital))
                victimMatches.add(currentVictims.get(i));
        }
        return victimMatches;
    }

    public ArrayList<Victim> searchVictimByPhoneNum(int phoneNum)
    {
        ArrayList<Victim> victimMatches = new ArrayList<Victim>();
        ArrayList<Victim> currentVictims = victims.getVictimList();

        for(int i=0; i<currentVictims.size(); i++)
        {
            if(currentVictims.get(i).getPhoneNum() == phoneNum)
                victimMatches.add(currentVictims.get(i));
        }
        return victimMatches;
    }

    public ArrayList<Victim> searchVictimByAddress(String address)
    {
        ArrayList<Victim> victimMatches = new ArrayList<Victim>();
        ArrayList<Victim> currentVictims = victims.getVictimList();

        for(int i=0; i<currentVictims.size(); i++)
        {
            if(currentVictims.get(i).getAddress().equalsIgnoreCase(address))
                victimMatches.add(currentVictims.get(i));
        }
        return victimMatches;
    }

    public ArrayList<Officer> searchOfficerByFirstName(String firstName)
    {
        ArrayList<Officer> officerMatches = new ArrayList<Officer>();
        ArrayList<Officer> currentOfficers = officers.getOfficerList();

        for(int i=0; i<currentOfficers.size(); i++)
        {
            if(currentOfficers.get(i).getFirstName().equalsIgnoreCase(firstName))
                officerMatches.add(currentOfficers.get(i));
        }
        return officerMatches;
    }

    public ArrayList<Officer> searchOfficerByLastName(String lastName)
    {
        ArrayList<Officer> officerMatches = new ArrayList<Officer>();
        ArrayList<Officer> currentOfficers = officers.getOfficerList();

        for(int i=0; i<currentOfficers.size(); i++)
        {
            if(currentOfficers.get(i).getLastName().equalsIgnoreCase(lastName))
                officerMatches.add(currentOfficers.get(i));
        }
        return officerMatches;
    }

    public ArrayList<Officer> searchOfficerByAge(int lowAge, int highAge)
    {
        ArrayList<Officer> officerMatches = new ArrayList<Officer>();
        ArrayList<Officer> currentOfficers = officers.getOfficerList();

        for(int i=0; i<currentOfficers.size(); i++)
        {
            if(currentOfficers.get(i).getAge() >= lowAge && currentOfficers.get(i).getAge() <= highAge)
                officerMatches.add(currentOfficers.get(i));
        }
        return officerMatches;
    }

    public ArrayList<Officer> searchOfficerBySex(String sex)
    {
        ArrayList<Officer> officerMatches = new ArrayList<Officer>();
        ArrayList<Officer> currentOfficers = officers.getOfficerList();

        for(int i=0; i<currentOfficers.size(); i++)
        {
            if(currentOfficers.get(i).getSex().equalsIgnoreCase(sex))
                officerMatches.add(currentOfficers.get(i));
        }
        return officerMatches;
    }

    public ArrayList<Officer> searchOfficerByRank(String rank)
    {
        ArrayList<Officer> officerMatches = new ArrayList<Officer>();
        ArrayList<Officer> currentOfficers = officers.getOfficerList();

        for(int i=0; i<currentOfficers.size(); i++)
        {
            if(currentOfficers.get(i).getRank().equalsIgnoreCase(rank))
                officerMatches.add(currentOfficers.get(i));
        }
        return officerMatches;
    }

    public ArrayList<Officer> searchOfficerByCity(String city)
    {
        ArrayList<Officer> officerMatches = new ArrayList<Officer>();
        ArrayList<Officer> currentOfficers = officers.getOfficerList();

        for(int i=0; i<currentOfficers.size(); i++)
        {
            if(currentOfficers.get(i).getCity().equalsIgnoreCase(city))
                officerMatches.add(currentOfficers.get(i));
        }
        return officerMatches;
    }

    public ArrayList<Officer> searchOfficerByOfficeNum(int officeNum)
    {
        ArrayList<Officer> officerMatches = new ArrayList<Officer>();
        ArrayList<Officer> currentOfficers = officers.getOfficerList();

        for(int i=0; i<currentOfficers.size(); i++)
        {
            if(currentOfficers.get(i).getOfficeNum() == officeNum)
                officerMatches.add(currentOfficers.get(i));
        }
        return officerMatches;
    }

    public ArrayList<Officer> searchOfficerByOfficeAddress(String officeAddress)
    {
        ArrayList<Officer> officerMatches = new ArrayList<Officer>();
        ArrayList<Officer> currentOfficers = officers.getOfficerList();

        for(int i=0; i<currentOfficers.size(); i++)
        {
            if(currentOfficers.get(i).getOfficeAddress().equalsIgnoreCase(officeAddress))
                officerMatches.add(currentOfficers.get(i));
        }
        return officerMatches;
    }

    public ArrayList<Witness> searchWitnessByFirstName(String firstName)
    {
        ArrayList<Witness> witnessMatches = new ArrayList<Witness>();
        ArrayList<Witness> currentWitnesses = witnesses.getWitnessList();

        for(int i=0; i<currentWitnesses.size(); i++)
        {
            if(currentWitnesses.get(i).getFirstName().equalsIgnoreCase(firstName))
                witnessMatches.add(currentWitnesses.get(i));
        }
        return witnessMatches;
    }

    public ArrayList<Witness> searchWitnessByLastName(String lastName)
    {
        ArrayList<Witness> witnessMatches = new ArrayList<Witness>();
        ArrayList<Witness> currentWitnesses = witnesses.getWitnessList();

        for(int i=0; i<currentWitnesses.size(); i++)
        {
            if(currentWitnesses.get(i).getLastName().equalsIgnoreCase(lastName))
                witnessMatches.add(currentWitnesses.get(i));
        }
        return witnessMatches;
    }

    public ArrayList<Witness> searchWitnessByAge(int lowAge, int highAge)
    {
        ArrayList<Witness> witnessMatches = new ArrayList<Witness>();
        ArrayList<Witness> currentWitnesses = witnesses.getWitnessList();

        for(int i=0; i<currentWitnesses.size(); i++)
        {
            if(currentWitnesses.get(i).getAge() >= lowAge && currentWitnesses.get(i).getAge() <= highAge)
                witnessMatches.add(currentWitnesses.get(i));
        }
        return witnessMatches;
    }

    public ArrayList<Witness> searchWitnessBySex(String sex)
    {
        ArrayList<Witness> witnessMatches = new ArrayList<Witness>();
        ArrayList<Witness> currentWitnesses = witnesses.getWitnessList();

        for(int i=0; i<currentWitnesses.size(); i++)
        {
            if(currentWitnesses.get(i).getSex().equalsIgnoreCase(sex))
                witnessMatches.add(currentWitnesses.get(i));
        }
        return witnessMatches;
    }

    public ArrayList<Witness> searchWitnessByPhoneNum(int phoneNum)
    {
        ArrayList<Witness> witnessMatches = new ArrayList<Witness>();
        ArrayList<Witness> currentWitnesses = witnesses.getWitnessList();

        for(int i=0; i<currentWitnesses.size(); i++)
        {
            if(currentWitnesses.get(i).getPhoneNum() == phoneNum)
                witnessMatches.add(currentWitnesses.get(i));
        }
        return witnessMatches;
    }

    public ArrayList<Witness> searchWitnessByAddress(String address)
    {
        ArrayList<Witness> witnessMatches = new ArrayList<Witness>();
        ArrayList<Witness> currentWitnesses = witnesses.getWitnessList();

        for(int i=0; i<currentWitnesses.size(); i++)
        {
            if(currentWitnesses.get(i).getAddress().equalsIgnoreCase(address))
                witnessMatches.add(currentWitnesses.get(i));
        }
        return witnessMatches;
    }

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

    public ArrayList<Case> searchCaseByCriminal(String criminal)
    {
        ArrayList<Case> caseMatches = new ArrayList<Case>();
        ArrayList<Case> currentCases = cases.getCaseList();

        for(int i=0; i<currentCases.size(); i++)
        {
            ArrayList<String> criminalList = currentCases.get(i).getCriminals();
            for(int j=0; j<criminalList.size(); j++)
            {
                if(criminalList.get(i).equalsIgnoreCase(criminal))
                    caseMatches.add(currentCases.get(i));
            }
        }
        return caseMatches;
    }

    public ArrayList<Case> searchCaseByVictim(String victim)
    {
        ArrayList<Case> caseMatches = new ArrayList<Case>();
        ArrayList<Case> currentCases = cases.getCaseList();

        for(int i=0; i<currentCases.size(); i++)
        {
            ArrayList<String> victimList = currentCases.get(i).getVictims();
            for(int j=0; j<victimList.size(); j++)
            {
                if(victimList.get(i).equalsIgnoreCase(victim))
                    caseMatches.add(currentCases.get(i));
            }
        }
        return caseMatches;
    }

    public ArrayList<Case> searchCaseByOfficer(String officer)
    {
        ArrayList<Case> caseMatches = new ArrayList<Case>();
        ArrayList<Case> currentCases = cases.getCaseList();

        for(int i=0; i<currentCases.size(); i++)
        {
            ArrayList<String> officerList = currentCases.get(i).getOfficers();
            for(int j=0; j<officerList.size(); j++)
            {
                if(officerList.get(i).equalsIgnoreCase(officer))
                    caseMatches.add(currentCases.get(i));
            }
        }
        return caseMatches;
    }

    public ArrayList<Case> searchCaseByWitness(String witness)
    {
        ArrayList<Case> caseMatches = new ArrayList<Case>();
        ArrayList<Case> currentCases = cases.getCaseList();

        for(int i=0; i<currentCases.size(); i++)
        {
            ArrayList<String> witnessList = currentCases.get(i).getWitnesses();
            for(int j=0; j<witnessList.size(); j++)
            {
                if(witnessList.get(i).equalsIgnoreCase(witness))
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

    public void logout()
    {
        users.saveUsers();
        criminals.saveCriminals();
        victims.saveVictims();
        officers.saveOfficers();
        witnesses.saveWitnesses();
        cases.saveCases();
    }


}
