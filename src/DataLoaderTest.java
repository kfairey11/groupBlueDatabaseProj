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
    

    @BeforeEach
    public void setup()
    {
        this.userList.clear();
        this.userList.add(new User(new UUID(128, 0), "Kennedy", "Fairey", "kfairey", "password"));
        this.userList.add(new User(new UUID(128, 0), "Jonathan", "Miller", "jmiller", "password123"));
        
        this.criminalList.clear();
        this.criminalList.add(new Criminal("Al", "Capone", 50, "Male", "Top Dog", "6'0\"", 180.0, "white", "black", "blue", "tall, wears fidoras", new ArrayList<String>(), 12.5, new ArrayList<String>(), true));
        this.criminalList.add(new Criminal("Tommy", "Lastrange", 28, "Male", "TL", "5'8\"", 168.8, "latino", "black", "brown", "no description", new ArrayList<String>(), 10.0, new ArrayList<String>(), false));

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
        this.caseList.add(new Case(123, "Robbery", "1/1/2020", "a group of men in masks robbed a bank", "Johnson City, TN",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>()));
        this.caseList.add(new Case(9067, "Tax Fraud", "2/3/2021", "a group of inside traders marked off false losses", "Cincinnati, OH", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>()));
        
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

}

