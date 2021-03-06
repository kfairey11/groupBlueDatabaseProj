//created and tested by Kennedy Fairey
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

    @Test
    void testSearchCriminalByLastName()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        ArrayList<Criminal> criminals = databaseApp.searchCriminalByLastName("lastName");
        assertEquals("lastName", criminals.get(0).getLastName());
    }

    @Test
    void testSearchCriminalByAge()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        ArrayList<Criminal> criminals = databaseApp.searchCriminalByAge(19, 21);
        assertEquals(20, criminals.get(0).getAge());
    }

    @Test
    void testSearchCriminalBySex()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "Male", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        ArrayList<Criminal> criminals = databaseApp.searchCriminalBySex("Male");
        assertEquals("Male", criminals.get(0).getSex());
    }

    @Test
    void testSearchCriminalByNickname()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        ArrayList<Criminal> criminals = databaseApp.searchCriminalByNickname("nickname");
        assertEquals("nickname", criminals.get(0).getNickname());
    }

    @Test
    void testSearchCriminalByHeight()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        ArrayList<Criminal> criminals = databaseApp.searchCriminalByHeight(6, 0);
        assertEquals("6'0\"", criminals.get(0).getHeight());
    }

    @Test
    void testSearchCriminalByWeight()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        ArrayList<Criminal> criminals = databaseApp.searchCriminalByWeight(179.0, 181.0);
        assertEquals(180.0, criminals.get(0).getWeight());
    }

    @Test
    void testSearchCriminalByRace()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "Black", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        ArrayList<Criminal> criminals = databaseApp.searchCriminalByRace("Black");
        assertEquals("Black", criminals.get(0).getRace());
    }

    @Test
    void testSearchCriminalByHairColor()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        ArrayList<Criminal> criminals = databaseApp.searchCriminalByHairColor("hairColor");
        assertEquals("hairColor", criminals.get(0).getHairColor());
    }

    @Test
    void testSearchCriminalByEyeColor()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        ArrayList<Criminal> criminals = databaseApp.searchCriminalByEyeColor("eyeColor");
        assertEquals("eyeColor", criminals.get(0).getEyeColor());
    }

    @Test
    void testSearchCriminalByTattoos()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        ArrayList<Criminal> criminals = databaseApp.searchCriminalByTattoo("tattoo2");
        assertEquals("tattoo2", criminals.get(0).getTattoos().get(1));
    }

    @Test
    void testSearchCriminalByShoeSize()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        ArrayList<Criminal> criminals = databaseApp.searchCriminalByShoeSize(9.5, 10.5);
        assertEquals(10.0, criminals.get(0).getShoeSize());
    }

    @Test
    void testSearchCriminalByPiercing()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        ArrayList<Criminal> criminals = databaseApp.searchCriminalByPiercing("item1");
        assertEquals("item1", criminals.get(0).getPiercing().get(0));
    }

    @Test
    void testSearchCriminalByInJail()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), true);
        ArrayList<Criminal> criminals = databaseApp.searchCriminalInJail(true);
        assertTrue(criminals.get(0).getInJail());
    }

    @Test
    void testSearchCriminalByUnderage()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        ArrayList<Criminal> criminals = databaseApp.searchCriminalByUnderage();
        assertFalse(criminals.get(0).getUnderAge());
    }

    @Test
    void testSearchVictimByFirstName()
    {
        databaseApp.createVictim("firstName", "lastName", 20, "sex", "report", "hospital", Long.parseLong("5555551234"), "address");
        ArrayList<Victim> victims = databaseApp.searchVictimByFirstName("firstName");
        assertEquals("firstName", victims.get(0).getFirstName());
    }

    @Test
    void testSearchVictimByLastName()
    {
        databaseApp.createVictim("firstName", "lastName", 20, "sex", "report", "hospital", Long.parseLong("5555551234"), "address");
        ArrayList<Victim> victims = databaseApp.searchVictimByLastName("lastName");
        assertEquals("lastName", victims.get(0).getLastName());
    }

    @Test
    void testSearchVictimByAge()
    {
        databaseApp.createVictim("firstName", "lastName", 20, "sex", "report", "hospital", Long.parseLong("5555551234"), "address");
        ArrayList<Victim> victims = databaseApp.searchVictimByAge(19, 21);
        assertEquals(20, victims.get(0).getAge());
    }

    @Test
    void testSearchVictimBySex()
    {
        databaseApp.createVictim("firstName", "lastName", 20, "Male", "report", "hospital", Long.parseLong("5555551234"), "address");
        ArrayList<Victim> victims = databaseApp.searchVictimBySex("Male");
        assertEquals("Male", victims.get(0).getSex());
    }

    @Test
    void testSearchVictimByHospital()
    {
        databaseApp.createVictim("firstName", "lastName", 20, "sex", "report", "hospital", Long.parseLong("5555551234"), "address");
        ArrayList<Victim> victims = databaseApp.searchVictimByHospital("hospital");
        assertEquals("hospital", victims.get(0).getHopsital());
    }

    @Test
    void testSearchVictimByPhoneNum()
    {
        databaseApp.createVictim("firstName", "lastName", 20, "sex", "report", "hospital", Long.parseLong("5555551234"), "address");
        ArrayList<Victim> victims = databaseApp.searchVictimByPhoneNum(Long.parseLong("5555551234"));
        assertEquals(Long.parseLong("5555551234"), victims.get(0).getPhoneNum());
    }

    @Test
    void testSearchVictimByAddress()
    {
        databaseApp.createVictim("firstName", "lastName", 20, "sex", "report", "hospital", Long.parseLong("5555551234"), "address");
        ArrayList<Victim> victims = databaseApp.searchVictimByAddress("address");
        assertEquals("address", victims.get(0).getAddress());
    }

    @Test
    void testSearchOfficerByFirstName()
    {
        databaseApp.createOfficer("firstName", "lastName", 20, "sex", "rank", "city", Long.parseLong("1231231234"), "address");
        ArrayList<Officer> officers = databaseApp.searchOfficerByFirstName("firstName");
        assertEquals("firstName", officers.get(0).getFirstName());
    }

    @Test
    void testSearchOfficerByLastName()
    {
        databaseApp.createOfficer("firstName", "lastName", 20, "sex", "rank", "city", Long.parseLong("1231231234"), "address");
        ArrayList<Officer> officers = databaseApp.searchOfficerByLastName("lastName");
        assertEquals("lastName", officers.get(0).getLastName());
    }

    @Test
    void testSearchOfficerByAge()
    {
        databaseApp.createOfficer("firstName", "lastName", 20, "sex", "rank", "city", Long.parseLong("1231231234"), "address");
        ArrayList<Officer> officers = databaseApp.searchOfficerByAge(19,21);
        assertEquals(20, officers.get(0).getAge());
    }

    @Test
    void testSearchOfficerBySex()
    {
        databaseApp.createOfficer("firstName", "lastName", 20, "sex", "rank", "city", Long.parseLong("1231231234"), "address");
        ArrayList<Officer> officers = databaseApp.searchOfficerBySex("sex");
        assertEquals("sex", officers.get(0).getSex());
    }

    @Test
    void testSearchOfficerByRank()
    {
        databaseApp.createOfficer("firstName", "lastName", 20, "sex", "rank", "city", Long.parseLong("1231231234"), "address");
        ArrayList<Officer> officers = databaseApp.searchOfficerByRank("rank");
        assertEquals("rank", officers.get(0).getRank());
    }

    @Test
    void testSearchOfficerByOfficeNum()
    {
        databaseApp.createOfficer("firstName", "lastName", 20, "sex", "rank", "city", Long.parseLong("1231231234"), "address");
        ArrayList<Officer> officers = databaseApp.searchOfficerByOfficeNum(Long.parseLong("1231231234"));
        assertEquals(Long.parseLong("1231231234"), officers.get(0).getOfficeNum());
    }

    @Test
    void testSearchOfficerByOfficeAddress()
    {
        databaseApp.createOfficer("firstName", "lastName", 20, "sex", "rank", "city", Long.parseLong("1231231234"), "address");
        ArrayList<Officer> officers = databaseApp.searchOfficerByOfficeAddress("address");
        assertEquals("address", officers.get(0).getOfficeAddress());
    }

    @Test
    void testSearchWitnessByFirstName()
    {
        databaseApp.createWitness("firstName", "lastName", 20, "sex", "testimony", Long.parseLong("1231231234"), "address");
        ArrayList<Witness> witnesses = databaseApp.searchWitnessByFirstName("firstName");
        assertEquals("firstName", witnesses.get(0).getFirstName());
    }

    @Test
    void testSearchWitnessByLastName()
    {
        databaseApp.createWitness("firstName", "lastName", 20, "sex", "testimony", Long.parseLong("1231231234"), "address");
        ArrayList<Witness> witnesses = databaseApp.searchWitnessByLastName("lastName");
        assertEquals("lastName", witnesses.get(0).getLastName());
    }

    @Test
    void testSearchWitnessByAge()
    {
        databaseApp.createWitness("firstName", "lastName", 20, "sex", "testimony", Long.parseLong("1231231234"), "address");
        ArrayList<Witness> witnesses = databaseApp.searchWitnessByAge(19,21);
        assertEquals(20, witnesses.get(0).getAge());
    }

    @Test
    void testSearchWitnessBySex()
    {
        databaseApp.createWitness("firstName", "lastName", 20, "sex", "testimony", Long.parseLong("1231231234"), "address");
        ArrayList<Witness> witnesses = databaseApp.searchWitnessBySex("sex");
        assertEquals("sex", witnesses.get(0).getSex());
    }

    @Test
    void testSearchWitnessByPhoneNum()
    {
        databaseApp.createWitness("firstName", "lastName", 20, "sex", "testimony", Long.parseLong("1231231234"), "address");
        ArrayList<Witness> witnesses = databaseApp.searchWitnessByPhoneNum(Long.parseLong("1231231234"));
        assertEquals(Long.parseLong("1231231234"), witnesses.get(0).getPhoneNum());
    }

    @Test
    void testSearchWitnessByAddress()
    {
        databaseApp.createWitness("firstName", "lastName", 20, "sex", "testimony", Long.parseLong("1231231234"), "address");
        ArrayList<Witness> witnesses = databaseApp.searchWitnessByAddress("address");
        assertEquals("address", witnesses.get(0).getAddress());
    }

    @Test
    void testSearchCaseByCrimeType()
    {
        databaseApp.createCase(1000, "crimeType", "01/01/2000", "description", "location", arrayList("item1", "item2"), arrayList("criminal1", "criminal2"), arrayList("victim1", "victim2"), arrayList("officer1", "officer2"), arrayList("witness1", "witness2"));
        ArrayList<Case> cases = databaseApp.searchCaseByCrimeType("crimeType");
        assertEquals("crimeType", cases.get(0).getCrimeType());
    }

    @Test
    void testSearchCaseByDate()
    {
        databaseApp.createCase(1000, "crimeType", "1/1/2000", "description", "location", arrayList("item1", "item2"), arrayList("criminal1", "criminal2"), arrayList("victim1", "victim2"), arrayList("officer1", "officer2"), arrayList("witness1", "witness2"));
        ArrayList<Case> cases = databaseApp.searchCaseByDate(1, 1, 2000);
        assertEquals("1/1/2000", cases.get(0).getDate());
    }

    @Test
    void testSearchCaseByLocation()
    {
        databaseApp.createCase(1000, "crimeType", "01/01/2000", "description", "location", arrayList("item1", "item2"), arrayList("criminal1", "criminal2"), arrayList("victim1", "victim2"), arrayList("officer1", "officer2"), arrayList("witness1", "witness2"));
        ArrayList<Case> cases = databaseApp.searchCaseByLocation("location");
        assertEquals("location", cases.get(0).getLocation());
    }

    @Test
    void testSearchCaseByEvidence()
    {
        databaseApp.createCase(1000, "crimeType", "01/01/2000", "description", "location", arrayList("item1", "item2"), arrayList("criminal1", "criminal2"), arrayList("victim1", "victim2"), arrayList("officer1", "officer2"), arrayList("witness1", "witness2"));
        ArrayList<Case> cases = databaseApp.searchCaseByEvidence("item2");
        assertEquals("item2", cases.get(0).getEvidence().get(1));
    }

    @Test
    void testSearchCaseByCriminals()
    {
        databaseApp.createCase(1000, "crimeType", "01/01/2000", "description", "location", arrayList("item1", "item2"), arrayList("criminal1", "criminal2"), arrayList("victim1", "victim2"), arrayList("officer1", "officer2"), arrayList("witness1", "witness2"));
        ArrayList<Case> cases = databaseApp.searchCaseByCriminal("criminal1");
        assertEquals("criminal1", cases.get(0).getCriminals().get(0));
    }

    @Test
    void testSearchCaseByVictims()
    {
        databaseApp.createCase(1000, "crimeType", "01/01/2000", "description", "location", arrayList("item1", "item2"), arrayList("criminal1", "criminal2"), arrayList("victim1", "victim2"), arrayList("officer1", "officer2"), arrayList("witness1", "witness2"));
        ArrayList<Case> cases = databaseApp.searchCaseByVictim("victim1");
        assertEquals("victim1", cases.get(0).getVictims().get(0));
    }

    @Test
    void testSearchCaseByOfficers()
    {
        databaseApp.createCase(1000, "crimeType", "01/01/2000", "description", "location", arrayList("item1", "item2"), arrayList("criminal1", "criminal2"), arrayList("victim1", "victim2"), arrayList("officer1", "officer2"), arrayList("witness1", "witness2"));
        ArrayList<Case> cases = databaseApp.searchCaseByOfficer("officer1");
        assertEquals("officer1", cases.get(0).getOfficers().get(0));
    }

    @Test 
    void testSearchCaseByWitnesses()
    {
        databaseApp.createCase(1000, "crimeType", "01/01/2000", "description", "location", arrayList("item1", "item2"), arrayList("criminal1", "criminal2"), arrayList("victim1", "victim2"), arrayList("officer1", "officer2"), arrayList("witness1", "witness2"));
        ArrayList<Case> cases = databaseApp.searchCaseByWitness("witness2");
        assertEquals("witness2", cases.get(0).getWitnesses().get(1));
    }

    @Test
    void testSuccessfulLogout()
    {
        databaseApp.createCriminal("firstName", "lastName", 20, "sex", "nickname", "6'0\"", 180.0, "race", "hairColor", "eyeColor", "description", arrayList("tattoo1", "tattoo2"), 10.0, arrayList("item1","item2"), false);
        databaseApp.logout();
        assertEquals("firstName", DataLoader.getCriminals().get(0).getFirstName());
    }











}
