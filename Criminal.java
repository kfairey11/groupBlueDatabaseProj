import java.util.ArrayList;

public class Criminal extends Person{
    private String nickname;
    private String height;
    private double weight;
    private String race;
    private ArrayList<String> tattoos;
    private double shoeSize;
    private ArrayList<String> piercing;
    private boolean isUnderAge; //this won't be part of teh constructor, just needs to check the age attribute

    public Criminal(String firstName, String lastName, int age, String sex, String nickName, String aheight, double aweight, String arace,
    ArrayList<String> atattoos, ArrayList<String> apiercing, double shoesize){
        super(firstName, lastName, age, sex);
        this.nickname = nickName;
        this.height = aheight;
        this.race = arace;
        this.weight = aweight;
        this.tattoos = atattoos;
        this.piercing = apiercing;
        this.shoeSize = shoesize;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String aNickname) {
        if(aNickname.equalsIgnoreCase(" ")) {
            nickname = nickname;
        } else {
            nickname = aNickname;
        }
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(int feet, int inches) {
        Height height = new Height(feet, inches);
        this.height = height.toString();   
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double aWeight) {
        if (aWeight > 0.0) {
            weight = aWeight;
        }
    }
    
    public String getRace(){
        return race;
    }

    public void setRace(String aRace) {
        if(aRace.equalsIgnoreCase(" ")) {
            race = race;
        } else {
            race = aRace;
        }
    }

    public ArrayList<String> getTattoos() {
        return tattoos;
    }

    public void setTattos(ArrayList<String> aTattoos){
        tattoos = aTattoos;
    }

    public double getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(double aShoeSize) {
        if (aShoeSize > 0.0) {
            shoeSize = aShoeSize;
        }
    }

    public ArrayList<String> getPiercing() {
        return piercing;
    }

    public void setPiercing(ArrayList<String> aPiercing) {
        piercing = aPiercing;
    }
}
