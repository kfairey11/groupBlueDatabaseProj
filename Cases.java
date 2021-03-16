import java.util.ArrayList;
public class Cases {
    private Cases cases;
    private ArrayList<Case> caseList;

    private Cases()
    {
        cases = Database.getCases();
    }

    public Cases getInstance()
    {
        if(cases == null)
            cases = new Cases();
        return cases;
    }

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
