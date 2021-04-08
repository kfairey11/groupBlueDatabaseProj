import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
        userList = DataLoader.getUsers();
        assertEquals(0, userList.size());
    }

    @Test
    void testWritingZeroCriminals()
    {
        criminalList = DataLoader.getCriminals();
        assertEquals(0, criminalList.size());
    }

    @Test
    void testWritingZeroVictims()
    {
        victimList = DataLoader.getVictims();
        assertEquals(0, victimList.size());
    }

    @Test
    void testWritingZeroOfficers()
    {
        officerList = DataLoader.getOfficers();
        assertEquals(0, officerList.size());
    }

    @Test
    void testWritingZeroWitnesses()
    {
        witnessList = DataLoader.getWitnesses();
        assertEquals(0, witnessList.size());
    }

    @Test
    void testWritingZeroCases()
    {
        caseList = DataLoader.getCases();
        assertEquals(0, caseList.size());
    }   
}
