import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class DatabaseAppTest {
    
    private DatabaseApp databaseApp = new DatabaseApp();

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
       databaseApp.getUsers().getUsers().clear();
       databaseApp.getPeople().getCriminalList().clear();
       databaseApp.getPeople().getVictimList().clear();
       databaseApp.getPeople().getOfficerList().clear();
       databaseApp.getPeople().getWitnessList().clear();
       databaseApp.getCases().getCaseList().clear();

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
        databaseApp.getUsers().getUsers().clear();
        databaseApp.getPeople().getCriminalList().clear();
        databaseApp.getPeople().getVictimList().clear();
        databaseApp.getPeople().getOfficerList().clear();
        databaseApp.getPeople().getWitnessList().clear();
        databaseApp.getCases().getCaseList().clear();
 
        DataWriter.saveUsers();
        DataWriter.saveCriminals();
        DataWriter.saveVictims();
        DataWriter.saveOfficers();
        DataWriter.saveWitnesses();
        DataWriter.saveCases();
    }
        
    @Test
    void testCreatingOneUser()
    {
        databaseApp.createUser(new UUID(128, 0), "John", "Doe", "jdoe6", "password123");
        assertEquals("John", databaseApp.getUsers().getUsers().get(0).getFirstName());
        
    }

    @Test
    void testWrongUsernameLogin()
    {
        databaseApp.createUser(new UUID(128, 0), "John", "Doe", "jdoe6", "password123");
        assertFalse(databaseApp.login("jdoe7", "password123"));
    }

    @Test
    void testWrongPasswordLogin()
    {
        databaseApp.createUser(new UUID(128, 0), "John", "Doe", "jdoe6", "password123");
        assertFalse(databaseApp.login("jdoe6", "password12"));
    }

    @Test
    void testCorrectLogin()
    {
        databaseApp.createUser(new UUID(128, 0), "John", "Doe", "jdoe6", "password123");
        assertTrue(databaseApp.login("jdoe6", "password123"));
    }

    @Test
    void testCreatingOneCriminal()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        assertEquals("hairColor", databaseApp.getPeople().getCriminalList().get(0).getHairColor());
    }

    @Test 
    void testCreatingOneVictim()
    {
        databaseApp.createVictim("firstName", "lastName", 20, "sex", "aReport", "aHospital", Long.parseLong("5555551234"), "anAddress");
        assertEquals("firstName", databaseApp.getPeople().getVictimList().get(0).getFirstName());
    }

    @Test
    void testCreatingOneOfficer()
    {
        databaseApp.createOfficer("firstName", "lastName", 20, "sex", "rank", "city", Long.parseLong("0001112233"), "address");
        assertEquals("rank", databaseApp.getPeople().getOfficerList().get(0).getRank());
    }

    @Test
    void testCreatingOneWitness()
    {
        databaseApp.createWitness("firstName", "lastName", 20, "sex", "testimony", Long.parseLong("1231231234"), "address");
        assertEquals("testimony", databaseApp.getPeople().getWitnessList().get(0).getTestimony());
    }

    @Test
    void testCreatingOneCase()
    {
        databaseApp.createCase(1000, "crimeType", "01/01/2000", "description", "location", arrayList("item1", "item2"), arrayList("criminal1", "criminal2"), arrayList("victim1", "victim2"), arrayList("officer1", "officer2"), arrayList("witness1", "witness2"));
        assertEquals("crimeType", databaseApp.getCases().getCaseList().get(0).getCrimeType());
    }

    @Test
    void testChangeCriminal()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        Criminal criminal = new Criminal("John", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        databaseApp.changeCriminal(criminal);
        assertEquals("John", databaseApp.getPeople().getCriminalList().get(0).getFirstName());
    }

    @Test
    void testChangeVictim()
    {
        databaseApp.createVictim("firstName", "lastName", 20, "sex", "report", "hospital", Long.parseLong("1231231234"), "address");
        Victim victim = new Victim("John", "lastName", 20, "sex", "report", "hospital", Long.parseLong("1231231234"), "address");
        databaseApp.changeVictim(victim);
        assertEquals("John", databaseApp.getPeople().getVictimList().get(0).getFirstName());
    }

    @Test
    void testChangeOfficer()
    {
        databaseApp.createOfficer("firstName", "lastName", 20, "sex", "rank", "city", Long.parseLong("1231231234"), "address");
        Officer officer = new Officer("John", "lastName", 20, "sex", "rank", "city", Long.parseLong("1231231234"), "address");
        databaseApp.changeOfficer(officer);
        assertEquals("John", databaseApp.getPeople().getOfficerList().get(0).getFirstName());
    }

    @Test
    void testChangeWitness()
    {
        databaseApp.createWitness("firstName", "lastName", 20, "sex", "testimony", Long.parseLong("1231231234"), "address");
        Witness witness = new Witness("John", "lastName", 20, "sex", "testimony", Long.parseLong("1231231234"), "address");
        databaseApp.changeWitness(witness);
        assertEquals("John", databaseApp.getPeople().getWitnessList().get(0).getFirstName());
    }

    @Test
    void testChangeCase()
    {
        databaseApp.createCase(1000, "crimeType", "01/01/2000", "description", "location", arrayList("item1", "item2"), arrayList("criminal1", "criminal2"), arrayList("victim1", "victim2"), arrayList("officer1", "officer2"), arrayList("witness1", "witness2"));
        Case newCase = new Case(1000, "Robbery", "01/01/2000", "description", "location", arrayList("item1", "item2"), arrayList("criminal1", "criminal2"), arrayList("victim1", "victim2"), arrayList("officer1", "officer2"), arrayList("witness1", "witness2"));
        databaseApp.changeCase(newCase);
        assertEquals("Robbery", databaseApp.getCases().getCaseList().get(0).getCrimeType());
    }

    @Test
    void testSearchCriminalByName()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        Criminal createdCriminal = databaseApp.getPeople().getCriminalList().get(0);
        Criminal criminal = databaseApp.searchCriminalByName(createdCriminal.getFirstName() + " " + createdCriminal.getLastName());
        assertEquals("firstName", criminal.getFirstName());
    }

    @Test
    void testSearchVictimByName()
    {
        databaseApp.createVictim("firstName", "lastName", 20, "sex", "report", "hospital", Long.parseLong("1231231234"), "address");
        Victim createdVictim = databaseApp.getPeople().getVictimList().get(0);
        Victim victim = databaseApp.searchVictimByName(createdVictim.getFirstName() + " " + createdVictim.getLastName());
        assertEquals("firstName", victim.getFirstName());
    }

    @Test
    void testSearchOfficerByName()
    {
        databaseApp.createOfficer("firstName", "lastName", 20, "sex", "rank", "city", Long.parseLong("1231231234"), "address");
        Officer createdOfficer = databaseApp.getPeople().getOfficerList().get(0);
        Officer officer = databaseApp.searchOfficerByName(createdOfficer.getFirstName() + " " + createdOfficer.getLastName());
        assertEquals("firstName", officer.getFirstName());
    }

    @Test
    void testSearchWitnessByName()
    {
        databaseApp.createWitness("firstName", "lastName", 20, "sex", "testimony", Long.parseLong("1231231234"), "address");
        Witness createdWitness = databaseApp.getPeople().getWitnessList().get(0);
        Witness witness = databaseApp.searchWitnessByName(createdWitness.getFirstName() + " " + createdWitness.getLastName());
        assertEquals("firstName", witness.getFirstName());
    }

    @Test
    void testSearchCaseByCaseNum()
    {
        databaseApp.createCase(1000, "crimeType", "01/01/2000", "description", "location", arrayList("item1", "item2"), arrayList("criminal1", "criminal2"), arrayList("victim1", "victim2"), arrayList("officer1", "officer2"), arrayList("witness1", "witness2"));
        Case createdCase = databaseApp.getCases().getCaseList().get(0);
        Case searchCase = databaseApp.searchCaseByCaseNum(createdCase.getCaseNum());
        assertEquals(1000, searchCase.getCaseNum());
    }

    @Test
    void testSearchCriminalByFirstName()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        ArrayList<Criminal> criminals = databaseApp.searchCriminalByFirstName("firstName");
        assertEquals("firstName", criminals.get(0).getFirstName());
    }




}
