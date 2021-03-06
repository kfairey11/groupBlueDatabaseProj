/**
 * A Date Class
 * @author Casey, Kennedy
 */
public class Date
{
    /**
     * Attributes for the Date
     */
    private int day;
    private int month;
    private int year;

    /**
     * Constructor for the Date
     * @param aDay
     * @param aMonth
     * @param aYear
     */
    public Date(int aDay, int aMonth, int aYear)
    {
        
        day= aDay;
        month=aMonth;
        year=aYear;
    }

    /**
     * Prints out the Date
     * @return string describing the Date
     */
    public String toString()
    {
        return month + "/" + day + "/" + year;
    }
    
}
