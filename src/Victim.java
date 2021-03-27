/**
 * A Victim Class
 * @author Casey, Kennedy
 */
public class Victim extends Person
{
    /**
     * Attributes of a Victim
     */
    private String report;
    private String hospital;
    private long phoneNum;
    private String address;

    /**
     * Constructor for a Victim
     * @param firstName
     * @param lastName
     * @param age
     * @param sex
     * @param aReport
     * @param aHospital
     * @param aPhoneNum
     * @param anAddress
     */
    public Victim(String firstName, String lastName, int age, String sex, String aReport, String aHospital, long aPhoneNum, String anAddress)
    {
        super(firstName, lastName, age, sex);
        report= aReport;
        hospital=aHospital;
        phoneNum=aPhoneNum;
        address=anAddress;
    }

    /**
     * Gets Victim report
     * @return report
     */
    public String getReport()
    {
        return report;
    }

    /**
     * Sets the report of the Victim
     * @param aReport
     */
    public void setReport(String aReport)
    {
        this.report = aReport;
    }

    /**
     * Gets the hospital of the victim
     * @return hospital
     */
    public String getHopsital()
    {
        return hospital;
    }

    /**
     * Sets the hospital of the victim
     * @param aHospital
     */
    public void setHospital(String aHospital)
    {
        this.hospital = aHospital;
    }

    /**
     * Gets the phone number of the victim
     * @return phoneNum
     */
    public long getPhoneNum()
    {
        return phoneNum;
    }

    /**
     * Sets the phone number of the victim
     * @param aPhoneNum
     */
    public void setPhoneNum(long aPhoneNum)
    {
        this.phoneNum = aPhoneNum;
    }

    /**
     * Gets the address of the victim
     * @return address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Sets the address of the Victim
     * @param anAddress
     */
    public void setAddress(String anAddress)
    {
        this.address = anAddress;
    }

    /**
     * Prints out all the information related to the Victim
     */
    public void print()
    {
        System.out.println("First name: " + getFirstName());
        System.out.println("Last name: " + getLastName());
        System.out.println("Age: " + getAge());
        System.out.println("Sex: " + getSex());
        System.out.println("Report: " + getReport());
        System.out.println("Hospital: " + getHopsital());
        System.out.println("Phone number: " + getPhoneNum());
        System.out.println("Address: " + getAddress());
    }
}
