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
    private Case caseLink;
    private String hospital;
    private int phoneNum;
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
    public Victim(String firstName, String lastName, int age, String sex, String aReport, String aHospital, int aPhoneNum, String anAddress)
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
        if(aReport.equalsIgnoreCase(" "))
        {
            report= aReport;
        }
        else
        {
            aReport=aReport;
        }
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
        if(aHospital.equalsIgnoreCase(" "))
        {
            hospital=aHospital;
        }
        else
        {
            aHospital=aHospital;
        }
    }

    /**
     * Gets the phone number of the victim
     * @return phoneNum
     */
    public int getPhoneNum()
    {
        return phoneNum;
    }

    /**
     * Sets the phone number of the victim
     * @param aPhoneNum
     */
    public void setPhoneNum(int aPhoneNum)
    {
        if(phoneNum > 0)
        {
            phoneNum = aPhoneNum;
        }
        else
        {
            aPhoneNum = aPhoneNum;
        }
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
        if(anAddress.equalsIgnoreCase(" "))
        {
            address=anAddress;
        }
        else
        {
            anAddress=anAddress;
        }
    }
}
