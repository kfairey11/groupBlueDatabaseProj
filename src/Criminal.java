/**
 * A Criminal Class
 * @author Sam, Casey, Kennedy
 */
import java.util.ArrayList;

public class Criminal extends Person{
    /**
     * Attributes of a Criminal
     */
    private String nickname;
    private String height;
    private double weight;
    private String race;
    private ArrayList<String> tattoos;
    private double shoeSize;
    private ArrayList<String> piercing;
    private boolean isUnderAge; //this won't be part of the constructor, just needs to check the age attribute

    /**
     * Criminal Constructor
     * @param String nickname, Height height, double weight, String race, 
     * @param ArrayList tattoos, ArrayList piercings, double shoesize
     */
    public Criminal(String firstName, String lastName, int age, String sex, String nickName, int feet, int inches, double aweight, String arace,
    ArrayList<String> atattoos,double shoeSize, ArrayList<String> apiercing){
        super(firstName, lastName, age, sex);
        this.nickname = nickName;
        setHeight(feet, inches);
        this.race = arace;
        this.weight = aweight;
        this.tattoos = atattoos;
        this.piercing = apiercing;
        this.shoeSize = shoeSize;
        setIsUnderAge(isUnderAge);
    }

    /**
     * Gets the nickname of the criminal
     * @return string of nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Sets the nickname of the criminal
     * @param aNickname
     */
    public void setNickname(String aNickname) {
        if(aNickname.equalsIgnoreCase(" ")) {
            nickname = nickname;
        } else {
            nickname = aNickname;
        }
    }

    /**
     * Gets the height of the criminal
     * @return height
     */
    public String getHeight() {
        return height;
    }

    /**
     * Sets the height of the criminal
     * @param feet
     * @param inches
     */
    public void setHeight(int feet, int inches) {
        Height height = new Height(feet, inches);
        this.height = height.toString();   
    }

    /**
     * Gets the weight of the criminal
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the criminal
     * @param aWeight
     */
    public void setWeight(double aWeight) {
        if (aWeight > 0.0) {
            weight = aWeight;
        }
    }
    
    /**
     * Gets the race of the criminal
     * @return race
     */
    public String getRace(){
        return race;
    }

    /**
     * Sets the race of the criminal
     * @param aRace
     */
    public void setRace(String aRace) {
        if(aRace.equalsIgnoreCase(" ")) {
            race = race;
        } else {
            race = aRace;
        }
    }

    /**
     * Gets the list of tattoos on the criminal
     * @return tattoos
     */
    public ArrayList<String> getTattoos() {
        return tattoos;
    }

    /**
     * Sets the list of tattoos on the criminal
     * @param aTattoos
     */
    public void setTattos(ArrayList<String> aTattoos){
        tattoos = aTattoos;
    }

    /**
     * Gets the shoe size of the criminal
     * @return shoe size
     */
    public double getShoeSize() {
        return shoeSize;
    }

    /**
     * Sets the shoe size of the criminal
     * @param aShoeSize
     */
    public void setShoeSize(double aShoeSize) {
        if (aShoeSize > 0.0) {
            shoeSize = aShoeSize;
        }
    }

    /**
     * Gets the list of piercings on the criminal
     * @return list of piercings
     */
    public ArrayList<String> getPiercing() {
        return piercing;
    }

    /**
     * Sets the list of piercings on the criminal
     * @param aPiercing
     */
    public void setPiercing(ArrayList<String> aPiercing) {
        piercing = aPiercing;
    }

    public void setIsUnderAge(boolean isUnderAge)
    {
        if(this.age < 18)
            isUnderAge = true;
        else 
            isUnderAge = false;
    }
}
