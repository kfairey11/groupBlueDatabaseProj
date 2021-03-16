public class Underage //check for extension
{
    public String trialStatus;
    public int parentalContactNum;
    public String parentalContact;
    public boolean adultTrial;

    public Underage(String atrialStatus, int phoneNum, String aparentalContact, Boolean anAdultTrial)
    {
        trialStatus= atrialStatus;
        parentalContactNum=phoneNum;
        parentalContact= aparentalContact;
        adultTrial=anAdultTrial;

    }

    /**
     * Checking for the status of the trial (i.e in progress, finished)
     * @return the trial status
     */
    public String getTrialStatus()
    {
        return trialStatus;
    }

    
    public void setTrialStatus(String atrialStatus)
    {
        this.trialStatus= atrialStatus;
    }

    public int getParentalContactNum()
    {
        return parentalContactNum;
    }

    public void setParentalContactNum(int phoneNum)
    {
        this.parentalContactNum= phoneNum;
    }

    public Boolean isAdultTrial()
    {
        if(Person.getAge() < 18)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getParentalContact()
    {
        return parentalContact;
    }

    public void setParentalContact(String aparentalContact)
    {
        this.parentalContact=aparentalContact;
    }
}
