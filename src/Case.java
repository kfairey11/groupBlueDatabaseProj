/**
 * A Case Class
 * @author Sam, Casey, Kennedy
 */
import java.util.Random;
import java.util.ArrayList;
public class Case {
    /**
     * Attributes for a Case
     */
    private int caseNum;
    private String crimeType;
    private String date;
    private String description;
    private String location;
    private ArrayList<String> evidence;
    private ArrayList<String> criminals;
    private ArrayList<String> victims;
    private ArrayList<String> officers;
    private ArrayList<String> witnesses;

    //insert arrayList attributes
    /**
     * Constructor for Case
     * @param caseNum
     * @param crimeType
     * @param date
     * @param description
     * @param location
     * @param criminals
     * @param victims
     * @param officers
     * @param witnesses
     */
    public Case(int caseNum, String crimeType, String date, String description, String location, ArrayList<String> evidence, ArrayList<String> criminals, 
    ArrayList<String> victims, ArrayList<String> officers, ArrayList<String> witnesses)
    {
        //empty stub
        if(caseNum == -1)
            setCaseNum();
        else
            this.caseNum = caseNum;
        this.crimeType = crimeType;
        this.date = date;
        this.description = description;
        this.location = location;
        this.evidence = evidence;
        this.criminals = criminals;
        this.victims = victims;
        this.officers = officers;
        this.witnesses = witnesses;
    }

    /**
     * Gets the case number
     * @return caseNum
     */
    public int getCaseNum() {
        return caseNum;
    }

    /**
     * Randomly assigns the case number
     */
    public void setCaseNum()
    {
        Random rand = new Random();
        this.caseNum = rand.nextInt(10000)+1;
    }

    /**
     * Gets the crime type of the case
     * @return crimeType
     */
    public String getCrimeType() {
        return crimeType;
    }

    /**
     * Sets the crime type to the case
     * @param aCrimeType
     */
    public void setCrimeType(String aCrimeType){
        crimeType = aCrimeType;
    }

    /**
     * Gets the date of the case
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date of the case
     * @param day
     * @param month
     * @param year
     */
    public void setDate(int day, int month, int year){
        Date date = new Date(day, month, year);
        this.date = date.toString();
    }

    /**
     * Gets the description of the case
     * @return case description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the case
     * @param aDescription
     */
    public void setDescription(String aDescription){
        description = aDescription;
    }

    /**
     * Gets the location of the case
     * @return location
     */
    public String getLocation(){
        return location;
    }

    /**
     * Sets the location of the case
     * @param aLocation
     */
    public void setLocation(String aLocation){
        location = aLocation;
    }

    public ArrayList<String> getEvidence()
    {
        return this.evidence;
    }

    public void setEvidence(ArrayList<String> evidence)
    {
        this.evidence = evidence;
    }

    public void addToEvidence(String evidence)
    {
        this.evidence.add(evidence);
    }

    /**
     * Gets the list of criminals for the case
     * @return criminals
     */
    public ArrayList<String> getCriminals()
    {
        return criminals;
    }

    /**
     * Sets the list of criminals for the case
     * @param criminals
     */
    public void setCriminals(ArrayList<String> criminals)
    {
        this.criminals = criminals;
    }

    /**
     * Adds a criminal to the criminal list for the case
     * @param criminal
     */
    public void addToCriminals(String criminal)
    {
        this.criminals.add(criminal);
    }

    /**
     * Gets the list of victims for the case
     * @return victims
     */
    public ArrayList<String> getVictims()
    {
        return victims;
    }

    /**
     * Sets the list of victims for the case
     * @param victims
     */
    public void setVictims(ArrayList<String> victims)
    {
        this.victims = victims;
    }

    /**
     * Adds a victim to the victim list for the case
     * @param victim
     */
    public void addToVictims(String victim)
    {
        this.victims.add(victim);
    }

    /**
     * Gets the list of officers for the case
     * @return officers
     */
    public ArrayList<String> getOfficers()
    {
        return officers;
    }

    /**
     * Sets the list of officers for the case
     * @param officers
     */
    public void setOfficers(ArrayList<String> officers)
    {
        this.officers = officers;
    }

    /**
     * Adds an officer to the officer list for the case
     * @param officer
     */
    public void addToOfficers(String officer)
    {
        this.officers.add(officer);
    }

    /**
     * Gets the list of witnesses for the case
     * @return witnesses
     */
    public ArrayList<String> getWitnesses()
    {
        return witnesses;
    }

    /**
     * Sets the list of witnesses for the case
     * @param witnesses
     */
    public void setWitnesses(ArrayList<String> witnesses)
    {
        this.witnesses = witnesses;
    }

    /**
     * Adds a witness to the witness list for the case
     * @param witness
     */
    public void addToWitnesses(String witness)
    {
        this.witnesses.add(witness);
    }
    
    /**
     * prints out all the information associated with the case
     */
    public void print()
    {
        System.out.println("Case number: " + getCaseNum());
        System.out.println("Crime type: " + getCrimeType());
        System.out.println("Date: " + getDate());
        System.out.println("Description: " + getDescription());
        System.out.println("Location: " + getLocation());
        System.out.println("Evidence: ");
        for(int h=0; h<evidence.size(); h++)
            System.out.println(evidence.get(h));
        System.out.println("Criminal(s): ");
        for(int i=0; i<criminals.size(); i++)
            System.out.println(criminals.get(i));
        System.out.println("Victims(s): ");
        for(int j=0;j<victims.size(); j++)
            System.out.println(victims.get(j));
        System.out.println("Officer(s): ");
        for(int k=0; k<officers.size(); k++)
            System.out.println(officers.get(k));
        System.out.println("Witness(es): ");
        for(int l=0; l<witnesses.size(); l++)
            System.out.println(witnesses.get(l));
        System.out.println("");
        System.out.println("**************");
        System.out.println("");
    }

}

