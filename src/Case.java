/**
 * A Case Class
 * @author Sam, Casey, Kennedy
 */
import java.util.*;
public class Case {
    /**
     * Attributes for a Case
     */
    private int caseNum;
    private String crimeType;
    private String date;
    private String description;
    private String location;
    private boolean inJail;
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
     * @param inJail
     * @param criminals
     * @param victims
     * @param officers
     * @param witnesses
     */
    public Case(int caseNum, String crimeType, String date, String description, String location, boolean inJail, ArrayList<String> criminals, 
    ArrayList<String> victims, ArrayList<String> officers, ArrayList<String> witnesses)
    {
        //empty stub
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
        caseNum = rand.nextInt(10000) +1;
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

    /**
     * Checks if the criminal is in jail already
     * @return inJail
     */
    public boolean getInJail(){
        return inJail;
    }

}

