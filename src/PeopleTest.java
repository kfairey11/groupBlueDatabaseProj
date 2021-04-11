/**
 * People Tester
 * @author Sam Lowry
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PeopleTest {
    private People people = People.getInstance();
    private ArrayList<Criminal> criminalList = people.getCriminalList();
    private ArrayList<Victim> victimList = people.getVictimList();
    private ArrayList<Officer> officerList = people.getOfficerList();
    private ArrayList<Witness> witnessList = people.getWitnessList();

    private ArrayList<String> array(String a, String b) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(a);
        arrayList.add(b);
        return arrayList;
    }

    @BeforeEach
    public void setup() {
        this.criminalList.clear();
        this.criminalList.add(new Criminal("Joe", "Bob", 34, "Male", "Ay its Joe", "6'2\"", 110.4, "white", "brown", "brown", "very skinny", array("fairy", "umbrella"), 11.5, array("left ear", "right ear"), false));
        this.criminalList.add(new Criminal("Bob", "Joe", 68, "Male", "Bob to the Joe", "6'0\"", 190.8, "white", "black", "blue", "very large", array("bear", "mom surrounded by heart"), 11.0, array("mouth", "nose"), false));
        DataWriter.saveCriminals();

        this.victimList.clear();
        this.victimList.add(new Victim("Hanna", "Fini", 20, "Female", "Was used as a hostage", "none", Long.parseLong("8435555911"), "45 Scottsdale Drive"));
        this.victimList.add(new Victim("Thomas", "Bobson", 43, "Male", "Was stabbed", "Wolfsons", Long.parseLong("8035553472"), "154 Bermuda Greens Ave"));
        DataWriter.saveVictims();

        this.officerList.clear();
        this.officerList.add(new Officer("Rebecca", "Robinson", 56, "Female", "Chief", "Seattle, Washington", Long.parseLong("7435558174"), "395 Pandora Drive"));
        this.officerList.add(new Officer("Bo", "Burnher", 30, "Male", "Detective", "Jacksonville, Florida", Long.parseLong("9045551294"), "1203 Franklin Street"));
        DataWriter.saveOfficers();

        this.witnessList.clear();
        this.witnessList.add(new Witness("Brady", "McBrady", 25, "Male", "I saw someone steal a purse", Long.parseLong("3825559238"), "9128 Forest Drive"));
        this.witnessList.add(new Witness("Tom", "Roberto", 34, "Male", "I saw someone get shot", Long.parseLong("4395551935"), "34 Idaho Avenue"));
        DataWriter.saveWitnesses();
    }

    @AfterEach
    public void tearDown() {
        people.getCriminalList().clear();
        people.getVictimList().clear();
        people.getOfficerList().clear();
        people.getWitnessList().clear();
        DataWriter.saveCriminals();
        DataWriter.saveVictims();
        DataWriter.saveOfficers();
        DataWriter.saveWitnesses();
    }

    @Test



    @Test



    @Test



    @Test
    
}
