/**
 * An Officer Class
 * @Author Sam, Kennedy, Casey
 */
public class Officer extends Person{
    /**
     * Attributes of an Officer
     */
    private String rank;
    private int officeNum;
    private String address;
    private String city;

    /**
     * Constructor for an Officer
     * @param firstName
     * @param lastName
     * @param age
     * @param sex
     * @param aRank
     * @param aCity
     * @param OfficeNum
     * @param anAddress
     */
    public Officer(String firstName, String lastName, int age, String sex, String aRank,  String aCity, int OfficeNum, String anAddress){
        super(firstName,lastName,age,sex);
        rank = aRank;
        city = aCity;
        officeNum = OfficeNum;
        address = anAddress;
    }

    /**
     * Gets the city of the officer
     * @return city
     */
    public String getCity() {
        return city;
    }

    public String getRank()
    {
        return rank;
    }

    public void setRank(String rank)
    {
        this.rank = rank;
    }

    /**
     * Sets the city the officer is from
     * @param aCity
     */
    public void setCity(String aCity) {
        city = aCity;
    }

    /**
     * Gets the officer number of the officer
     * @return office number
     */
    public int getOfficeNum() {
        return officeNum;
    }

    /**
     * Sets the office number of the officer
     * @param anOfficeNum
     */
    public void setOfficeNum(int anOfficeNum){
        officeNum = anOfficeNum;
    }

    /**
     * Gets office address of officer
     * @return address
     */
    public String getOfficeAddress() {
        return address;
    }

    /**
     * Sets the office address of officer
     * @param anOfficeAddress
     */
    public void setOfficeAddress(String anOfficeAddress){
        address = anOfficeAddress;
    }

    public void print()
    {
        System.out.println("First name: " +getFirstName());
        System.out.println("Last name: " + getLastName());
        System.out.println("Age: " + getAge());
        System.out.printlnt("Sex: " + getSex());
        System.out.println("Rank: " + getRank());
        System.out.println("City: " + getCity());
        System.out.println("Office number: " + getOfficeNum());
        System.out.println("Office Address: " + getOfficeAddress());
    }
}
