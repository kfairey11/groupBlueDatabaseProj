public class Height //check extension
{
    private int feet;
    private int inches;

    public Height(int aFoot, int someInches)
    {
        feet =aFoot;
        inches=someInches;
        toString();
    }

    public String toString()
    {
        return feet "\' " + someInches + "\"";
    }
    
}
