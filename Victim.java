public class Victim extends Person
{
    private String report;
    private Case caseLink;
    private String hospital;
    private int phoneNum;
    private String address;

    public Victim(String firstName, String lastName, int age, String sex, String aReport, String aHospital, int aPhoneNum, String anAddress)
    {
        super(firstName, lastName, age, sex);
        report= aReport;
        hospital=aHospital;
        phoneNum=aPhoneNum;
        address=anAddress;
    }

    public String getReport()
    {
        return report;
    }

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


    public String getHopsital()
    {
        return hospital;
    }

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

    public int getPhoneNum()
    {
        return phoneNum;
    }

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

    public String getAddress()
    {
        return address;
    }

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
