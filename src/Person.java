/**
 * A Person Class
 * @author Casey, Kennedy
 */
public abstract class Person
{
    /**
     * Attributes of a Person
     */
    protected String firstName;
    protected String lastName;
    protected int age;
    protected String sex;

    /**
     * Constructor for a Person
     * @param firstName
     * @param lastName
     * @param age
     * @param sex
     */
    public Person(String firstName, String lastName, int age, String sex)
    {
        this.firstName = firstName;
        this.lastName = lastName; 
        this.age = age;
        this.sex = sex;
    }

    /**
     * Gets the first name of Person
     * @return firstname
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the first name of the Person
     * @param aFirstName
     */
    public void setFirstName(String aFirstName)
    {
        this.firstName=aFirstName;
    }

    /**
     * Gets the last name of Person
     * @return last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets the last name of the Person
     * @param aLastName
     */
    public void setLastName(String aLastName)
    {
        this.lastName=aLastName;
    }

    /**
     * Gets the age of Person
     * @return age
     */
    public int getAge()
    {
        if(age >= 0)
        {
            return age;
        }
        else
        {
            System.out.println("Improper age input");
            return 0;
        }
    }
    
    /**
     * Sets the age of Person
     * @param anAge
     */
    public void setAge(int anAge)
    {
        this.age=anAge;
    }

    /**
     * Gets the sex of Person
     * @return sex
     */
    public String getSex()
    {
        return sex;
    }

    /**
     * Sets the sex of Person
     * @param sex
     */
    public void setSex(String sex)
    {
        this.sex=sex;
    }


}