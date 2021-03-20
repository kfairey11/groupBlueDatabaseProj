/**
 * user interface
 * @author Kennedy Fairey
 */
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

import java.util.ArrayList;
public class DatabaseUI {

    private static final String HOME_MSG = "Welcome to the Criminal Investigation Database";
    private static final String[] LOGIN_OPTIONS = {"Login", "Create Profile"};
    private static final String[] homePageOptions = {"Create a Person(s) Profile", "Add to an existing Person(s) Profile", "Create a Case Profile", 
    "Add to a Case Profile", "Search a Person(s) Profile", "Search a Case Profile", "Logout"};
    private static final String[] criminalOptions = {"First name", "Last name", "Age", "Sex", "Nickname", "Height", "Weight", "Race",
    "Tattoos", "Shoe size", "Piercings"};
    private static final String[] victimOptions = {"First name", "Last name", "Age", "Sex", "Report", "Hospital", "Phone number", "Address"};
    private static final String[] officerOptions = {"First name", "Last name", "Age", "Sex", "Rank", "Officer number", "Address", "City"};
    private static final String[] witnessOptions = {"First name", "Last name", "Age", "Sex", "Testimony", "Phone number", "Address"};
    private static final String[] personOptions = {"Criminal", "Victim", "Police Officer", "Witness"};
    private Scanner scanner;
    private DatabaseApp databaseApp;

    public DatabaseUI()
    {
        scanner = new Scanner(System.in);
        databaseApp = new DatabaseApp();
    }

    public static void main(String args[])
    {
        DatabaseUI ui = new DatabaseUI();
        ui.run();
    }

    public void run()
    {
        System.out.println(HOME_MSG);
        while(true)
        {
            for(int i=1; i< LOGIN_OPTIONS.length+1; i++)
                System.out.println(i + ". " + LOGIN_OPTIONS[i]);
            int userCommand = getUserCommand(LOGIN_OPTIONS.length);

            if(userCommand == -1)
            {
                System.out.println("Not a valid command");
                continue;
            }

            else if(userCommand == -2)
                break;

            switch(userCommand){

                case(0):
                if(login())
                    userCommand = -2;
                break;

                case(1):
                if(createUser())
                    userCommand = -2;
                break;
            }

        }

        while(true)
        {
            displayHomePage();

            int userCommand = getUserCommand(homePageOptions.length);

            if(userCommand == -1)
            {
                System.out.println("Not a valid command");
                continue;
            }

            if(userCommand == homePageOptions.length - 1)
            {
                logout();
                break;
            }

            
            switch(userCommand){

                case(0):
                createPerson();
                break;

                case(1):
                changePerson();
                break;

                case(2):
                createCase();
                break;

                case(3):
                changeCase();

                case(4):
                //create this method in database
                databaseApp.searchPerson();
                break;

                case(5):
                //create this method in database
                databaseApp.searchCase();
                break;


            }

        }
        System.out.println("You've been successfully logged out of your account");
    }

    private void displayHomePage()
    {
        System.out.println("*****Home Page*****");

        for(int i=0; i<homePageOptions.length; i++)
            System.out.println((i+1) + ". " + homePageOptions[i]);
        System.out.println("");
    }

    private int getUserCommand(int numOfCommands)
    {
        System.out.println("What would you like to do? (Enter the corresponding number then hit ENTER)");

        int userCommand = scanner.nextInt() - 1;

        if(userCommand >= 0 && userCommand <= numOfCommands)
            return userCommand;
        else    
            return -1;
    }

    private boolean login()
    {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();

        if(!databaseApp.login(username, password))
        {
            System.out.println("The username or password you entered was incorrect");
            return false;
        }
        else
            return true;
    }

    private boolean createUser()
    {
        System.out.println("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter what you would like your username to be");
        String username = scanner.nextLine();

        System.out.println("Enter what you would like your password to be (password must be at least 6 characters long)");
        String password = "";
        while(true)
        {
            password = scanner.nextLine();
            if(password.length() < 6)
                System.out.println("The password you entered is invalid, enter a valid password");
            else    
                break;
        }

        if(!databaseApp.createUser(firstName, lastName, username, password))
        {
            System.out.println("There already exists a user with that username");
            return false;
        }
        else    
            return true;
            
    }

