public class Victim extends Person
{
    private String report;
    private Case caseLink;
    private String hospital;
    private int phoneNum;
    private String address;
    private Boolean protectCustody;

    public Victim(String firstName, String lastName, int age, String sex, String aReport, Case aCaseLink, String aHospital, int aPhoneNum, String anAddress, Boolean aProtectCustody)
    {
        super(firstName, lastName, age, sex);
        report= aReport;
        caseLink=aCaseLink;
        hospital=aHospital;
        phoneNum=aPhoneNum;
        address=anAddress;
        protectCustody=aProtectCustody;
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

    public Case getCaseLink()
    {
        return caseLink;
    }

    public void setCaseLink(Case aCaseLink)
    {
        caseLink=aCaseLink;
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

    public Boolean isProtectCustody()
    {
        if(protectCustody) //not exactly sure if this is right
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    
}
