/**
 * An Underage Class
 * @author Casey
 */
public class Underage //check for extension
{
    /**
     * Attributes as someone Underage
     */
    public String trialStatus;
    public int parentalContactNum;
    public String parentalContact;
    public boolean adultTrial;

    /**
     * Constructor for an Underage person
     * @param atrialStatus
     * @param phoneNum
     * @param aparentalContact
     * @param anAdultTrial
     */
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
     * Checks if it is an Adult Trial
     * @return boolean
     */
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

    /**
     * Gets the parent's contact of the Underage person
     * @return parentalContact
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
