/**
 * user interface
 * @author Kennedy Fairey
 */

import java.util.Scanner;
import java.util.UUID;



import java.util.ArrayList;
public class DatabaseUI {

    /**
     * collection of intial comments for the interface of application
     */
    private static final String HOME_MSG = "Welcome to the Criminal Investigation Database";
    private static final String[] LOGIN_OPTIONS = {"Login", "Create Profile"};
    private static final String[] homePageOptions = {"Create a Person(s) Profile", "Change an existing Person(s) Profile", "Create a Case Profile", 
    "Change a Case Profile", "Search a Person(s) Profile", "Search a Case Profile", "Print Person to a Text File", "Print Case to a text file", "Logout"};
    private static final String[] criminalOptions = {"First name", "Last name", "Age", "Sex", "Nickname", "Height", "Weight", "Race",
    "Hair Color", "Eye Color", "Description", "Tattoos", "Shoe size", "Piercings","Underage status", "Jail Status"};
    private static final String[] victimOptions = {"First name", "Last name", "Age", "Sex", "Report", "Hospital", "Phone number", "Address"};
    private static final String[] officerOptions = {"First name", "Last name", "Age", "Sex", "Rank","City", "Officer number", "Address"};
    private static final String[] witnessOptions = {"First name", "Last name", "Age", "Sex", "Testimony", "Phone number", "Address"};
    private static final String[] caseOptions = {"Case Number","Crime Type", "Date", "Description", "Location","Evidence", "Criminals", "Victims", "Officers", "Witnesses"};
    private static final String[] personOptions = {"Criminal", "Victim", "Police Officer", "Witness"};
    private Scanner scanner;
    private DatabaseApp databaseApp;

    /**
     * creation of input scanner
     */
    public DatabaseUI()
    {
        scanner = new Scanner(System.in);
        databaseApp = new DatabaseApp();
    }


    /**
     * main method to start calling to the rest of code
     * @param args
     */
    public static void main(String args[])
    {
        DatabaseUI ui = new DatabaseUI();
        ui.run();

    }

    /**
     * prints out menu and states a switch case for options to do within system
     */
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
                break;

                case(4):
                //create this method in database
                searchPerson();
                break;

                case(5):
                //create this method in database
                searchCase();
                break;

                case(6):
                printPerson();
                break;

