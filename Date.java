public class Date extends Case
{
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year)
    {
        toString();
    }

    public String toString()
    {
        return "Month: " + month + " Day: " + day + " Year: " + year + "\n" + month + "/" + day + "/" + year;
    }
    
}
