import java.util.*;
public class Case {
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
    public Case(int caseNum, String crimeType, String date, String description, String location, boolean inJail, ArrayList<String> criminals, 
    ArrayList<String> victims, ArrayList<String> officers, ArrayList<String> witnesses)
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

    public String getDate() {
        return date;
    }

    public void setDate(int day, int month, int year){
        Date date = new Date(day, month, year);
        this.date = date.toString();
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

