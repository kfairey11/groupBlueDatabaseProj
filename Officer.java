public class Officer extends Person{
    private String rank;
    private int officeNum;
    private String address;
    private String city;

    public Officer(String firstName, String lastName, int age, String sex, String aRank,  String aCity, int OfficeNum, String anAddress){
        super(firstName,lastName,age,sex);
        rank = aRank;
        city = aCity;
        officeNum = OfficeNum;
        address = anAddress;
    }



    public String getCity() {
        return city;
    }

    public void setCity(String aCity) {
        city = aCity;
    }

    public int getOfficeNum() {
        return officeNum;
    }

    public void setOfficeNum(int anOfficeNum){
        officeNum = anOfficeNum;
    }

    public String getOfficeAddress() {
        return address;
    }

    public void setOfficeAddress(String anOfficeAddress){
        address = anOfficeAddress;
    }
}
