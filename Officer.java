public class Officer extends Person{
    private Rank rank;
    private Case caseLink;
    private int officeNum;
    private String address;
    private String city;

    public Officer(Rank aRank, Case CaseLink, String aCity, int OfficeNum, String anAddress){
        rank = aRank;
        caseLink = CaseLink;
        city = aCity;
        officeNum = OfficeNum;
        address = anAddress;
    }

    public Rank getRank(){
        return rank;
    }

    public void setRank(Rank aRank) {
        rank = aRank;
    }

    public Case getCaseLink() {
        return caseLink;
    }

    public void setCaseLink(Case aCaseLink) {
        caseLink = aCaseLink;
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
