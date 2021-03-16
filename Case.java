import java.util.*;
public class Case {
    private int caseNum;
    private String crimeType;
    private Date date;
    private String description;
    private String location;
    private boolean inJail;
    private ArrayList<Criminal> criminals;
    private ArrayList<Victim> victim;
    private boolean isVictim;
    private ArrayList<Officer> officers;
    private ArrayList<Witness> witnesses;
    private boolean isWitness;

    //insert arrayList attributes
    public Case()
    {
        //empty stub
    }

    public int getCaseNum() {
        return caseNum;
    }

    public void setCaseNum()
    {
        Random rand = new Random();
        caseNum = rand.nextInt(10000) +1;
    }

    public String getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(String aCrimeType){
        crimeType = aCrimeType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date aDate){
        date = aDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription){
        description = aDescription;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String aLocation){
        location = aLocation;
    }

    public boolean getInJail(){
        return inJail;
    }

}

