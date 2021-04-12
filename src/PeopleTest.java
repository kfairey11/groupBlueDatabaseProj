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
        this.people.getCriminalList().clear();
        this.people.getVictimList().clear();
        this.people.getOfficerList().clear();
        this.people.getWitnessList().clear();
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

    @Test
    void testCriminalFirst() {
        assertEquals("Joe", criminalList.get(0).getFirstName());
    }

    @Test
    void testCriminalLast() {
        assertEquals("Bob", criminalList.get(0).getLastName());
    }

    @Test
    void testVictimFirst() {
        assertEquals("Hanna", victimList.get(0).getFirstName());
    }

    @Test 
    void testVictimLast() {
        assertEquals("Fini", victimList.get(0).getLastName());
    }

    @Test 
    void testOfficerFirst() {
        assertEquals("Rebecca", officerList.get(0).getFirstName());
    }

    @Test 
    void testOfficerLast() {
        assertEquals("Robinson", officerList.get(0).getLastName());
    }

    @Test
    void testWitnessFirst() {
        assertEquals("Brady", witnessList.get(0).getFirstName());
    }

    @Test
    void testWitnessLast() {
        assertEquals("McBrady", witnessList.get(0).getLastName());
    }

    @Test
    void testHaveCriminal(){
        boolean hasJoeBob = people.haveCriminal("Joe Bob");
        assertTrue(hasJoeBob);
    }

    @Test
    void testHaveVictim(){
        boolean hasHannaFini = people.haveVictim("Hanna Fini");
        assertTrue(hasHannaFini);
    }

    @Test
    void testHaveOfficer(){
        boolean hasRebeccaRobinson = people.haveOfficer("Rebecca Robinson");
        assertTrue(hasRebeccaRobinson);
    }

    @Test
    void testHaveWitness(){
        boolean hasBrady = people.haveWitness("Brady McBrady");
        assertTrue(hasBrady);
    }

    @Test
    void testHaveCriminalEmpty(){
        boolean empty = people.haveCriminal("");
        assertFalse(empty);
    }

    @Test
    void testHaveCriminalNull(){
        boolean nulli = people.haveCriminal(null);
        assertFalse(nulli);
    }

    @Test
    void testHaveVictimEmpty(){
        boolean empty = people.haveVictim("");
        assertFalse(empty);
    }

    @Test
    void testHaveVictimNull(){
        boolean nulli = people.haveVictim(null);
        assertFalse(nulli);
    }

    @Test
    void testHaveOfficerEmpty(){
        boolean empty = people.haveOfficer("");
        assertFalse(empty);
    }

    @Test
    void testHaveOfficerNull(){
        boolean nulli = people.haveOfficer(null);
        assertFalse(nulli);
    }

    @Test
    void testHaveWitnessEmpty(){
        boolean empty = people.haveWitness("");
        assertFalse(empty);
    }

    @Test
    void testHaveWitnessNull(){
        boolean nulli = people.haveWitness(null);
        assertFalse(nulli);
    }

    @Test
    void testHaveCriminalFalse(){
        boolean hasRick = people.haveCriminal("Rick");
        assertFalse(hasRick);
    }

    @Test
    void testHaveVictimFalse(){
        boolean hasRick = people.haveVictim("Rick");
        assertFalse(hasRick);
    }

    @Test
    void testHaveOfficerFalse(){
        boolean hasRick = people.haveOfficer("Rick");
        assertFalse(hasRick);
    }

    @Test
    void testHaveWitnessFalse(){
        boolean hasRick = people.haveWitness("Rick");
        assertFalse(hasRick);
    }

    @Test
    void testAddCriminal() {
        boolean added = people.addCriminal("Howard", "Stark", 19, "Male", "none", "5'6\"", 195.0, "white", "black", "brown", "made of iron", array("none", "none"), 12.0, array("nose", "none"), false);
        assertTrue(added);
    }

    @Test
    void testAddVictim() {
        boolean added = people.addVictim("Barbara", "Long", 38, "Female", "Was robbed", "none", Long.parseLong("4725558219"), "482 Road Drive");
        assertTrue(added);
    }

    @Test
    void testAddOfficer() {
        boolean added = people.addOfficer("Uie", "Smith", 67, "Male", "Officer", Long.parseLong("4815552817"), "3217 Circle Court", "Pheonix, Arizona");
        assertTrue(added);
    }

    @Test
    void testAddWitness() {
        boolean added = people.addWitness("Chris", "Hemsworth", 38, "Male", "I watched my brother steal", Long.parseLong("4115559999"), "294 Asgard Way");
        assertTrue(added);
    }

    @Test
    void test() {
        int num = 1;
        assertEquals(1, num);
    }
}
