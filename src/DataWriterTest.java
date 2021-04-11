import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class DataWriterTest {
    
    private Users users = Users.getInstance();
    private ArrayList<User> userList = users.getUsers();
    private People people = People.getInstance();
    private ArrayList<Criminal> criminalList = people.getCriminalList();
    private ArrayList<Victim> victimList = people.getVictimList();
    private ArrayList<Officer> officerList = people.getOfficerList();
    private ArrayList<Witness> witnessList = people.getWitnessList();
    private Cases cases = Cases.getInstance();
    private ArrayList<Case> caseList = cases.getCaseList();

    private ArrayList<String> arrayList(String item1, String item2)
    {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(item1);
        arrayList.add(item2);
        return arrayList;
    }

    @BeforeEach
    public void setup()
    {
        userList.clear();
        criminalList.clear();
        victimList.clear();
        officerList.clear();
        witnessList.clear();
        caseList.clear();

        DataWriter.saveUsers();
        DataWriter.saveCriminals();
        DataWriter.saveVictims();
        DataWriter.saveOfficers();
        DataWriter.saveWitnesses();
        DataWriter.saveCases();
    }

    @AfterEach
    public void tearDown()
    {
        userList.clear();
        criminalList.clear();
        victimList.clear();
        officerList.clear();
        witnessList.clear();
        caseList.clear();

        DataWriter.saveUsers();
        DataWriter.saveCriminals();
        DataWriter.saveVictims();
        DataWriter.saveOfficers();
        DataWriter.saveWitnesses();
        DataWriter.saveCases();
    }

    @Test
    void testWritingZeroUsers()
    {
        assertEquals(0, userList.size());
    }

    @Test
    void testWritingZeroCriminals()
    {
        assertEquals(0, criminalList.size());
    }

    @Test
    void testWritingZeroVictims()
    {
        assertEquals(0, victimList.size());
    }

    @Test
    void testWritingZeroOfficers()
    {
        assertEquals(0, officerList.size());
    }

    @Test
    void testWritingZeroWitnesses()
    {
        assertEquals(0, witnessList.size());
    }

    @Test
    void testWritingZeroCases()
    {
        assertEquals(0, caseList.size());
    }
    
    @Test
    void testWritingOneUser()
    {
        userList.add(new User(new UUID(128, 0), "Kennedy", "Fairey", "kfairey", "password"));
        DataWriter.saveUsers();
        assertEquals("Fairey", DataLoader.getUsers().get(0).getLastName());
    }

    @Test
    void testWritingOneCriminal()
    {
        criminalList.add(new Criminal("Al", "Capone", 50, "Male", "Top Dog", "6'0\"", 180.0, "white", "black", "blue", "tall, wears fidoras", arrayList("fingerprint", "cross"), 12.5, arrayList("lip", "eye"), true));
        DataWriter.saveCriminals();
        assertEquals("Top Dog", DataLoader.getCriminals().get(0).getNickname());
    }

    @Test
    void testWritingOneVictim()
    {
        victimList.add(new Victim("Joc", "Pederson", 29, "Male", "shot me in the left arm", "St. Francis", Long.parseLong("8036009988"), "123 Dogtail Lane"));
        DataWriter.saveVictims();
        assertEquals("St. Francis", DataLoader.getVictims().get(0).getHopsital());
    }

    @Test
    void testWritingOneOfficer()
    {
        officerList.add(new Officer("Bobbie", "Smalls", 34, "Female", "Detective", "Washington D.C.", Long.parseLong("5551230044"), "444 Arroyo St"));
        DataWriter.saveOfficers();
        assertEquals("Detective", DataLoader.getOfficers().get(0).getRank());
    }

    @Test
    void testWritingOneWitness()
    {
        witnessList.add(new Witness("Terrence", "Callen", 40, "Male", "i saw a woman steal from the cash register", Long.parseLong("1234560099"), "329 Crestwood dr"));
        DataWriter.saveWitnesses();
        assertEquals("Terrence", DataLoader.getWitnesses().get(0).getFirstName());
    }

    @Test
    void testWritingOneCase()
    {
        caseList.add(new Case(123, "Robbery", "1/1/2020", "a group of men in masks robbed a bank", "Johnson City, TN",arrayList("fingerprints", "camera footage"), arrayList("Walter White", "Scooby Doo"),arrayList("Willy Wonka", "Patrick Mahomes"), arrayList("Eleanor Roosevelt", "Luke Skywalker"), arrayList("Dababy", "Leonardo Da Vinci")));
        DataWriter.saveCases();
        assertEquals("Robbery", DataLoader.getCases().get(0).getCrimeType());
    }

    @Test
    void testWritingEmptyUser()
    {
        userList.add(new User(new UUID(128, 0), "", "", "", ""));
        DataWriter.saveUsers();
        assertEquals("", DataLoader.getUsers().get(0).getUserName());
    }

    @Test
    void testWritingEmptyCriminal()
    {
        criminalList.add(new Criminal("", "", 0, "", "", "", 0.0, "", "", "", "", arrayList("", ""), 0.0, arrayList("", ""), true ));
        DataWriter.saveCriminals();
        assertEquals("", DataLoader.getCriminals().get(0).getHairColor());
    }

    @Test
    void testWritingEmptyVictim()
    {
        victimList.add(new Victim("", "", 0, "", "", "", Long.parseLong("0"), ""));
        DataWriter.saveVictims();
        assertEquals("", DataLoader.getVictims().get(0).getAddress());
    }

    @Test
    void testWritingEmptyOfficer()
    {
        officerList.add(new Officer("", "", 0, "", "", "", Long.parseLong("0"), ""));
        DataWriter.saveOfficers();
        assertEquals("", DataLoader.getOfficers().get(0).getFirstName());
    }

    @Test
    void testWritingEmptyWitness()
    {
        witnessList.add(new Witness("", "", 0, "", "", Long.parseLong("0"), ""));
        DataWriter.saveWitnesses();
        assertEquals("", DataLoader.getWitnesses().get(0).getTestimony());
    }

    @Test
    void testWritingEmptyCase()
    {
        caseList.add(new Case(0, "", "", "", "", arrayList("", ""), arrayList("", ""), arrayList("", ""), arrayList("", ""), arrayList("", "")));
        DataWriter.saveCases();
        assertEquals("", DataLoader.getCases().get(0).getEvidence().get(0));
    }
}
