/**
 * user interface
 * @author Kennedy Fairey
 */
//Ctrl + Shift + F quick search through code
import java.util.Scanner;
import java.util.UUID;


import java.util.ArrayList;
public class DatabaseUI {

    private static final String HOME_MSG = "Welcome to the Criminal Investigation Database";
    private static final String[] LOGIN_OPTIONS = {"Login", "Create Profile"};
    private static final String[] homePageOptions = {"Create a Person(s) Profile", "Add to an existing Person(s) Profile", "Create a Case Profile", 
    "Add to a Case Profile", "Search a Person(s) Profile", "Search a Case Profile", "Logout"};
    private static final String[] criminalOptions = {"First name", "Last name", "Age", "Sex", "Nickname", "Height", "Weight", "Race",
    "Tattoos", "Shoe size", "Piercings"};
    private static final String[] victimOptions = {"First name", "Last name", "Age", "Sex", "Report", "Hospital", "Phone number", "Address"};
    private static final String[] officerOptions = {"First name", "Last name", "Age", "Sex", "Rank","City", "Officer number", "Address"};
    private static final String[] witnessOptions = {"First name", "Last name", "Age", "Sex", "Testimony", "Phone number", "Address"};
    private static final String[] caseOptions = {"Case Number","Case Type", "Date", "Description", "Location", "Criminals", "Victims", "Officers", "Witnesses"};
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
            for(int i=0; i< (LOGIN_OPTIONS.length); i++)
                System.out.println((i+1 ) + ". " + LOGIN_OPTIONS[i]);
            int userCommand = getUserCommand(LOGIN_OPTIONS.length);

            if(userCommand == -1)
            {
                System.out.println("Not a valid command");
                continue;
            }


            switch(userCommand){

                case(0):
                if(login())
                    userCommand = -2;
                break;

                case(1):
                if(createUser())
                break;
                else
                break;
            }
            if(userCommand == -2)
                break;

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
                databaseApp.logout();
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
                searchPerson();
                break;