                case(7):
                printCase();
                break;


            }

        }
        System.out.println("You've been successfully logged out of your account");
    }

    /**
     * displays homepage to terminal
     */
    private void displayHomePage()
    {
        System.out.println("*****Home Page*****");

        for(int i=0; i<homePageOptions.length; i++)
            System.out.println((i+1) + ". " + homePageOptions[i]);
        System.out.println("");
    }

    /**
     * asks for user input for next step of action
     * @param numOfCommands variable to make sure an option is chosen
     * @return userCommand
     */
    private int getUserCommand(int numOfCommands)
    {
        System.out.println("What would you like to do? (Enter the corresponding number then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;
        scanner.nextLine();

        if(userCommand >= 0 && userCommand <= numOfCommands)
            return userCommand;
        else    
            return -1;
    }

    /**
     * login mehtod to check username and password
     * @return a login status or a false due to no account/ incorrect info
     */
    private boolean login()
    {
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        if(!databaseApp.login(username, password))
        {
            System.out.println("The username or password you entered was incorrect");
            return false;
        }
        else
            return databaseApp.login(username, password);
    }

    /**
     * creation of user profile
     * @return instance of user with name, username, and passsword
     */
    private boolean createUser()
    {
        UUID userID = null;
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

        if(!databaseApp.createUser(userID, firstName, lastName, username, password))
        {
            System.out.println("There already exists a user with that username");
            return false;
        }
        else    
            return databaseApp.createUser(userID, firstName, lastName, username, password);
            
    }

    /**
     * Creation of person, and options to what kind of person to create
     */
    private void createPerson()
    {
        for(int i=0; i<personOptions.length; i++)
            System.out.println((i+1) + ". " + personOptions[i]);
        int userCommand = 0;
        System.out.println("What kind of profile would you like to make? (Enter the corresponding number and hit ENTER)\n");
        while(true)
        {
        userCommand = scanner.nextInt() - 1;
        scanner.nextLine();
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


    /**
     * collection of criminal information and checking if this criminal exists
     */
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
        scanner.nextLine();
        int inches = scanner.nextInt();
        String height = new Height(feet, inches).toString();
        scanner.nextLine();
        double weight = Double.parseDouble(enterInfo("Weight", "Criminal"));
        String race = enterInfo("Race", "Criminal");
        String hairColor = enterInfo("Hair Color", "Criminal");
        String eyeColor = enterInfo("Eye Color", "Criminal");
        String description = enterInfo("Description", "Criminal");
        ArrayList<String> tattoos = enterInfoLoop("Tattoos (Enter tattoo then hit ENTER, either continue to enter tattoos or enter \"exit\" to exit)", "Criminal");
        double shoeSize = Double.parseDouble(enterInfo("Shoe Size", "Criminal"));
        ArrayList<String> piercings = enterInfoLoop("Piercings (Enter piercing then hit ENTER, either continue to enter piercings or enter \"exit\" to exit)", "Criminal");
        String jailStatus = enterInfo("Jail Status (Enter 'y' for yes and 'n' for no)", "Criminal");
        boolean inJail = true;
        if(jailStatus.equalsIgnoreCase("y"))
            inJail = true;
        else if(jailStatus.equalsIgnoreCase("n"))
            inJail = false;
        if(databaseApp.createCriminal(firstName, lastName, age, sex, nickname, height, weight, race,hairColor, eyeColor, description, tattoos, shoeSize, piercings, inJail))
            System.out.println("Criminal has been successfully inserted into the database");
        else   
            System.out.println("A criminal of that name already exists in this database");
    }

    /**
     * creation of a victim and collection of information
     */
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
        long phoneNum = Long.parseLong(enterInfo("Phone Number", "Victim"));

        String address = enterInfo("Address", "Victim");

        if(databaseApp.createVictim(firstName, lastName, age, sex, report, hospital, phoneNum, address))
            System.out.println("The victim has been successfully inserted into the database.");
        else    
            System.out.println("A victim with that name already exists in this database");
    }

    /**
     * creation of officer and collection of officer information
     */
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
        long phoneNum = Long.parseLong(enterInfo("Phone number", "Officer"));
        String address = enterInfo("Address", "Officer");

        if(databaseApp.createOfficer(firstName, lastName, age, sex, rank, city, phoneNum, address))
            System.out.println("The officer has been successfully inserted in the database.");
        else    
            System.out.println("An officer of that name already exists in the database");
    }

    /**
     * creation of witness and collection of witness information
     */
    private void createWitness()
    {

        String firstName = enterInfo("First Name", "Witness");
        String lastName = enterInfo("Last Name", "Witness");
        int age = Integer.parseInt(enterInfo("Age", "Witness"));
        String sex = enterInfo("Sex", "Witness");
        String testimony = enterInfo("Testimony", "Witness");
        long phoneNum = Long.parseLong(enterInfo("Phone number", "Witness"));
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

    /**
     * collection of person information
     * @param data
     * @param person
     * @return user input on scanner
     */
    private String enterInfo(String data, String person)
    {
        System.out.println("Enter the "+ person + "'s " + data + ": ");
        return scanner.nextLine();
    }

    /**
     * collection person's information via loop and scanner input from user
     * @param data
     * @param person
     * @return elements
     */
    private ArrayList<String> enterInfoLoop(String data, String person)
    {
        System.out.println("Enter the " + person + "'s " + data + ": ");
        ArrayList<String> elements = new ArrayList<String>();
        while(true)
        {
            if(scanner.nextLine().equalsIgnoreCase("Exit")) 
                break;
            elements.add(scanner.nextLine());
        }
        return elements;

    }

    /**
     * changing the information on a person based on user input
     */
    private void changePerson()
    {
        while(true)
        {
        for(int i=0; i<personOptions.length; i++)
            System.out.println((i+1) + ". " + personOptions[i]);
        System.out.println("Which type of person would you like to make a change to?(Type the corresponding number then hit ENTER)");

        int userInput = scanner.nextInt() - 1;
        scanner.nextLine();
        if(userInput < 0 || userInput > personOptions.length)
        {
            System.out.println("That is not a valid input");
            continue;
        }

        switch(userInput)
        {
            case(0):
            makeChanges("Criminal");
            Criminal criminal = databaseApp.searchCriminalByName(scanner.nextLine());
            if(criminal == null)
            {
                System.out.println("That is not a criminal in the database");
                break;
            }
            System.out.println(criminal.firstName + " " + criminal.lastName + " is a criminal in the database");
            criminal.print();
            changesToCriminal(criminal);
            break;

            case(1):
            makeChanges("Victim");
            Victim victim = databaseApp.searchVictimByName(scanner.nextLine());
            if(victim == null)
            {
                System.out.println("That is not a victim in the database");
                break;
            }
            System.out.println(victim.firstName + " " + victim.lastName + " is a victim in the database");
            victim.print();
            changesToVictim(victim);
            break;

            case(2):
            makeChanges("Officer");
            Officer officer = databaseApp.searchOfficerByName(scanner.nextLine());
            if(officer == null)
            {
                System.out.println("That is not an officer in the database");
                break;
            }
            System.out.println(officer.firstName + " " + officer.lastName + " is an officer in the database");
            officer.print();
            changesToOfficer(officer);

            break;

            case(3):
            makeChanges("Witness");
            Witness witness = databaseApp.searchWitnessByName(scanner.nextLine());
            if(witness == null)
            {
                System.out.println("That is not a witness in the database");
                break;
            }
            System.out.println(witness.firstName + " " + witness.lastName + " is a witness in the database");
            witness.print();
            changesToWitness(witness);
            break;
            
            
        }
        break;
        
        
    
    }
    }
    
    /**
     * print function for asking for user input
     * @param person
     */
    private void makeChanges(String person)
    {
        System.out.println("Which " + person + "'s profile would you like to make changes to? Enter their full name then ENTER.");
    }

    /**
     * asks what user would like to make changes to criminal, and corresponds with a switch case
     * @param criminal
     */
    private void changesToCriminal(Criminal criminal)
    {
        for(int i=0; i<criminalOptions.length; i++)
            System.out.println((i+1) + ". " + criminalOptions[i]);
        System.out.println("What would you like to make changes to? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;
        scanner.nextLine();

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
            System.out.println("Enter the new hair color");
            criminal.setHairColor(scanner.nextLine());
            break;

            case(9):
            System.out.println("Enter the new eye color");
            criminal.setEyeColor(scanner.nextLine());
            break;

            case(10):
            System.out.println("Enter the new description");
            criminal.setDescription(scanner.nextLine());
            break;

            case(11):
            while(true)
            {
                System.out.println("Enter a new tattoo, then hit ENTER,to move on, type EXIT");
                String tattoo = scanner.nextLine();
                if(tattoo.equalsIgnoreCase("exit"))
                    break;
                criminal.addToTattoos(tattoo);
            }
            break;

            case(12):
            System.out.println("Enter the new shoe size");
            criminal.setShoeSize(scanner.nextDouble());
            break;

            case(13):
            while(true)
            {
            System.out.println("Enter a new piercing, then hit ENTER, to move on, type EXIT");
            String piercing = scanner.nextLine();
            if(piercing.equalsIgnoreCase("exit"))
                break;
            criminal.addToPiercing(piercing);
            }
            break;

            case(14):
            boolean jailStatus = criminal.getInJail();
            if(jailStatus)
            {
                while(true)
                {
                System.out.println("This criminal is in prison, to change their status to not in prison, enter 'y'");
                String inJail = scanner.nextLine();
                if(inJail.equalsIgnoreCase("y"))
                {
                    criminal.setInJail(!jailStatus);
                    break;
                }
                else
                    System.out.println("That is an invalid input");

                }
                break;  

            }
            else 
            {
                while(true)
                {
                    System.out.println("This criminal is not in prison, to change their status to not in prison, enter 'y'");
                    String inJail = scanner.nextLine();
                    if(inJail.equalsIgnoreCase("y"))
                    {
                        criminal.setInJail(!jailStatus);
                        break;
                    }
                    else
                        System.out.println("That is an invalid input");
                }
                break;
            }
        }

        databaseApp.changeCriminal(criminal);
        System.out.println("The changes have been made successfully");

    }

    /**
     * asks what changes to the victim the user would like to make
     * @param victim
     */
    private void changesToVictim(Victim victim)
    {
        for(int i=0; i<victimOptions.length; i++)
            System.out.println((i+1) + ". " + victimOptions[i]);
        System.out.println("What would you like to make changes to? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;
        scanner.nextLine();

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
                victim.setPhoneNum(scanner.nextLong());
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

    /**
     * asks the user what changes to officer would like to be made
     * @param officer
     */
    private void changesToOfficer(Officer officer)
    {
        for(int i=0; i<officerOptions.length; i++)
            System.out.println((i+1) + ". " + officerOptions[i]);
        System.out.println("What would you like to make changes to? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;
        scanner.nextLine();

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
            officer.setOfficeNum(scanner.nextLong());
            break;

            case(6):
            System.out.println("Enter new address");
            officer.setOfficeAddress(scanner.nextLine());
            break;
        }

        databaseApp.changeOfficer(officer);
        System.out.println("The changes have been successfully made");
    }

    /**
     * asks user what changes to witness they would like to be made
     * @param witness
     */
    private void changesToWitness(Witness witness)
    {
        for(int i=0; i<witnessOptions.length; i++)
            System.out.println((i+1) + ". " + witnessOptions[i]);
        System.out.println("What would you like to make changes to? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;
        scanner.nextLine();

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
            witness.setPhoneNum(scanner.nextLong());
            break;

            case(6):
            System.out.println("Enter new address");
            witness.setAddress(scanner.nextLine());
            break;
        }

        databaseApp.changeWitness(witness);
        System.out.println("The changes have been made successfully");
    }

    /**
     * creation of a case, and filling of case information, including criminal, victim, officer, etc.
     */
    private void createCase()
    {
        int caseNum = -1;
        System.out.println("Enter the type of crime");
        String crimeType = scanner.nextLine();

        System.out.println("Enter the date of the crime (Enter the month in numerical form, hit ENTER, enter the day, hit ENTER, then enter the year, then hit ENTER");
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        int year = scanner.nextInt();
        scanner.nextLine();
        String date = new Date(month, day, year).toString();


        System.out.println("Enter a description of the crime");
        String description = scanner.nextLine();

        System.out.println("Enter the location of the crime");
        String location = scanner.nextLine();

        System.out.println("Enter the pieces of evidence from the crime. (enter one then hit ENTER, type exit to stop)");
        ArrayList<String> evidence = new ArrayList<String>();
        while(true)
        {
            String pieceOfEvidence = scanner.nextLine();
            if(pieceOfEvidence.equalsIgnoreCase("exit"))
                break;
            else
            {
                evidence.add(pieceOfEvidence);
            }
        }

        System.out.println("Enter the full names of the criminals associated with this case (enter name, hit ENTER, then either keep entering names or type \"exit\" to stop");
        ArrayList<String> criminals = new ArrayList<String>();
        while(true)
        {
        String criminal = scanner.nextLine();
        if(criminal.equalsIgnoreCase("exit"))
            break;
        //need to find a way to link every criminal typed to the case
        if(databaseApp.searchCriminalByName(criminal) != null)
        {
            System.out.println("That criminal is in the database, they have been added to the case. Continue adding criminals or type exit to exit.");
            criminals.add(criminal);
        }
        else    
            {
                System.out.println("That criminal is not in the database, would you like to add a new one? (y/n)");
                if(scanner.nextLine().equalsIgnoreCase("y"))
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
        System.out.println("Enter the full names of the victim(s) associated with this case (enter name, hit ENTER, then either keep entering names or type \"exit\" to stop");
        ArrayList<String> victims = new ArrayList<String>();
        while(true)
        {
        String victim = scanner.nextLine();
        if(victim.equalsIgnoreCase("exit"))
            break;
        //need to find a way to link every criminal typed to the case
        if(databaseApp.searchVictimByName(victim) != null)
        {
            System.out.println("That victim is in the database, they have been added to the case. Continue adding victims or type exit to exit.");
            victims.add(victim);
        }
        else    
            {
                System.out.println("That victim is not in the database, would you like to add a new one? (y/n)");
                if(scanner.nextLine().equalsIgnoreCase("y"))
                {
                    createVictim();
                    System.out.println("Enter the name full name of the victim just created to add them to the case.");
                    victims.add(scanner.nextLine());
                    System.out.println("Continue entering victims, or type exit to stop");
                }
                else    
                {
                    System.out.println("Either continue entering victims, or type exit to stop");
                    continue;
                }
            }    
        }
        System.out.println("Enter the full names of the officer(s) associated with this case (enter name, hit ENTER, then either keep entering names or type \"exit\" to stop");
        ArrayList<String> officers = new ArrayList<String>();
        while(true)
        {
        String officer= scanner.nextLine();
        if(officer.equalsIgnoreCase("exit"))
            break;
        //need to find a way to link every criminal typed to the case
        if(databaseApp.searchOfficerByName(officer) != null)
        {
            System.out.println("That officer is in the database, they have been added to the case. Continue adding officers or type exit to exit.");
            officers.add(officer);
        }
        else    
            {
                System.out.println("That officer is not in the database, would you like to add a new one? (y/n)");
                if(scanner.nextLine().equalsIgnoreCase("y"))
                {
                    createOfficer();
                    System.out.println("Enter the name full name of the officer just created to add them to the case.");
                    criminals.add(scanner.nextLine());
                    System.out.println("Continue entering officers, or type exit to stop");
                }
                else    
                {
                    System.out.println("Either continue entering officer, or type exit to stop");
                    continue;
                }
            }    
        }
        System.out.println("Enter the full names of the witness(es) associated with this case (enter name, hit ENTER, then either keep entering names or type \"exit\" to stop");
        ArrayList<String> witnesses = new ArrayList<String>();
        while(true)
        {
        String witness = scanner.nextLine();
        if(witness.equalsIgnoreCase("exit"))
            break;
        //need to find a way to link every criminal typed to the case
        if(databaseApp.searchWitnessByName(witness) != null)
        {
            System.out.println("That witness is in the database, they have been added to the case. Continue adding witnesses or type exit to exit.");
            witnesses.add(witness);
        }
        else    
            {
                System.out.println("That witness is not in the database, would you like to add a new one? (y/n)");
                if(scanner.nextLine().equalsIgnoreCase("y"))
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


        if(databaseApp.createCase(caseNum, crimeType, date, description, location, evidence,  criminals, victims, officers, witnesses))
            System.out.println("The case was successfully inserted into the database.");

    }


    /**
     * asks user what case they would like to change, and how they would like to change it
     */
    private void changeCase()
    {
        System.out.println("Enter the case number you would like to change");
        Case caseToChange = databaseApp.searchCaseByCaseNum(scanner.nextInt());
        if(caseToChange == null){
            System.out.println("The case you searched does not exist");
            return;
        }
        caseToChange.print();
        while(true)
        {
        System.out.println("What would you like to change? (Enter the corresponding number, then hit ENTER)");
        for(int i=1; i<caseOptions.length; i++)
            System.out.println((i) + ". " + caseOptions[i]);

        int userCommand = scanner.nextInt() - 1;
        scanner.nextLine();

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
            System.out.println("Enter new pieces of evidence or type EXIT to stop");
            while(true)
            {
                String evidence = scanner.nextLine();
                if(evidence.equalsIgnoreCase("exit"))
                    break;
                caseToChange.addToEvidence(evidence);
            }
            break;

            case(5):
            while(true)
            {
                System.out.println("Enter a new criminal (enter their full name), then hit ENTER. To move on, type EXIT");
                String criminal = scanner.nextLine();
                if(criminal.equalsIgnoreCase("exit"))
                    break;
                Criminal newCriminal = databaseApp.searchCriminalByName(criminal);
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

            case(6):
            while(true)
            {
                System.out.println("Enter a new victim (enter their full name), then hit ENTER. To move on, type EXIT");
                String victim = scanner.nextLine();
                if(victim.equalsIgnoreCase("exit"))
                    break;
                Victim newVictim = databaseApp.searchVictimByName(victim);
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

            case(7):
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

            case(8):
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
            break;
        }

    }

    /**
     *  Searching through system for a match to search parameters
     */
    private void searchPerson()
    {
        for(int i=0; i<personOptions.length; i++)
            System.out.println((i+1) + ". " + personOptions[i]);
        int userCommand = 0;
        System.out.println("What kind of profile would you like to search? (Enter the corresponding number and hit ENTER)\n");
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
            break;

            case(3):
            searchWitness();
            break;
        }

 
    }

    /**
     * Search method for criminal, searches based on parameters entered by user
     */
    private void searchCriminal()
    {
        for(int i=0; i<criminalOptions.length ; i++)
            System.out.println((i+1) + ". " + criminalOptions[i]);
        System.out.println("What would you like to search by? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;
        scanner.nextLine();

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
            System.out.println("Enter the race you would like to search by.");
            criminalMatches = databaseApp.searchCriminalByRace(scanner.nextLine());
            if(emptyCriminalSearch(criminalMatches, "race"))
                break;
            printCriminals(criminalMatches);
            break;

            case(8):
            System.out.println("Enter the hair color you would like to search by.");
            criminalMatches = databaseApp.searchCriminalByHairColor(scanner.nextLine());
            if(emptyCriminalSearch(criminalMatches, "hair color"))
                break;
            printCriminals(criminalMatches);
            break;

            case(9):
            System.out.println("Enter the eye color you would like to search by.");
            criminalMatches = databaseApp.searchCriminalByEyeColor(scanner.nextLine());
            if(emptyCriminalSearch(criminalMatches, "eye color"))
                break;
            printCriminals(criminalMatches);
            break;

            case(10): 
            System.out.println("Cannot search by description");
            break;

            case(11):
            System.out.println("Enter the tattoo you would like to search by.");
            scanner.nextLine();
            criminalMatches = databaseApp.searchCriminalByTattoo(scanner.nextLine());
            if(emptyCriminalSearch(criminalMatches, "tattoo"))
                break;
            printCriminals(criminalMatches);
            break;

            case(12):
            System.out.println("Enter the shoe size range you would like to search by.(Enter the low shoe size first then the high shoe size)");
            double lowShoeSize = scanner.nextDouble();
            double highShoeSize = scanner.nextDouble();
            criminalMatches = databaseApp.searchCriminalByShoeSize(lowShoeSize, highShoeSize);
            if(emptyCriminalSearch(criminalMatches, "shoe size"))
                break;
            printCriminals(criminalMatches);
            break;

            case(13):
            System.out.println("Enter the piercing you would like to search by.");
            String piercing = scanner.nextLine();
            criminalMatches = databaseApp.searchCriminalByPiercing(piercing);
            if(emptyCriminalSearch(criminalMatches, "piercing"))
                break;
            printCriminals(criminalMatches);
            break;

            case(14):
            criminalMatches = databaseApp.searchCriminalByUnderage();
            if(emptyCriminalSearch(criminalMatches, "underage status"))
                break;
            printCriminals(criminalMatches);
            break;

            case(15):
            while(true)
            {
            System.out.println("Enter 'y' if you'd like to search criminals in jail, or enter 'n' to search criminals not in jail");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("y"))
            {
            criminalMatches = databaseApp.searchCriminalInJail(true);
            if(emptyCriminalSearch(criminalMatches, "jail status"))
                break;
            printCriminals(criminalMatches);
            break;
            }
            else if(input.equalsIgnoreCase("n"))
            {
                criminalMatches = databaseApp.searchCriminalInJail(false);
                if(emptyCriminalSearch(criminalMatches, "jail status"))
                    break;
                printCriminals(criminalMatches);
                break;
            }
            else
            {
                System.out.println("That is an invalid input");
            }
        }
        break;
            

        }
    }

    /**
     * searching for victim method
     * Search via parameters asked for by user input
     */
    private void searchVictim()
    {
        for(int i=0; i<victimOptions.length; i++)
            System.out.println((i+1) + ". " + victimOptions[i]);
        System.out.println("What would you like to search by? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;
        scanner.nextLine();

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
            victimMatches = databaseApp.searchVictimByPhoneNum(scanner.nextLong());
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

    /**
     * search function for officers
     * Searches officers by parameters by user input
     */
    private void searchOfficer()
    {
        for(int i=0; i<officerOptions.length; i++)
            System.out.println((i+1) + ". " + officerOptions[i]);
        System.out.println("What would you like to search by? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;
        scanner.nextLine();

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
            officerMatches = databaseApp.searchOfficerByOfficeNum(scanner.nextLong());
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

    /**
     * Witness search function
     * searches through witnesses based on user input parameter
     */
    private void searchWitness()
    {
        for(int i=0; i<witnessOptions.length; i++)
            System.out.println((i+1) + ". " + witnessOptions[i]);
        System.out.println("What would you like to search by? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;
        scanner.nextLine();

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
            witnessMatches = databaseApp.searchWitnessByPhoneNum(scanner.nextLong());
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



    /**
     * Checks if there was a criminal within the search parameters
     * @param criminals
     * @param searchType
     * @return true or false based on search
     */
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

    /**
     * print function
     * that will loop through the array list to print all criminals
     * @param criminals
     */
    private void printCriminals(ArrayList<Criminal> criminals)
    {
        for(int i=0; i<criminals.size(); i++)
            criminals.get(i).print();
    }

    /**
     * Victim search result
     * Checks if the search turned up empty
     * @param victims
     * @param searchType
     * @return true or false based on search
     */
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

    /**
     * Print function
     * Loops through Array list to print all victims
     * @param victims
     */
    private void printVictims(ArrayList<Victim> victims)
    {
        for(int i=0; i<victims.size(); i++)
            victims.get(i).print();
    }

    /**
     * Officer search results
     * checks if the officer exists within search parameters
     * @param officers
     * @param searchType
     * @return true or false if the officer exists
     */
    private boolean emptyOfficerSearch(ArrayList<Officer> officers, String searchType)
    {
        if(officers.size() == 0)
        {
            System.out.println("There are no officers with that " + searchType);
            return true;
        }
        return false;
    }

    /**
     * print function
     * loops through array list to print all officers
     * @param officers
     */
    private void printOfficers(ArrayList<Officer> officers)
    {
        for(int i=0; i<officers.size(); i++)
            officers.get(i).print();

    }

    /**
     * Witness search function results
     * Checks if there is a witness based on search parameters
     * @param witnesses
     * @param searchType
     * @return true or false if a witness exists
     */
    private boolean emptyWitnessSearch(ArrayList<Witness> witnesses, String searchType)
    {
        if(witnesses.size() == 0)
        {
            System.out.println("There are no witnesses with that " + searchType);
            return true;
        }
        return false;
    }

    /**
     * print function
     * loops through witness array to print all witnesses
     * @param witnesses
     */
    private void printWitnesses(ArrayList<Witness> witnesses)
    {
        for(int i=0; i<witnesses.size(); i++)
            witnesses.get(i).print();
    }

    /**
     * search case function
     * searches based on user input parameters
     */
    private void searchCase()
    {
        for(int i=0; i<caseOptions.length; i++)
            System.out.println((i+1) + ". " + caseOptions[i]);
        System.out.println("What would you like to search by? (Enter the corresponding number, then hit ENTER)");
        int userCommand = scanner.nextInt() - 1;
        scanner.nextLine();

        switch(userCommand){

            case(0):
            System.out.println("Enter the case number you would like to search.");
            Case caseMatch = databaseApp.searchCaseByCaseNum(scanner.nextInt());
            scanner.nextLine();
            if(caseMatch == null)
            {
                System.out.println("There is no case with that case number.");
                break;
            }
            caseMatch.print();
            break;

            case(1):
            System.out.println("Enter the crime type you would like to search by.");
            String crimeType = scanner.nextLine();
            ArrayList<Case> caseMatches = databaseApp.searchCaseByCrimeType(crimeType);
            if(emptyCaseSearch(caseMatches, "crime type"))
                break;
            printCases(caseMatches);
            break;

            case(2):
            System.out.println("Enter the date you would like to search by. (Enter the month number, then the date, then the year)");
            int month = scanner.nextInt();
            int day = scanner.nextInt();
            int year = scanner.nextInt();
            scanner.nextLine();
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
            System.out.println("Enter the piece of evidence you would like to search by");
            caseMatches = databaseApp.searchCaseByEvidence(scanner.nextLine());
            if(emptyCaseSearch(caseMatches, "evidence"))
                break;
            printCases(caseMatches);
            break;

            case(6):
            System.out.println("Enter the criminal you would like to search. (Enter their full name)");
            caseMatches = databaseApp.searchCaseByCriminal(scanner.nextLine());
            if(emptyCaseSearch(caseMatches, "criminal"))
                break;
            printCases(caseMatches);
            break;

            case(7):
            System.out.println("Enter the victim you would like to search. (Enter their full name)");
            caseMatches = databaseApp.searchCaseByVictim(scanner.nextLine());
            if(emptyCaseSearch(caseMatches, "victim"))
                break;
            printCases(caseMatches);
            break;

            case(8):
            System.out.println("Enter the officer you would like to search. (Enter their full name)");
            caseMatches = databaseApp.searchCaseByOfficer(scanner.nextLine());
            if(emptyCaseSearch(caseMatches, "officer"))
                break;
            printCases(caseMatches);
            break;

            case(9):
            System.out.println("Enter the witness you would like to search. (Enter their full name)");
            caseMatches = databaseApp.searchCaseByWitness(scanner.nextLine());
            if(emptyCaseSearch(caseMatches, "witness"))
                break;
            printCases(caseMatches);
            break;


        }
    }

    /**
     * Case search results
     * Checks if the case search is empty based on parameters
     * @param cases
     * @param searchType
     * @return true or false based on if a case exists
     */
    private boolean emptyCaseSearch(ArrayList<Case> cases, String searchType)
    {
        if(cases.size() == 0)
        {
            System.out.println("There are no cases with that " + searchType);
            return true;
        }
        return false;
    }

    /**
     * print function
     * loops through array list to print all cases
     * @param cases
     */
    private void printCases(ArrayList<Case> cases)
    {
        for(int i=0; i<cases.size(); i++)
            cases.get(i).print();
    }

    private void printPerson()
    {
        while(true)
        {
        for(int i=0; i<personOptions.length; i++)
            System.out.println((i+1) + ". " + personOptions[i]);
        System.out.println("Which type of person would you like to print to a text file?(Type the corresponding number then hit ENTER)");

        int userInput = scanner.nextInt() - 1;
        scanner.nextLine();
        if(userInput < 0 || userInput > personOptions.length)
        {
            System.out.println("That is not a valid input");
            continue;
        }

        switch(userInput){

            case(0):
            printCriminal();
            break;

            case(1):
            printVictim();
            break;

            case(2):
            printOfficer();
            break;

            case(3):
            printWitness();
            break;
        }
        break;
    }
   }
    private void printCase()
    {
        System.out.println("Enter the case number of the case you would like to print");
        int input = scanner.nextInt();
        scanner.nextLine();
        Case newCase = databaseApp.searchCaseByCaseNum(input);
        if(newCase == null)
            System.out.println("That case is not in the database");
        
            else
            {
                System.out.println("What would you like the text file to be named (omit the .txt)");
                String textInput = scanner.nextLine();
                databaseApp.generateCaseFile(newCase, textInput);
                System.out.println("The file was successfully created");
            }
    }

    private void printCriminal()
    {
        System.out.println("Enter the full name of the criminal you would like to print");
        String input = scanner.nextLine();
        Criminal newCriminal = databaseApp.searchCriminalByName(input);
                if(newCriminal == null)
                    System.out.println("That criminal is not in the database.");
                else
                {
                    System.out.println("What would you like the text file to be named (omit the .txt)");
                    String textInput = scanner.nextLine();
                    databaseApp.generateCriminalFile(newCriminal, textInput);
                    System.out.println("The file was successfully created");
                }
                   
    }

    private void printVictim()
    {
        System.out.println("Enter the full name of the victim you would like to print");
        String input = scanner.nextLine();
       Victim newVictim = databaseApp.searchVictimByName(input);
                if(newVictim == null)
                    System.out.println("That victim is not in the database.");
                else
                {
                    System.out.println("What would you like the text file to be named (omit the .txt)");
                    String textInput = scanner.nextLine();
                    databaseApp.generateVictimFile(newVictim, textInput);
                    System.out.println("The file was successfully created");
                }
                   
    }

    private void printOfficer()
    {
        System.out.println("Enter the full name of the officer you would like to print");
        String input = scanner.nextLine();
        Officer newOfficer = databaseApp.searchOfficerByName(input);
                if(newOfficer == null)
                    System.out.println("That officer is not in the database.");
                else
                {
                    System.out.println("What would you like the text file to be named (omit the .txt)");
                    String textInput = scanner.nextLine();
                    databaseApp.generateOfficerFile(newOfficer, textInput);
                    System.out.println("The file was successfully created");
                }
                   
    }

    private void printWitness()
    {
        System.out.println("Enter the full name of the witness you would like to print");
        String input = scanner.nextLine();
        Witness newWitness = databaseApp.searchWitnessByName(input);
                if(newWitness == null)
                    System.out.println("That witness is not in the database.");
                else
                {
                    System.out.println("What would you like the text file to be named (omit the .txt)");
                    String textInput = scanner.nextLine();
                    databaseApp.generateWitnessFile(newWitness, textInput);
                    System.out.println("The file was successfully created");
                }
                   
    }


}