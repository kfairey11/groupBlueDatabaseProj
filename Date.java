public class Date extends Case
{
    private int day;
    private int month;
    private int year;

    public Date(int aDay, int aMonth, int aYear)
    {
        day= aDay;
        month=aMonth;
        year=aYear;
    }

    public String toString()
    {
        return "Month: " + month + " Day: " + day + " Year: " + year + "\n" + month + "/" + day + "/" + year;
    }
    
}
