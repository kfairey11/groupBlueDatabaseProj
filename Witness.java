import java.util.concurrent.atomic.AtomicBoolean;

public class Witness extends Person
{
        private String testimony;
        private int phoneNum;
        private String address;

        public Witness(String firstName, String lastName, int age, String sex, String aTestimony, int aPhoneNum, String anAddress)
        {
            super(firstName, lastName, age, sex);
            testimony=aTestimony;
            phoneNum=aPhoneNum;
            address=anAddress;
        }

        public String getTestimony()
        {
            return testimony;
        }

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

        public int getPhoneNum()
        {
            return phoneNum;
        }

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
