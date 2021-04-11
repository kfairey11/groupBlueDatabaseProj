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
        criminalList.clear();
        criminalList.add(new Criminal("Joe", "Bob", 34, "Male", "Ay its Joe", "6'2\"", 110.4, "white", "brown", "brown", "very skinny", array("fairy", "umbrella"), 11.5, array("left ear", "right ear"), false));
        criminalList.add(new Criminal("Bob", "Joe", 68, "Male", "Bob to the Joe", "6'0\"", 190.8, "white", "black", "blue", "very large", array("bear", "mom surrounded by heart"), 11.0, array("mouth", "nose"), false));
        DataWriter.saveCriminals();

        victimList.clear();
        victimList.add(new Victim("Hanna", "Fini", 20, "Female", "Was used as a hostage", "none", Long.parseLong("8435555911"), "45 Scottsdale Drive"));
        victimList.add(new Victim("Thomas", "Bobson", 43, "Male", "Was stabbed", "Wolfsons", Long.parseLong("8035553472"), "154 Bermuda Greens Ave"));
        DataWriter.saveVictims();

        officerList.clear();
        officerList.add(new Officer("Rebecca", "Robinson", 56, "Female", "Chief", "Seattle, Washington", Long.parseLong("7435558174"), "395 Pandora Drive"));
        officerList.add(new Officer("Bo", "Burnher", 30, "Male", "Detective", "Jacksonville, Florida", Long.parseLong("9045551294"), "1203 Franklin Street"));
        DataWriter.saveOfficers();

        witnessList.clear();
        witnessList.add(new Witness("Brady", "McBrady", 25, "Male", "I saw someone steal a purse", Long.parseLong("3825559238"), "9128 Forest Drive"));
        witnessList.add(new Witness("Tom", "Roberto", 34, "Male", "I saw someone get shot", Long.parseLong("4395551935"), "34 Idaho Avenue"));
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
    void testGetCriminalSize() {
        assertEquals(2, criminalList.size());
    }

    @Test
    void testGetVictimSize() {
        assertEquals(2, victimList.size());
    }

    @Test
    void testGetOfficerSize() {
        assertEquals(2, officerList.size());
    }

    @Test
    void testGetWitnessSize() {
        assertEquals(2, witnessList.size());
    }

    @Test
    void testZeroCriminals() {
        people.getCriminalList().clear();
        criminalList = DataLoader.getCriminals();
        assertEquals(0, criminalList.size());
    }

    @Test
    void testZeroVictims() {
        people.getVictimList().clear();
        victimList = DataLoader.getVictims();
        assertEquals(0, victimList.size());
    }

    @Test
    void testZeroOfficers() {
        people.getOfficerList().clear();
        officerList = DataLoader.getOfficers();
        assertEquals(0, officerList.size());
    }

    @Test
    void testZeroWitnesses() {
        people.getWitnessList().clear();
        witnessList = DataLoader.getWitnesses();
        assertEquals(0, witnessList.size());
    }

}
