/**
 * A Witness Class
 * @author Casey, Kennedy
 */
import java.util.*;

public class Witness extends Person
{
        /**
        * Attributes of a Witness
        */
        private String testimony;
        private int phoneNum;
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
        public Witness(String firstName, String lastName, int age, String sex, String aTestimony, int aPhoneNum, String anAddress)
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
            if(aTestimony.equalsIgnoreCase(" "))
            {
                testimony=aTestimony;
            }
            else
            {
                aTestimony=aTestimony;
            }
        }
        
        /**
         * Gets the phone number of the Witness
         * @return phone number
         */
        public int getPhoneNum()
        {
            return phoneNum;
        }

        /**
         * Sets the phone number of the Witness
         * @param aPhoneNum
         */
        public void setPhoneNum(int aPhoneNum)
        {
            if(aPhoneNum > 0)
            {
                phoneNum=aPhoneNum;
            }
            else
            {
                aPhoneNum=aPhoneNum;
            }
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
            if(anAddress.equalsIgnoreCase(" "))
            {
                address=anAddress;
            }
            else
            {
                anAddress=anAddress;
            }
        }

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
