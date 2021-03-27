/**
 * A Witness Class
 * @author Casey, Kennedy
 */


public class Witness extends Person
{
        /**
        * Attributes of a Witness
        */
        private String testimony;
        private long phoneNum;
        private String address;

        /**
         * Constructor of a Witness
         * @param firstName
         * @param lastName
         * @param age
         * @param sex
         * @param aTestimony
         * @param aPhoneNum
         * @param anAddress
         */
        public Witness(String firstName, String lastName, int age, String sex, String aTestimony, long aPhoneNum, String anAddress)
        {
            super(firstName, lastName, age, sex);
            testimony=aTestimony;
            phoneNum=aPhoneNum;
            address=anAddress;
        }
        
        /**
         * Gets the Witness testimony
         * @return testimony
         */
        public String getTestimony()
        {
            return testimony;
        }
        
        /**
         * Sets the Witness's testimony
         * @param aTestimony
         */
        public void setTestimony(String aTestimony)
        {
            this.testimony = aTestimony;
        }
        
        /**
         * Gets the phone number of the Witness
         * @return phone number
         */
        public long getPhoneNum()
        {
            return phoneNum;
        }

        /**
         * Sets the phone number of the Witness
         * @param aPhoneNum
         */
        public void setPhoneNum(long aPhoneNum)
        {
            this.phoneNum = aPhoneNum;
        }

        /**
         * Gets the address of the Witness
         * @return address
         */
        public String getAddress()
        {
            return address;
        }

        /**
         * Sets the address for the Witness
         * @param anAddress
         */
        public void setAddress(String anAddress)
        {
            this.address = anAddress;
        }

        /**
         * Prints out all the information related to the Witness
         */
        public void print()
        {
            System.out.println("First name: " + getFirstName());
            System.out.println("Last name: " + getLastName());
            System.out.println("Age: " + getAge());
            System.out.println("Sex: " + getSex());
            System.out.println("Testimony: " + getTestimony());
            System.out.println("Phone number: " + getPhoneNum());
            System.out.println("Address: " + getAddress());
        }
}
