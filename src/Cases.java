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
        caseList = Database.getCases();
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

    public ArrayList<Case> getCaseList()
    {
        return caseList;
    }

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

    public Case getCase(int caseNum)
    {
        for(Case newCase : caseList)
        {
            if(newCase.getCaseNum() == caseNum)
                return newCase;
        }
        return null;
    }

    public boolean addCase(String crimeType, int month, int day, int year, String description, String location, ArrayList<String> criminals,
    ArrayList<String> victims, ArrayList<String> officers, ArrayList<String> witnesses)
    {
        caseList.add(new Case(crimeType, month, day, year, description, location,  criminals, victims, officers, witnesses));
        return true;
    }

    //possibly getCase()?
}
