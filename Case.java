import java.util.*;
public class Case {
    private UUID caseNum;
    private String crimeType;
    private Date date;
    private String description;
    private String location;
    private boolean inJail;
    private Criminal criminal;
    private Victim victim;
    private boolean isVictim;
    private ArrayList<Officer> officers;
    private ArrayList<Witness> witnesses;
    private boolean isWitness;

    //insert arrayList attributes
    public Case()
    {
        //empty stub
    }

    public UUID getCaseNum() {
        //empty stub
        return null;
    }

    public String getCrimeType() {
        //empty stub
        return "";
    }

    public void setCrimeType(String aCrimeType){
        //empty stub
    }

    public Date getDate() {
        //empty stub
        return null;
    }

    public void setDate(Date aDate){
        //empty stub
    }

    public String getDescription() {
         //empty stub
         return "";
    }

    public void setDescription(String aDescription){
         //empty stub
    }

    public String getLocation(){
         //empty stub
         return "";
    }

    public void setLocation(String aLocation){
         //empty stub
    }

    public boolean getInJail(){
         //empty stub
         return false;
    }

}

