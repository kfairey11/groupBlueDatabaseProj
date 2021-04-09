import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;
import java.io.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class DataLoaderTest {

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
        this.userList.clear();
        this.userList.add(new User(new UUID(128, 0), "Kennedy", "Fairey", "kfairey", "password"));
        this.userList.add(new User(new UUID(128, 0), "Jonathan", "Miller", "jmiller", "password123"));
        
        this.criminalList.clear();
        this.criminalList.add(new Criminal("Al", "Capone", 50, "Male", "Top Dog", "6'0\"", 180.0, "white", "black", "blue", "tall, wears fidoras", arrayList("fingerprint", "cross"), 12.5, arrayList("lip", "eye"), true));
        this.criminalList.add(new Criminal("Tommy", "Lastrange", 28, "Male", "TL", "5'8\"", 168.8, "latino", "black", "brown", "no description", arrayList("hawk", "lion"), 10.0, arrayList("upper ear", "belly button"), false));

        this.victimList.clear();
        this.victimList.add(new Victim("Joc", "Pederson", 29, "Male", "shot me in the left arm", "St. Francis", Long.parseLong("8036009988"), "123 Dogtail Lane"));
        this.victimList.add(new Victim("Sheila", "Thompson", 59, "Female", "i was robbed at gunpoint", "none", Long.parseLong("5557689012"), "543 Thoroughbred Lane"));

        this.officerList.clear();
        this.officerList.add(new Officer("Bobbie", "Smalls", 34, "Female", "Detective", "Washington D.C.", Long.parseLong("5551230044"), "444 Arroyo St"));
        this.officerList.add(new Officer("Jerry", "Adams", 26, "Male", "Officer", "Topeka, KS", Long.parseLong("440908756"), "3905 Hampton St"));

        this.witnessList.clear();
        this.witnessList.add(new Witness("Terrence", "Callen", 40, "Male", "i saw a woman steal from the cash register", Long.parseLong("1234560099"), "329 Crestwood dr"));
        this.witnessList.add(new Witness("Luke", "Alvarado", 22, "Male", "i was in the bank when it was robbed", Long.parseLong("0039878855"), "999 Household St"));

        this.caseList.clear();
        this.caseList.add(new Case(123, "Robbery", "1/1/2020", "a group of men in masks robbed a bank", "Johnson City, TN",arrayList("fingerprints", "camera footage"), arrayList("Walter White", "Scooby Doo"),arrayList("Willy Wonka", "Patrick Mahomes"), arrayList("Eleanor Roosevelt", "Luke Skywalker"), arrayList("Dababy", "Leonardo Da Vinci")));
        this.caseList.add(new Case(9067, "Tax Fraud", "2/3/2021", "a group of inside traders marked off false losses", "Cincinnati, OH", arrayList("blood sample", "hair"), arrayList("Johnny Test", "Phineas Flynn"), arrayList("Serena Williams", "Venus Williams"), arrayList("Bob Caslen", "Shane Beamer"), arrayList("Picasso", "Bob Ross")));
        
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
        this.users.getUsers().clear();
        
        this.people.getCriminalList().clear();
        this.people.getVictimList().clear();
        this.people.getOfficerList().clear();
        this.people.getWitnessList().clear();
        this.cases.getCaseList().clear();
        

        DataWriter.saveUsers();
        
        DataWriter.saveCriminals();
        DataWriter.saveVictims();
        DataWriter.saveOfficers();
        DataWriter.saveWitnesses();
        DataWriter.saveCases();
        
    }

    @Test
    void testGetUserSize()
    {
        assertEquals(2, this.userList.size());
    }

    @Test
    void testGetCriminalSize()
    {
        assertEquals(2, this.criminalList.size());
    }

    @Test
    void testGetVictimSize()
    {
        assertEquals(2, this.victimList.size());
    }

    @Test
    void testGetOfficerSize()
    {
        assertEquals(2, this.officerList.size());
    }

    @Test
    void testGetWitnessSize()
    {
        assertEquals(2, this.witnessList.size());
    }

    @Test
    void testUserUUID()
    {
        assertTrue(userList.get(0).getUserID() != null);
    }

    @Test
    void testUserFirstName()
    {
        assertEquals("Kennedy", userList.get(0).getFirstName());
    }

    @Test
    void testUserLastName()
    {
        assertEquals("Fairey", userList.get(0).getLastName());
    }

    @Test
    void testUserUsername()
    {
        assertEquals("jmiller", userList.get(1).getUserName());
    }

    @Test
    void testUserPassword()
    {
        assertEquals("password123", userList.get(1).getPassword());
    }

    @Test
    void testCriminalFirstName()
    {
        assertEquals("Al", criminalList.get(0).getFirstName());
    }

    @Test
    void testCriminalLastName()
    {
        assertEquals("Capone", criminalList.get(0).getLastName());
    }

    @Test
    void testCriminalAge()
    {
        assertEquals(28, criminalList.get(1).getAge());
    }

    @Test
    void testCriminalSex()
    {
        assertEquals("Male", criminalList.get(0).getSex());
    }

    @Test
    void testCriminalNickname()
    {
        assertEquals("TL", criminalList.get(1).getNickname());
    }

    @Test
    void testCriminalHeight()
    {
        assertEquals("6'0\"",criminalList.get(0).getHeight());
    }

    @Test
    void testCriminalWeight()
    {
        assertEquals(180.0, criminalList.get(0).getWeight());
    }

    @Test
    void testCriminalRace()
    {
        assertEquals("white", criminalList.get(0).getRace());
    }

    @Test
    void testCriminalHairColor()
    {
        assertEquals("black", criminalList.get(0).getHairColor());
    }

    @Test
    void testCriminalEyeColor()
    {
        assertEquals("brown", criminalList.get(1).getEyeColor());
    }

    @Test
    void testCriminalDescription()
    {
        assertEquals("tall, wears fidoras", criminalList.get(0).getDescription());
    }

    @Test
    void testCriminalTattoos()
    {
        assertEquals("cross", criminalList.get(0).getTattoos().get(1));
    }

    @Test
    void testCriminalShoeSize()
    {
        assertEquals(12.5, criminalList.get(0).getShoeSize());
    }

    @Test
    void testCriminalPiercings()
    {
        assertEquals("belly button", criminalList.get(1).getPiercing().get(1));
    }

    @Test
    void testCriminalInJail()
    {
        assertTrue(criminalList.get(0).getInJail());
    }

    @Test
    void testVictimFirstName()
    {
        assertEquals("Joc", victimList.get(0).getFirstName());
    }

    @Test
    void testVictimLastName()
    {
        assertEquals("Pederson", victimList.get(0).getLastName());
    }


}

