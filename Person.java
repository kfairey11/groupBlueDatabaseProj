public abstract class Person
{
    protected String firstName;
    protected String lastName;
    protected int age;
    protected Sex sex;

    public Person()

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

    public Sex getSex()
    {
        return sex;
    }

    public void setSex(Sex sex)
    {
        this.sex=sex;
    }


}