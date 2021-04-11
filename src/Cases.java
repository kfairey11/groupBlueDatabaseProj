/**
 * A Cases Class
 * @author Kennedy
 */
import java.util.ArrayList;
public class Cases {
    private static Cases cases;
    private ArrayList<Case> caseList;

    /**
     * Constructor for Cases
     */
    private Cases()
    {
        caseList = DataLoader.getCases();
    }

    /**
     * Gets an instance of Cases
     * @return Cases
     */
    public static Cases getInstance()
    {
        if(cases == null)
            cases = new Cases();
        return cases;
    }

    /**
     * Returns the list of cases
     * @return list of cases
     */
    public ArrayList<Case> getCaseList()
    {
        return caseList;
    }

    /**
     * Sets the list of cases
     * @param cases
     */
    public void setCaseList(ArrayList<Case> cases)
    {
        this.caseList = cases;
    }

    /**
     * Searches through Cases for a certain Case
     * @param caseNum
     * @return boolean
     */
    public boolean haveCase(int caseNum)
    {
        for(int i=0; i<caseList.size(); i++)
        {
            if(caseNum == caseList.get(i).getCaseNum())
                return true;
        }
        return false;
    }

    /**
     * Gets a case from the list based on its case number
     * @param caseNum
     * @return Case
     */
    public Case getCase(int caseNum)
    {
        for(Case newCase : caseList)
        {
            if(newCase.getCaseNum() == caseNum)
                return newCase;
        }
        return null;
    }

    /**
     * Adds a Case to the case list
     * @param caseNum
     * @param crimeType
     * @param date
     * @param description
     * @param location
     * @param criminals
     * @param victims
     * @param officers
     * @param witnesses
     * @return true if successful
     */
    public boolean addCase(int caseNum, String crimeType, String date, String description, String location, ArrayList<String> evidence, ArrayList<String> criminals,
    ArrayList<String> victims, ArrayList<String> officers, ArrayList<String> witnesses)
    {
        caseList.add(new Case(caseNum, crimeType, date, description, location, evidence,  criminals, victims, officers, witnesses));
        return true;
    }

    /**
     * Saves the list of cases to the DataWriter
     */
    public void saveCases()
    {
        DataWriter.saveCases();
    }
    
}
