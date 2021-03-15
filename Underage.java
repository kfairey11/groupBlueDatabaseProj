public class Underage //check for extension
{
    public String trialStatus;
    public int parentalContactNum;
    public String parentalContact;
    public boolean adultTrial;

    public Underage()
    {
        //empty

    }

    /**
     * Checking for the status of the trial (i.e in progress, finished)
     * @return the trial status
     */
    public String getTrialStatus()
    {
        return trialStatus;
    }

    
    public void setTrialStatus(String trialStatus)
    {
        this.trialStatus= trialStatus;
    }

    public int getParentalContactNum()
    {
        return parentalContactNum;
    }

    public void setParentalContactNum(int phoneNum)
    {
        this.parentalContactNum= parentalContactNum;
    }

    public Boolean isAdultTrial()
    {
        if(Criminal.getAge() < 18)
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

    public void setParentalContact(String parentalContact)
    {
        this.parentalContact=parentalContact;
    }
}
