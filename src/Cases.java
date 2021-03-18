/**
 * A Cases Class
 * @author Kennedy
 */
import java.util.ArrayList;
public class Cases {
    private Cases cases;
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

    //possibly getCase()?
}
