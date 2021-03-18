/**
 * People Class
 * @Author Kennedy
 */
import java.util.ArrayList;
//will probably have to make 5 different classes for each type of person
public class People {
    private static People people;
    private ArrayList<Person> personList;

    /**
     * Constructor for People
     */
    private People()
    {
        personList = Database.getPeople();
    }

    /**
     * Gets an instance of People()
     * @return people
     */
    public static People getInstance()
    {
        if(people == null)
            people = new People();
        return people;
    }

    /**
     * Searches through personList to find a certain person
     * @param name
     * @return boolean
     */
    public boolean havePerson(String name)
    {
        for(int i=0;i<personList.size();i++)
        {
            String fullName = ((personList.get(i)).getFirstName() + " " + (personList.get(i)).getLastName());
            if(name.equalsIgnoreCase(fullName))
                return true;
        }
        return false;
    }

    //possibly getItem()?
}