    private void createPerson()
    {
        for(int i=0; i<personOptions.length; i++)
            System.out.println((i+1) + ". " + personOptions[i]);

        System.out.println("What kind of profile would you like to make? (Enter the corresponding number and hit ENTER)\n");
        while(true)
        {
        int userCommand = scanner.nextInt() - 1;
        System.out.println("\n");

        if(userCommand < 0 || userCommand > personOptions.length - 1)
        {
            System.out.println("Sorry that is not a valid input");
            continue;
        }
        
        switch(userCommand)
        {
            case(0):
            createCriminal();
            break;

            case(1):
            createVictim();
            break;

            case(2):
            createOfficer();
            break;

            case(3):
            createWitness();
            break;


        }
        }


    }


    private void createCriminal()
    {

        //call setters instead of criminal.*

        String firstName = enterInfo("First Name", "Criminal");
        String lastName = enterInfo("Last Name", "Criminal");
        int age = Integer.parseInt(enterInfo("Age", "Criminal"));
        String sex = enterInfo("Sex", "Criminal");
       
        //this will prob be replaced by UUIDs
        /*
        enterInfo("Case No.", "Criminal");
        criminal.caseNum = scanner.nextInt();
        nextLine();
        */
        String nickname = enterInfo("Nickname", "Criminal");

        System.out.println("Enter the Criminal's Height (Enter feet, hit ENTER, then enter inches");
        int feet = scanner.nextInt();
        int inches = scanner.nextInt();

        double weight = Double.parseDouble(enterInfo("Weight", "Criminal"));
        String race = enterInfo("Race", "Criminal");
        ArrayList<String> tattoos = enterInfoLoop("Tattoos (Enter tattoo then hit ENTER, either continue to enter tattoos or enter \"exit\" to exit)", "Criminal");

        double shoeSize = Double.parseDouble(enterInfo("Shoe Size", "Criminal"));
        ArrayList<String> piercings = enterInfoLoop("Piercings (Enter piercing then hit ENTER, either continue to enter piercings or enter \"exit\" to exit)", "Criminal");

        if(databaseApp.createCriminal(firstName, lastName, age, sex, nickname, feet, inches, weight, race, tattoos, shoeSize, piercings))
            System.out.println("Criminal has been successfully inserted into the database");
        else   
            System.out.println("A criminal of that name already exists in this database");
    }

    private void createVictim()
    {
        String firstName = enterInfo("First Name", "Victim");
        String lastName = enterInfo("Last Name", "Victim");

        int age = Integer.parseInt(enterInfo("Age", "Victim"));

        String sex = enterInfo("Sex", "Victim");

        String report = enterInfo("report", "Victim");
        //prob will be replaced with UUID
        /*
        enterInfo("Case No.", "Victim");
        victim.caseNum = scanner.nextLine();
        nextLine();
        */
        String hospital = enterInfo("Hospital", "Victim");
        int phoneNum = Integer.parseInt(enterInfo("Phone Number", "Victim"));

        String address = enterInfo("Address", "Victim");

        if(databaseApp.createVictim(firstName, lastName, age, sex, report, hospital, phoneNum, address))
            System.out.println("The victim has been successfully inserted into the database.");
        else    
            System.out.println("A victim with that name already exists in this database");
    }

    private void createOfficer()
    {
        String firstName = enterInfo("First Name", "Officer");
        String lastName = enterInfo("Last Name", "Officer");
        int age = Integer.parseInt(enterInfo("Age", "Officer"));
        String sex = enterInfo("Sex", "Officer");

        String rank = enterInfo("Rank (Officer, Detective, Corporal, Lieutenant, Sergeant, Captian)", "Officer");
        //will prob be replaced with UUID
        /*
        enterInfo("Case No.", "Officer");
        officer.caseNum = scanner.nextInt();
        nextLine();
        */
        String city = enterInfo("City", "Officer");
        int phoneNum = Integer.parseInt(enterInfo("Phone number", "Officer"));
        String address = enterInfo("Address", "Officer");

        if(databaseApp.createOfficer(firstName, lastName, age, sex, rank, city, phoneNum, address))
            System.out.println("The officer has been successfully inserted in the database.");
        else    
            System.out.println("An officer of that name already exists in the database");
    }

