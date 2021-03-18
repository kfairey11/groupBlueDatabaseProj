public abstract class Person
{
    protected String firstName;
    protected String lastName;
    protected int age;
    protected String sex;

    public Person(String firstName, String lastName, int age, String sex)
    {
        this.firstName = firstName;
        this.lastName = lastName; 
        this.age = age;
        this.sex = sex;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String aFirstName)
    {
        this.firstName=aFirstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String aLastName)
    {
        this.lastName=aLastName;
    }

    public int getAge()
    {
        if(age <= 0)
        {
            return age;
        }
        else
        {
            System.out.println("Improper age input");
            return 0;
        }
    }
    
    public void setAge(int anAge)
    {
        this.age=anAge;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex=sex;
    }


}