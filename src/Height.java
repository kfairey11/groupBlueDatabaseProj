/**
 * A Height Class
 * @author Casey, Kennedy
 */
public class Height //check extension
{
    /**
     * Attributes of Height
     */
    private int feet;
    private int inches;

    /**
     * Constructor for Height
     * @param aFoot
     * @param someInches
     */
    public Height(int aFoot, int someInches)
    {
        feet =aFoot;
        inches=someInches;
        toString();
    }

    /**
     * Prints the height of the person
     * @return string describing height
     */
    public String toString()
    {
        return feet + "\' " + inches + "\"";
    }
    
}
