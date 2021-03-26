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
    private String hairColor;
    private String eyeColor;
    private String description;
    private ArrayList<String> tattoos;
    private double shoeSize;
    private ArrayList<String> piercing;
    private boolean inJail;
    private boolean isUnderAge; //this won't be part of the constructor, just needs to check the age attribute

    /**
     * Criminal Constructor
     * @param String nickname, Height height, double weight, String race, 
     * @param ArrayList tattoos, ArrayList piercings, double shoesize
     */
    public Criminal(String firstName, String lastName, int age, String sex, String nickName, String height, double aweight, String arace, String hairColor,
     String eyeColor, String description, ArrayList<String> atattoos,double shoeSize, ArrayList<String> apiercing, boolean inJail){
        super(firstName, lastName, age, sex);
        this.nickname = nickName;
        this.height = height;
        this.race = arace;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.description = description;
        this.weight = aweight;
        setTattoos(atattoos);
        setPiercing(apiercing);
        this.shoeSize = shoeSize;
        setIsUnderAge(isUnderAge);
        this.inJail = inJail;
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
        this.nickname = aNickname;
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
        this.race = aRace;
    }

    public String getHairColor()
    {
        return this.hairColor;
    }

    public void setHairColor(String hairColor)
    {
        this.hairColor = hairColor;
    }


    public String getEyeColor()
    {
        return this.eyeColor;
    }

    public void setEyeColor(String eyeColor)
    {
        this.eyeColor = eyeColor;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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
    public void setTattoos(ArrayList<String> aTattoos){
        if(aTattoos == null)
            this.tattoos = null;
        else    
            this.tattoos = aTattoos;
    }

    public void addToTattoos(String tattoo)
    {
        tattoos.add(tattoo);
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
        this.piercing = aPiercing;
    }

    public void addToPiercing(String piercing)
    {
        this.piercing.add(piercing);
    }

    public void setIsUnderAge(boolean isUnderAge)
    {
        if(this.age < 18)
            isUnderAge = true;
        else 
            isUnderAge = false;
    }

    public boolean getInJail()
    {
        return inJail;
    }

    public void setInJail(boolean inJail)
    {
        this.inJail = inJail;
    }

    public void print()
    {
        System.out.println("First name: " + getFirstName());
        System.out.println("Last name: " + getLastName());
        System.out.println("Age: " + getAge());
        System.out.println("Sex: " + getSex());
        System.out.println("Nickname: " + getNickname());
        System.out.println("Height: " + getHeight());
        System.out.println("Weight: " + getWeight());
        System.out.println("Race: " + getRace());
        System.out.println("Tattoos: ");
        for(int i=0; i<this.tattoos.size();i++)
            System.out.println(tattoos.get(i) + " ");
        System.out.println("Shoe size: " + getShoeSize());
        System.out.println("Piercings: ");
        for(int j=0; j< this.piercing.size(); j++)
            System.out.println(piercing.get(j) + " ");
        if(isUnderAge)
            System.out.println("Underage: yes");
        else
            System.out.println("Underage: no");
    }
}