    private void createWitness()
    {

        String firstName = enterInfo("First Name", "Witness");
        String lastName = enterInfo("Last Name", "Witness");
        int age = Integer.parseInt(enterInfo("Age", "Witness"));
        String sex = enterInfo("Sex", "Witness");
        String testimony = enterInfo("Testimony", "Witness");
        int phoneNum = Integer.parseInt(enterInfo("Phone number", "Witness"));
        String address = enterInfo("Address", "Witness");
       //may be replaced with UUID
        /*
        enterInfo("Case No.", "Wintess");
        witness.caseNum = scanner.nextInt();
        nextLine();
        */
        if(databaseApp.createWitness(firstName, lastName, age, sex, testimony, phoneNum, address))
            System.out.println("The witness has been successfully inserted into the database.");
        else    
            System.out.println("A witness of that name already exists in this database");
    }

    private String enterInfo(String data, String person)
    {
        System.out.println("Enter the "+ person + "'s " + data + ": ");
        return scanner.nextLine();
    }

    private ArrayList<String> enterInfoLoop(String data, String person)
    {
        System.out.println("Enter the " + person + "'s " + data + ": ");
        ArrayList<String> elements = new ArrayList<String>();
        while(true)
        {
            if(scanner.next().equalsIgnoreCase("Exit")) 
                break;
            elements.add(scanner.nextLine());
        }
        return elements;

    }
    private void changePerson()
    {
        while(true)
        {
        for(int i=0; i<personOptions.length; i++)
            System.out.println((i+1) + ". " + personOptions[i]);
        System.out.println("Which type of person would you like to make a change to?(Type the corresponding number then hit ENTER)");

        int userInput = scanner.nextInt();
        if(userInput < 0 || userInput > personOptions.length)
        {
            System.out.println("That is not a valid input");
            continue;
        }

        switch(userInput)
        {
            case(0):
            makeChanges("Criminal");
            Criminal criminal = databaseApp.searchCriminalByName(scanner.next());
            System.out.println(criminal.firstName + " " + criminal.lastName + " is a criminal in the database");
            criminal.print();
            changesToCriminal(criminal);
            break;

            case(1):
            makeChanges("Victim");
            Victim victim = databaseApp.searchVictimByName(scanner.next());
            System.out.println(victim.firstName + " " + victim.lastName + " is a victim in the database");
            victim.print();
            changesToVictim(victim);
            break;

            case(2):
            makeChanges("Officer");
            Officer officer = databaseApp.searchOfficerByName(scanner.next());
            System.out.println(officer.firstName + " " + officer.lastName + " is an officer in the database");
            officer.print();
            changesToOfficer(officer);

            break;

            case(3):
            makeChanges("Witness");
            Witness witness = databaseApp.searchWitnessByName(scanner.next());
            System.out.println(witness.firstName + " " + witness.lastName + " is a witness in the database");
            witness.print();
            changesToWitness(witness);
            break;
            
            
        }
        break;
        
        
    
    }
    }
    private void makeChanges(String person)
    {
        System.out.println("Which" + person + "'s profile would you like to make changes to? Enter their full name then ENTER.");
    }

