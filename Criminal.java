import java.util.ArrayList;

public class Criminal extends Person{
    private String nickname;
    private Height height;
    private Double weight;
    private String race;
    private ArrayList<String> tattoos;
    private Double shoeSize;
    private ArrayList<String> piercing;
    private boolean isUnderAge; //needs a check for this

    public Criminal(String nickName, Height aheight, double aweight, String arace,
    ArrayList<String> atattoos, ArrayList<String> apiercing, double shoesize, boolean IsUnderAge){
        this.nickname = nickName;
        this.height = aheight;
        this.race = arace;
        this.weight = aweight;
        this.tattoos = atattoos;
        this.piercing = apiercing;
        this.shoeSize = shoesize;
        this.isUnderAge = IsUnderAge;
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

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height aHeight){
        height = aHeight;
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
