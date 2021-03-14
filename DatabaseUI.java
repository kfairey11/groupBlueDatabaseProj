/**
 * user interface
 * @author Kennedy Fairey
 */
import java.util.Scanner;
import java.util.ArrayList;
public class DatabaseUI {

    private static final String HOME_MSG = "Welcome to the Criminal Investigation Database";
    private static final String[] homePageOptions = {"Create a Person(s) Profile", "Add to an existing Person(s) Profile", "Create a Case Profile", 
    "Add to a Case Profile", "Search a Person(s) Profile", "Search a Case Profile", "Logout"};
    private static final String[] personOptions = {"Criminal", "Victim", "Police Officer", "Witness"};
    private Scanner scanner;
    private DatabaseApp databaseApp;

    public DatabaseUI()
    {
        scanner = new Scanner(System.in);
        databaseApp = databaseApp.getInstance();
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
            displayHomePage();

            int userCommand = getUserCommand(homePageOptions.length);

            if(userCommand == -1)
            {
                System.out.println("Not a valid command");
                continue;
            }
            else if(userCommand == -2)
                break;

            if(userCommand == homePageOptions.length)
                break;
            
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

        if(userCommand >= 0 && userCommand < numOfCommands)
            return userCommand;
        else if(userCommand == numOfCommands)
            return -2;
        else    
            return -1;
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
        String[] tattoos = enterInfoLoop("Tattoos (Enter tattoo then hit ENTER, either continue to enter tattoos or enter \"exit\" to exit)", "Criminal");

        double shoeSize = Double.parseDouble(enterInfo("Shoe Size", "Criminal"));
        String[] piercings = enterInfoLoop("Piercings (Enter piercing then hit ENTER, either continue to enter piercings or enter \"exit\" to exit)", "Criminal");

        databaseApp.createCriminal(firstName, lastName, age, sex, nickname, feet, inches, weight, race, tattoos, shoeSize, piercings);
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
        String custody = enterInfo("Protective Custody status (y/n)", "Victim");
        boolean protCust = true;
        if(custody.equalsIgnoreCase("y"))
            continue;
        else if(custody.equalsIgnoreCase("n"))
            protCust = !protCust;

        databaseApp.createVictim(firstName, lastName, age, sex, report, hospital, phoneNum, address, protCust);
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

        databaseApp.createOfficer(firstName, lastName, age, sex, rank, city, phoneNum, address);
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
        databaseApp.createWitness(firstName, lastName, age, sex, testimony, phoneNum, address);
    }

    private String enterInfo(String data, String person)
    {
        System.out.println("Enter the "+ person + "'s " + data + ": ");
        return scanner.nextLine();
    }

    private String[] enterInfoLoop(String data, String person)
    {
        System.out.println("Enter the " + person + "'s " + data + ": ");
        ArrayList<String> elements = new ArrayList<String>();
        while(true)
        {
            if(scanner.next().equalsIgnoreCase("Exit")) 
                break;
            elements.add(scanner.nextLine());
        }
        String[] info = new String[elements.size()];
        for(int i=0;i<info.length;i++)
            info[i] = elements.get(i);
        return info;

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
            Person criminal = databaseApp.searchCriminalByLastName(scanner.next());
            System.out.println(criminal.firstName + " " + criminal.lastName + " is a criminal in the database");
            databaseApp.changeCriminal(criminal);
            break;

            case(1):
            makeChanges("Victim");
            Person victim = databaseApp.searchVictimByLastName(scanner.next());
            System.out.println(victim.firstName + " " + victim.lastName + " is a victim in the database");
            databaseApp.changeVictim(victim);
            break;

            case(2):
            makeChanges("Officer");
            Person officer = databaseApp.searchOfficerByLastName(scanner.next());
            System.out.println(officer.firstName + " " + officer.lastName + " is a officer in the database");
            databaseApp.changeOfficer(officer);
            break;

            case(3):
            makeChanges("Witness");
            Person witness = databaseApp.searchWitnessByLastName(scanner.next());
            System.out.println(witness.firstName + " " + witness.lastName + " is a officer in the database");
            databaseApp.changeWitness(witness);
            break;
            
            
        }
        break;
        
        
    
    }
    }
    private void makeChanges(String person)
    {
        System.out.println("Which" + person + "'s profile would you like to make changes to? Enter their last name then ENTER.");
    }

    private void createCase()
    {
        System.out.println("Enter the type of crime");
        String crimeType = scanner.nextLine();

        System.out.println("Enter the date of the crime (MM/DD/YYYY format)");
        String date = scanner.nextLine();

        System.out.println("Enter a description of the crime");
        String description = scanner.nextLine();

        System.out.println("Enter the location of the crime");
        String location = scanner.nextLine();

        databaseApp.createCase(crimeType, date, description, location);

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