    private void changesToCriminal(Criminal criminal)
    {
        for(int i=1; i<criminalOptions.length + 1; i++)
            System.out.println(i + ". " + criminalOptions[i]);
        System.out.println("What would you like to make changes to? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;

        switch(userCommand){

            case(0):
            System.out.println("Enter the new first name");
            criminal.setFirstName(scanner.nextLine());
            break;

            case(1):
            System.out.println("Enter the new last name");
            criminal.setLastName(scanner.nextLine());
            break;

            case(2):
            System.out.println("Enter the new age");
            criminal.setAge(scanner.nextInt());
            break;

            case(3):
            System.out.println("Enter the new sex");
            criminal.setSex(scanner.nextLine());
            break;

            case(4):
            System.out.println("Enter the new nickname");
            criminal.setNickname(scanner.nextLine());
            break;

            case(5):
            System.out.println("Enter the new height (Enter the feet, hit ENTER, then enter the inches, then hit ENTER");
            int feet = scanner.nextInt();
            int inches = scanner.nextInt();
            criminal.setHeight(feet, inches);
            break;

            case(6):
            System.out.println("Enter the new weight");
            criminal.setWeight(scanner.nextDouble());
            break;

            case(7):
            System.out.println("Enter the new race");
            criminal.setRace(scanner.nextLine());
            break;

            case(8):
            while(true)
            {
                System.out.println("Enter a new tattoo, then hit ENTER,to move on, type EXIT");
                if(scanner.nextLine().equalsIgnoreCase("exit"))
                    break;
                criminal.getTattoos().add(scanner.nextLine());
            }
            break;

            case(9):
            System.out.println("Enter the new shoe size");
            criminal.setShoeSize(scanner.nextDouble());
            break;

            case(10):
            while(true)
            {
            System.out.println("Enter a new piercing, then hit ENTER, to move on, type EXIT");
            if(scanner.nextLine().equalsIgnoreCase("exit"))
                break;
            criminal.getPiercing().add(scanner.nextLine());
            }
            break;

        }

        databaseApp.changeCriminal(criminal);
        System.out.println("The changes have been made successfully");

    }

    private void changesToVictim(Victim victim)
    {
        for(int i=1; i<victimOptions.length + 1; i++)
            System.out.println(i + ". " + victimOptions[i]);
        System.out.println("What would you like to make changes to? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;

        while(true)
        {
            switch(userCommand)
            {
                case(0):
                System.out.println("Enter new first name");
                victim.setFirstName(scanner.nextLine());
                break;

                case(1):
                System.out.println("Enter new last name");
                victim.setLastName(scanner.nextLine());
                break;

                case(2):
                System.out.println("Enter new age");
                victim.setAge(scanner.nextInt());
                break;

                case(3):
                System.out.println("Enter new sex");
                victim.setSex(scanner.nextLine());
                break;

                case(4):
                System.out.println("Enter new report");
                victim.setReport(scanner.nextLine());
                break;

                case(5):
                System.out.println("Enter new hospital");
                victim.setHospital(scanner.nextLine());
                break;

                case(6):
                System.out.println("Enter new phone number");
                victim.setPhoneNum(scanner.nextInt());
                break;

                case(7):
                System.out.println("Enter new address");
                victim.setAddress(scanner.nextLine());
                break;
            }

            databaseApp.changeVictim(victim);
            System.out.println("The changes have been successfully made");
        }
    }

    private void changesToOfficer(Officer officer)
    {
        for(int i=1; i<officerOptions.length + 1; i++)
            System.out.println(i + ". " + officerOptions[i]);
        System.out.println("What would you like to make changes to? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;

        switch(userCommand){

            case(0):
            System.out.println("Enter new first name");
            officer.setFirstName(scanner.nextLine());
            break;

            case(1):
            System.out.println("Enter new last name");
            officer.setLastName(scanner.nextLine());
            break;

            case(2):
            System.out.println("Enter new age");
            officer.setAge(scanner.nextInt());
            break;

            case(3):
            System.out.println("Enter new sex");
            officer.setSex(scanner.nextLine());
            break;

            case(4):
            System.out.println("Enter new rank");
            officer.setRank(scanner.nextLine());
            break;

            case(5):
            System.out.println("Enter new office number");
            officer.setOfficeNum(scanner.nextInt());
            break;

            case(6):
            System.out.println("Enter new address");
            officer.setOfficeAddress(scanner.nextLine());
            break;
        }

        databaseApp.changeOfficer(officer);
        System.out.println("The changes have been successfully made");
    }

    private void changesToWitness(Witness witness)
    {
        for(int i=1; i<witnessOptions.length + 1; i++)
            System.out.println(i + ". " + witnessOptions[i]);
        System.out.println("What would you like to make changes to? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;

        switch(userCommand){

            case(0):
            System.out.println("Enter new first name");
            witness.setFirstName(scanner.nextLine());
            break;

            case(1):
            System.out.println("Enter new last name");
            witness.setLastName(scanner.nextLine());
            break;

            case(2):
            System.out.println("Enter new age");
            witness.setAge(scanner.nextInt());
            break;

            case(3):
            System.out.println("Enter new sex");
            witness.setSex(scanner.nextLine());
            break;

            case(4):
            System.out.println("Enter new testimony");
            witness.setTestimony(scanner.nextLine());
            break;

            case(5):
            System.out.println("Enter new phone number");
            witness.setPhoneNum(scanner.nextInt());
            break;

            case(6):
            System.out.println("Enter new address");
            witness.setAddress(scanner.nextLine());
            break;
        }

        databaseApp.changeWitness(witness);
        System.out.println("The changes have been made successfully");
    }

    private void createCase()
    {
        System.out.println("Enter the type of crime");
        String crimeType = scanner.nextLine();

        System.out.println("Enter the date of the crime (Enter the month in numerical form, hit ENTER, enter the day, hit ENTER, then enter the year, then hit ENTER");
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        int year = scanner.nextInt();


        System.out.println("Enter a description of the crime");
        String description = scanner.nextLine();

        System.out.println("Enter the location of the crime");
        String location = scanner.nextLine();

        System.out.println("Enter the full names of the criminals associated with this case (enter name, hit ENTER, then either keep entering names or type \"exit\" to stop");
        ArrayList<String> criminals = new ArrayList<String>();
        while(true)
        {
        if(scanner.nextLine().equalsIgnoreCase("exit"))
            break;
        String criminal = scanner.nextLine();
        //need to find a way to link every criminal typed to the case
        if(databaseApp.searchCriminalByName(criminal) != null)
        {
            System.out.println("That criminal is in the database, they have been added to the case. Continue adding criminals or type exit to exit.");
            criminals.add(criminal);
        }
        else    
            {
                System.out.println("That criminal is not in the database, would you like to add a new one? (y/n)");
                if(scanner.next().equalsIgnoreCase("y"))
                {
                    createCriminal();
                    System.out.println("Enter the name full name of the criminal just created to add them to the case.");
                    criminals.add(scanner.nextLine());
                }
                else    
                {
                    System.out.println("Either continue entering criminals, or type exit to stop");
                    continue;
                }
            }    
        }

        ArrayList<String> victims = new ArrayList<String>();
        while(true)
        {
        if(scanner.nextLine().equalsIgnoreCase("exit"))
            break;
        String victim = scanner.nextLine();
        //need to find a way to link every criminal typed to the case
        if(databaseApp.searchVictimByName(victim) != null)
        {
            System.out.println("That victim is in the database, they have been added to the case. Continue adding victims or type exit to exit.");
            victims.add(victim);
        }
        else    
            {
                System.out.println("That victim is not in the database, would you like to add a new one? (y/n)");
                if(scanner.next().equalsIgnoreCase("y"))
                {
                    createVictim();
                    System.out.println("Enter the name full name of the victim just created to add them to the case.");
                    victims.add(scanner.nextLine());
                }
                else    
                {
                    System.out.println("Either continue entering victims, or type exit to stop");
                    continue;
                }
            }    
        }

        ArrayList<String> officers = new ArrayList<String>();
        while(true)
        {
        if(scanner.nextLine().equalsIgnoreCase("exit"))
            break;
        String officer= scanner.nextLine();
        //need to find a way to link every criminal typed to the case
        if(databaseApp.searchCriminalByName(officer) != null)
        {
            System.out.println("That officer is in the database, they have been added to the case. Continue adding officers or type exit to exit.");
            officers.add(officer);
        }
        else    
            {
                System.out.println("That officer is not in the database, would you like to add a new one? (y/n)");
                if(scanner.next().equalsIgnoreCase("y"))
                {
                    createOfficer();
                    System.out.println("Enter the name full name of the officer just created to add them to the case.");
                    criminals.add(scanner.nextLine());
                }
                else    
                {
                    System.out.println("Either continue entering officer, or type exit to stop");
                    continue;
                }
            }    
        }

        ArrayList<String> witnesses = new ArrayList<String>();
        while(true)
        {
        if(scanner.nextLine().equalsIgnoreCase("exit"))
            break;
        String witness = scanner.nextLine();
        //need to find a way to link every criminal typed to the case
        if(databaseApp.searchWitnessByName(witness) != null)
        {
            System.out.println("That witness is in the database, they have been added to the case. Continue adding witnesses or type exit to exit.");
            witnesses.add(witness);
        }
        else    
            {
                System.out.println("That witness is not in the database, would you like to add a new one? (y/n)");
                if(scanner.next().equalsIgnoreCase("y"))
                {
                    createWitness();
                    System.out.println("Enter the name full name of the witness just created to add them to the case.");
                    witnesses.add(scanner.nextLine());
                }
                else    
                {
                    System.out.println("Either continue entering witnesses, or type exit to stop");
                    continue;
                }
            }    
        }


        if(databaseApp.createCase(crimeType, month, day, year, description, location, criminals, victims, officers, witnesses))
            System.out.println("The case was successfully inserted into the database.");

    }


    private void changeCase()
    {
        System.out.println("Enter the case number you would like to change");
        //need to make searchByCaseNum method in database class
        Case caseToChange = databaseApp.searchCaseByCaseNum(scanner.nextInt());
        //need to make changeCase in database class, needs to print options as well
        databaseApp.changeCase(caseToChange);

    }
}