                case(5):
                //create this method in database
                searchCase();
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
        scanner.nextLine();
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        System.out.println(username);
        if(!databaseApp.login(username, password))
        {
            System.out.println("The username or password you entered was incorrect");
            return false;
        }
        else
            return databaseApp.login(username, password);
    }

    private boolean createUser()
    {
        UUID userID = null;
        System.out.println("Enter your first name: ");
        scanner.nextLine();
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

        if(!databaseApp.createUser(userID, firstName, lastName, username, password))
        {
            System.out.println("There already exists a user with that username");
            return false;
        }
        else    
            return databaseApp.createUser(userID, firstName, lastName, username, password);
            
    }

    private void createPerson()
    {
        for(int i=0; i<personOptions.length; i++)
            System.out.println((i+1) + ". " + personOptions[i]);
        int userCommand = 0;
        System.out.println("What kind of profile would you like to make? (Enter the corresponding number and hit ENTER)\n");
        while(true)
        {
        userCommand = scanner.nextInt() - 1;
        if(userCommand < 0 || userCommand > personOptions.length - 1)
        {
            System.out.println("Sorry that is not a valid input");
            continue;
        }
        break;
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


    private void createCriminal()
    {

        //call setters instead of criminal.*

        String firstName = enterInfo("First Name", "Criminal");
        scanner.nextLine();
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
        String height = new Height(feet, inches).toString();

        double weight = Double.parseDouble(enterInfo("Weight", "Criminal"));
        String race = enterInfo("Race", "Criminal");
        ArrayList<String> tattoos = enterInfoLoop("Tattoos (Enter tattoo then hit ENTER, either continue to enter tattoos or enter \"exit\" to exit)", "Criminal");

        double shoeSize = Double.parseDouble(enterInfo("Shoe Size", "Criminal"));
        ArrayList<String> piercings = enterInfoLoop("Piercings (Enter piercing then hit ENTER, either continue to enter piercings or enter \"exit\" to exit)", "Criminal");

        if(databaseApp.createCriminal(firstName, lastName, age, sex, nickname, height, weight, race, tattoos, shoeSize, piercings))
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
        for(int i=0; i<criminalOptions.length; i++)
            System.out.println((i+1) + ". " + criminalOptions[i]);
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
                criminal.addToTattoos(scanner.nextLine());
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
            criminal.addToPiercing(scanner.nextLine());;
            }
            break;

        }

        databaseApp.changeCriminal(criminal);
        System.out.println("The changes have been made successfully");

    }

    private void changesToVictim(Victim victim)
    {
        for(int i=0; i<victimOptions.length; i++)
            System.out.println((i+1) + ". " + victimOptions[i]);
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
        for(int i=0; i<officerOptions.length; i++)
            System.out.println((i+1) + ". " + officerOptions[i]);
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
        for(int i=0; i<witnessOptions.length; i++)
            System.out.println((i+1) + ". " + witnessOptions[i]);
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
        int caseNum = -1;
        System.out.println("Enter the type of crime");
        String crimeType = scanner.nextLine();

        System.out.println("Enter the date of the crime (Enter the month in numerical form, hit ENTER, enter the day, hit ENTER, then enter the year, then hit ENTER");
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        int year = scanner.nextInt();
        String date = new Date(month, day, year).toString();


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


        if(databaseApp.createCase(caseNum, crimeType, date, description, location, criminals, victims, officers, witnesses))
            System.out.println("The case was successfully inserted into the database.");

    }


    private void changeCase()
    {
        System.out.println("Enter the case number you would like to change");
        Case caseToChange = databaseApp.searchCaseByCaseNum(scanner.nextInt());
        caseToChange.print();
        while(true)
        {
        System.out.println("What would you like to change? (Enter the corresponding number, then hit ENTER)");
        for(int i=0; i<caseOptions.length; i++)
            System.out.println((i+1) + ". " + caseOptions[i]);

        int userCommand = scanner.nextInt() - 1;

        if(userCommand < 1 || userCommand > caseOptions.length)
        {
            System.out.println("Invalid input, enter again");
            continue;
        }

        switch(userCommand){

            case(0):
            System.out.println("Enter the new crime type");
            caseToChange.setCrimeType(scanner.nextLine());
            break;

            case(1):
            System.out.println("Enter the new date (Enter month number, then day, then year, hit ENTER after each input)");
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            int year = scanner.nextInt();
            caseToChange.setDate(day, month, year);
            break;

            case(2):
            System.out.println("Enter the new description");
            caseToChange.setDescription(scanner.nextLine());
            break;

            case(3):
            System.out.println("Enter the new location");
            caseToChange.setLocation(scanner.nextLine());
            break;

            case(4):
            while(true)
            {
                System.out.println("Enter a new criminal (enter their full name), then hit ENTER. To move on, type EXIT");
                if(scanner.nextLine().equalsIgnoreCase("exit"))
                    break;
                Criminal newCriminal = databaseApp.searchCriminalByName(scanner.nextLine());
                if(newCriminal == null)
                {
                    System.out.println("That criminal is not in the database. Would you like to add a new one? (enter y/n then hit ENTER)");
                    if(scanner.next().equalsIgnoreCase("y"))
                    {
                        createCriminal();
                        System.out.println("Enter the full name of the criminal you just created, then hit ENTER");
                        newCriminal = databaseApp.searchCriminalByName(scanner.nextLine());
                        caseToChange.addToCriminals(newCriminal.getFirstName() + " " + newCriminal.getLastName());
                    }
                    else
                        continue;
                    
                }
                else
                    caseToChange.addToCriminals(newCriminal.getFirstName() + " " + newCriminal.getLastName());
            }
            break;

            case(5):
            while(true)
            {
                System.out.println("Enter a new victim (enter their full name), then hit ENTER. To move on, type EXIT");
                if(scanner.nextLine().equalsIgnoreCase("exit"))
                    break;
                Victim newVictim = databaseApp.searchVictimByName(scanner.nextLine());
                if(newVictim == null)
                {
                    System.out.println("That victim is not in the database. Would you like to add a new one? (enter y/n then hit ENTER)");
                    if(scanner.next().equalsIgnoreCase("y"))
                    {
                        createVictim();
                        System.out.println("Enter the full name of the victim you just created, then hit ENTER");
                        newVictim = databaseApp.searchVictimByName(scanner.nextLine());
                        caseToChange.addToVictims(newVictim.getFirstName() + " " + newVictim.getLastName());
                    }
                    else
                        continue;
                    
                }
                else
                    caseToChange.addToVictims(newVictim.getFirstName() + " " + newVictim.getLastName());
            }
            break;

            case(6):
            while(true)
            {
                System.out.println("Enter a new officer (enter their full name), then hit ENTER. To move on, type EXIT");
                if(scanner.nextLine().equalsIgnoreCase("exit"))
                    break;
                Officer newOfficer = databaseApp.searchOfficerByName(scanner.nextLine());
                if(newOfficer== null)
                {
                    System.out.println("That officer is not in the database. Would you like to add a new one? (enter y/n then hit ENTER)");
                    if(scanner.next().equalsIgnoreCase("y"))
                    {
                        createOfficer();
                        System.out.println("Enter the full name of the officer you just created, then hit ENTER");
                        newOfficer = databaseApp.searchOfficerByName(scanner.nextLine());
                        caseToChange.addToOfficers(newOfficer.getFirstName() + " " + newOfficer.getLastName());
                    }
                    else
                        continue;
                    
                }
                else
                    caseToChange.addToOfficers(newOfficer.getFirstName() + " " + newOfficer.getLastName());
            }
            break;

            case(7):
            while(true)
            {
                System.out.println("Enter a new witness (enter their full name), then hit ENTER. To move on, type EXIT");
                if(scanner.nextLine().equalsIgnoreCase("exit"))
                    break;
                Witness newWitness= databaseApp.searchWitnessByName(scanner.nextLine());
                if(newWitness == null)
                {
                    System.out.println("That witness is not in the database. Would you like to add a new one? (enter y/n then hit ENTER)");
                    if(scanner.next().equalsIgnoreCase("y"))
                    {
                        createWitness();
                        System.out.println("Enter the full name of the witness you just created, then hit ENTER");
                        newWitness = databaseApp.searchWitnessByName(scanner.nextLine());
                        caseToChange.addToWitnesses(newWitness.getFirstName() + " " + newWitness.getLastName());
                    }
                    else
                        continue;
                    
                }
                else
                    caseToChange.addToWitnesses(newWitness.getFirstName() + " " + newWitness.getLastName());
            }
            break;

        }
            databaseApp.changeCase(caseToChange);
            System.out.println("The changes have been succesfully made");
        }

    }

    private void searchPerson()
    {
        for(int i=0; i<personOptions.length; i++)
            System.out.println((i+1) + ". " + personOptions[i]);
        int userCommand = 0;
        System.out.println("What kind of profile would you like to make? (Enter the corresponding number and hit ENTER)\n");
        while(true)
        {
        userCommand = scanner.nextInt() - 1;
        if(userCommand < 0 || userCommand > personOptions.length - 1)
        {
            System.out.println("Sorry that is not a valid input");
            continue;
        }
        break;
        }

        switch(userCommand){

            case(0):
            searchCriminal();
            break;

            case(1):
            searchVictim();
            break;

            case(2):
            searchOfficer();

            case(3):
            searchWitness();
            break;
        }

 
    }

    private void searchCriminal()
    {
        for(int i=0; i<criminalOptions.length ; i++)
            System.out.println((i+1) + ". " + criminalOptions[i]);
        System.out.println("What would you like to search by? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;

        switch(userCommand){

            case(0):
            System.out.println("Enter the first name you would like to search by.");
            ArrayList<Criminal> criminalMatches = databaseApp.searchCriminalByFirstName(scanner.nextLine());
            if(emptyCriminalSearch(criminalMatches, "first name"))
                break;
            printCriminals(criminalMatches);
            break;

            case(1):
            System.out.println("Enter the last name you would like to search by.");
            criminalMatches = databaseApp.searchCriminalByLastName(scanner.nextLine());
            if(emptyCriminalSearch(criminalMatches, "last name"))
                break;
            printCriminals(criminalMatches);
            break;

            case(2):
            System.out.println("Enter the age range you would like to search by. (Enter the lower age, then the higher age. If the range is one year then enter that age twice)");
            int lowAge = scanner.nextInt();
            int highAge = scanner.nextInt();
            criminalMatches = databaseApp.searchCriminalByAge(lowAge, highAge);
            if(emptyCriminalSearch(criminalMatches, "age"))
                break;
            printCriminals(criminalMatches);
            break;

            case(3):
            System.out.println("Enter the sex you would like to search by.");
            criminalMatches = databaseApp.searchCriminalBySex(scanner.nextLine());
            if(emptyCriminalSearch(criminalMatches, "sex"))
                break;
            printCriminals(criminalMatches);
            break;

            case(4):
            System.out.println("Enter the nickname you would like to search by.");
            criminalMatches = databaseApp.searchCriminalByNickname(scanner.nextLine());
            if(emptyCriminalSearch(criminalMatches, "nickname"))
                break;
            printCriminals(criminalMatches);
            break;

            case(5):
            System.out.println("Enter the height you would like to search by. (Enter the feet and then the inches)");
            int feet = scanner.nextInt();
            int inches = scanner.nextInt();
            criminalMatches = databaseApp.searchCriminalByHeight(feet, inches);
            if(emptyCriminalSearch(criminalMatches, "height"))
                break;
            printCriminals(criminalMatches);
            break;

            case(6):
            System.out.println("Enter the weight range you would like to search by. (Enter the low weight first and then the high weight)");
            double lowWeight = scanner.nextDouble();
            double highWeight = scanner.nextDouble();
            criminalMatches = databaseApp.searchCriminalByWeight(lowWeight, highWeight);
            if(emptyCriminalSearch(criminalMatches, "weight"))
                break;
            printCriminals(criminalMatches);
            break;

            case(7):
            System.out.println("Enter the tattoo you would like to search by.");
            criminalMatches = databaseApp.searchCriminalByTattoo(scanner.nextLine());
            if(emptyCriminalSearch(criminalMatches, "tattoo"))
                break;
            printCriminals(criminalMatches);
            break;

            case(8):
            System.out.println("Enter the shoe size range you would like to search by.(Enter the low shoe size first then the high shoe size)");
            double lowShoeSize = scanner.nextDouble();
            double highShoeSize = scanner.nextDouble();
            criminalMatches = databaseApp.searchCriminalByShoeSize(lowShoeSize, highShoeSize);
            if(emptyCriminalSearch(criminalMatches, "shoe size"))
                break;
            printCriminals(criminalMatches);
            break;

            case(9):
            System.out.println("Enter the piercing you would like to search by.");
            criminalMatches = databaseApp.searchCriminalByPiercing(scanner.nextLine());
            if(emptyCriminalSearch(criminalMatches, "piercing"))
                break;
            printCriminals(criminalMatches);
            break;

            case(10):
            criminalMatches = databaseApp.searchCriminalByUnderage();
            if(emptyCriminalSearch(criminalMatches, "underage status"))
                break;
            printCriminals(criminalMatches);
            break;
        }
    }

    private void searchVictim()
    {
        for(int i=0; i<victimOptions.length; i++)
            System.out.println((i+1) + ". " + victimOptions[i]);
        System.out.println("What would you like to search by? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;

        switch(userCommand){

            case(0):
            System.out.println("Enter the first name you would like to search by.");
            ArrayList<Victim> victimMatches = databaseApp.searchVictimByFirstName(scanner.nextLine());
            if(emptyVictimSearch(victimMatches, "first name"))
                break;
            printVictims(victimMatches);
            break;

            case(1):
            System.out.println("Enter the last name you would like to search by.");
            victimMatches = databaseApp.searchVictimByLastName(scanner.nextLine());
            if(emptyVictimSearch(victimMatches, "last name"))
                break;
            printVictims(victimMatches);
            break;

            case(2):
            System.out.println("Enter the age range you would like to search by. (Enter the low age first then the high age)");
            int lowAge = scanner.nextInt();
            int highAge = scanner.nextInt();
            victimMatches = databaseApp.searchVictimByAge(lowAge, highAge);
            if(emptyVictimSearch(victimMatches, "age"))
                break;
            printVictims(victimMatches);
            break;

            case(3):
            System.out.println("Enter the sex you would like to search by.");
            victimMatches = databaseApp.searchVictimBySex(scanner.nextLine());
            if(emptyVictimSearch(victimMatches, "sex"))
                break;
            printVictims(victimMatches);
            break;

            case(4):
            System.out.println("Cannot search by report");
            break;

            case(5):
            System.out.println("Enter the hospital you would like to search by");
            victimMatches = databaseApp.searchVictimByHospital(scanner.nextLine());
            if(emptyVictimSearch(victimMatches, "hospital"))
                break;
            printVictims(victimMatches);
            break;

            case(6):
            System.out.println("Enter the phone number you would like to search by");
            victimMatches = databaseApp.searchVictimByPhoneNum(scanner.nextInt());
            if(emptyVictimSearch(victimMatches, "phone number"))
                break;
            printVictims(victimMatches);
            break;

            case(7):
            System.out.println("Enter the address you would like to search by");
            victimMatches = databaseApp.searchVictimByAddress(scanner.nextLine());
            if(emptyVictimSearch(victimMatches, "address"))
                break;
            printVictims(victimMatches);
            break;
        }
    }

    private void searchOfficer()
    {
        for(int i=0; i<officerOptions.length; i++)
            System.out.println((i+1) + ". " + officerOptions[i]);
        System.out.println("What would you like to search by? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;

        switch(userCommand){

            case(0):
            System.out.println("Enter the first name you would like to search by.");
            scanner.nextLine();
            ArrayList<Officer> officerMatches = databaseApp.searchOfficerByFirstName(scanner.nextLine());
            if(emptyOfficerSearch(officerMatches, "first name"))
                break;
            printOfficers(officerMatches);
            break;

            case(1):
            System.out.println("Enter the last name you would like to search by.");
            scanner.nextLine();
            officerMatches = databaseApp.searchOfficerByLastName(scanner.nextLine());
            if(emptyOfficerSearch(officerMatches, "last name"))
                break;
            printOfficers(officerMatches);
            break;       


            case(2):
            System.out.println("Enter the age range you would like to search by. (Enter the low age first then the high age)");
            int lowAge = scanner.nextInt();
            int highAge = scanner.nextInt();
            officerMatches = databaseApp.searchOfficerByAge(lowAge, highAge);
            if(emptyOfficerSearch(officerMatches, "age"))
                break;
            printOfficers(officerMatches);
            break;
            
            case(3):
            System.out.println("Enter the sex you would like to search by.");
            officerMatches = databaseApp.searchOfficerBySex(scanner.nextLine());
            if(emptyOfficerSearch(officerMatches, "sex"))
                break;
            printOfficers(officerMatches);
            break; 

            case(4):
            System.out.println("Enter the rank you would like to search by.");
            officerMatches = databaseApp.searchOfficerByRank(scanner.nextLine());
            if(emptyOfficerSearch(officerMatches, "rank"))
                break;
            printOfficers(officerMatches);
            break;

            case(5):
            System.out.println("Enter the city you would like to search by.");
            officerMatches = databaseApp.searchOfficerByCity(scanner.nextLine());
            if(emptyOfficerSearch(officerMatches, "city"))
                break;
            printOfficers(officerMatches);
            break;

            case(6):
            System.out.println("Enter the office number you would like to search by.");
            officerMatches = databaseApp.searchOfficerByOfficeNum(scanner.nextInt());
            if(emptyOfficerSearch(officerMatches, "office number"))
                break;
            printOfficers(officerMatches);
            break;

            case(7):
            System.out.println("Enter the office address you would like to search by.");
            officerMatches = databaseApp.searchOfficerByOfficeAddress(scanner.nextLine());
            if(emptyOfficerSearch(officerMatches, "office address"))
                break;
            printOfficers(officerMatches);
            break;
        }
    }

    private void searchWitness()
    {
        for(int i=0; i<witnessOptions.length; i++)
            System.out.println((i+1) + ". " + witnessOptions[i]);
        System.out.println("What would you like to search by? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;

        switch(userCommand){

            case(0):
            System.out.println("Enter the first name you would like to search by.");
            ArrayList<Witness> witnessMatches = databaseApp.searchWitnessByFirstName(scanner.nextLine());
            if(emptyWitnessSearch(witnessMatches, "first name"))
                break;
            printWitnesses(witnessMatches);
            break;

            case(1):
            System.out.println("Enter the last name you would like to search by.");
            witnessMatches = databaseApp.searchWitnessByLastName(scanner.nextLine());
            if(emptyWitnessSearch(witnessMatches, "last name"))
                break;
            printWitnesses(witnessMatches);
            break;

            case(2):
            System.out.println("Enter the age range you would like to search by. (Enter the low age first then the high age)");
            int lowAge = scanner.nextInt();
            int highAge = scanner.nextInt();
            witnessMatches = databaseApp.searchWitnessByAge(lowAge, highAge);
            if(emptyWitnessSearch(witnessMatches, "age"))
                break;
            printWitnesses(witnessMatches);
            break;

            case(3):
            System.out.println("Enter the sex you would like to search by.");
            witnessMatches = databaseApp.searchWitnessBySex(scanner.nextLine());
            if(emptyWitnessSearch(witnessMatches, "sex"))
                break;
            printWitnesses(witnessMatches);
            break;

            case(4):
            System.out.println("Cannot search by testimony");
            break;

            case(5):
            System.out.println("Enter the phone number you would like to search by.");
            witnessMatches = databaseApp.searchWitnessByPhoneNum(scanner.nextInt());
            if(emptyWitnessSearch(witnessMatches, "phone number"))
                break;
            printWitnesses(witnessMatches);
            break;

            case(6):
            System.out.println("Enter the address you would like to search by.");
            witnessMatches = databaseApp.searchWitnessByAddress(scanner.nextLine());
            if(emptyWitnessSearch(witnessMatches, "address"))
                break;
            printWitnesses(witnessMatches);
            break;
        }
    }



    private boolean emptyCriminalSearch(ArrayList<Criminal> criminals, String searchType)
    {
        if(criminals.size() == 0)
        {
            System.out.println("There are no criminals with that " + searchType);
            return true;
        }
        else    
        return false;
    }

    private void printCriminals(ArrayList<Criminal> criminals)
    {
        for(int i=0; i<criminals.size(); i++)
            criminals.get(i).print();
    }

    private boolean emptyVictimSearch(ArrayList<Victim> victims, String searchType)
    {
        if(victims.size() == 0)
        {
            System.out.println("There are no victims with that " + searchType);
            return true;
        }
        else
        return false;

    }
    private void printVictims(ArrayList<Victim> victims)
    {
        for(int i=0; i<victims.size(); i++)
            victims.get(i).print();
    }

    private boolean emptyOfficerSearch(ArrayList<Officer> officers, String searchType)
    {
        if(officers.size() == 0)
        {
            System.out.println("There are no officers with that " + searchType);
            return true;
        }
        return false;
    }

    private void printOfficers(ArrayList<Officer> officers)
    {
        for(int i=0; i<officers.size(); i++)
            officers.get(i).print();

    }

    private boolean emptyWitnessSearch(ArrayList<Witness> witnesses, String searchType)
    {
        if(witnesses.size() == 0)
        {
            System.out.println("There are no witnesses with that " + searchType);
            return true;
        }
        return false;
    }

    private void printWitnesses(ArrayList<Witness> witnesses)
    {
        for(int i=0; i<witnesses.size(); i++)
            witnesses.get(i).print();
    }

    private void searchCase()
    {
        for(int i=0; i<caseOptions.length; i++)
            System.out.println((i+1) + ". " + caseOptions[i]);
        System.out.println("What would you like to search by? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;

        switch(userCommand){

            case(0):
            System.out.println("Enter the case number you would like to search.");
            Case caseMatch = databaseApp.searchCaseByCaseNum(scanner.nextInt());
            if(caseMatch == null)
            {
                System.out.println("There is no case with that case number.");
                break;
            }
            caseMatch.print();
            break;

            case(1):
            System.out.println("Enter the crime type you would like to search by.");
            ArrayList<Case> caseMatches = databaseApp.searchCaseByCrimeType(scanner.nextLine());
            if(emptyCaseSearch(caseMatches, "crime type"))
                break;
            printCases(caseMatches);
            break;

            case(2):
            System.out.println("Enter the date you would like to search by. (Enter the month number, then the date, then the year)");
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            int year = scanner.nextInt();
            caseMatches = databaseApp.searchCaseByDate(month, day, year);
            if(emptyCaseSearch(caseMatches, "date"))
                break;
            printCases(caseMatches);
            break;

            case(3):
            System.out.println("Cannot search by description");
            break;

            case(4):
            System.out.println("Enter the location you would like to search by.");
            caseMatches = databaseApp.searchCaseByLocation(scanner.nextLine());
            if(emptyCaseSearch(caseMatches, "location"))
                break;
            printCases(caseMatches);
            break;

            case(5):
            System.out.println("Enter the criminal you would like to search. (Enter their full name)");
            caseMatches = databaseApp.searchCaseByCriminal(scanner.nextLine());
            if(emptyCaseSearch(caseMatches, "criminal"))
                break;
            printCases(caseMatches);
            break;

            case(6):
            System.out.println("Enter the victim you would like to search. (Enter their full name)");
            caseMatches = databaseApp.searchCaseByVictim(scanner.nextLine());
            if(emptyCaseSearch(caseMatches, "victim"))
                break;
            printCases(caseMatches);
            break;

            case(7):
            System.out.println("Enter the officer you would like to search. (Enter their full name)");
            caseMatches = databaseApp.searchCaseByOfficer(scanner.nextLine());
            if(emptyCaseSearch(caseMatches, "officer"))
                break;
            printCases(caseMatches);
            break;

            case(8):
            System.out.println("Enter the witness you would like to search. (Enter their full name)");
            caseMatches = databaseApp.searchCaseByWitness(scanner.nextLine());
            if(emptyCaseSearch(caseMatches, "witness"))
                break;
            printCases(caseMatches);
            break;


        }
    }

    private boolean emptyCaseSearch(ArrayList<Case> cases, String searchType)
    {
        if(cases.size() == 0)
        {
            System.out.println("There are no cases with that " + searchType);
            return true;
        }
        return false;
    }

    private void printCases(ArrayList<Case> cases)
    {
        for(int i=0; i<cases.size(); i++)
            cases.get(i).print();
    }
}