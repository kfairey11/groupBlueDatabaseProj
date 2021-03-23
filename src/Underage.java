
public class Underage //check for extension
{
    /**
     * Attributes as someone Underage
     */
    public String trialStatus;
    public int parentalContactNum;
    public String parentalContact;

    /**
     * Constructor for an Underage person
     * @param atrialStatus
     * @param phoneNum
     * @param aparentalContact
     */
    public Underage(String atrialStatus, int phoneNum, String aparentalContact)
    {
        trialStatus= atrialStatus;
        parentalContactNum=phoneNum;
        parentalContact= aparentalContact;

    }

    /**
     * Checking for the status of the trial (i.e in progress, finished)
     * @return the trial status
     */
    public String getTrialStatus()
    {
        return trialStatus;
    }

    /**
     * Sets the trial status for an underage person
     * @param atrialStatus
     */
    public void setTrialStatus(String atrialStatus)
    {
        this.trialStatus= atrialStatus;
    }

    /**
     * Gets the parent's contact number for the underage person
     * @return parentalContactNum
     */
    public int getParentalContactNum()
    {
        return parentalContactNum;
    }

    /**
     * Sets the parent's contact number
     * @param phoneNum
     */
    public void setParentalContactNum(int phoneNum)
    {
        this.parentalContactNum= phoneNum;
    }

    /**
     * Gets the parental contact for the underage criminal
     * @return parental contact information
     */
    public String getParentalContact()
    {
        return parentalContact;
    }

    /**
     * Sets the parent's contact
     * @param aparentalContact
     */
    public void setParentalContact(String aparentalContact)
    {
        this.parentalContact=aparentalContact;
    }
}
