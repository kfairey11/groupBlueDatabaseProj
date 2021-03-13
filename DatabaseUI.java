/**
 * user interface
 * @author Kennedy Fairey
 */
import java.util.Scanner;
import java.util.ArrayList;
public class DatabaseUI {

    private static final String HOME_MSG = "Welcome to the Criminal Investigation Database";
    private String[] homePageOptions = {"Create a Person(s) Profile", "Add to an existing Person(s) Profile", "Create a Case Profile", 
    "Add to a Case Profile", "Search a Person(s) Profile", "Search a Case Profile", "Logout"};
    private String[] personOptions = {"Criminal", "Victim", "Police Officer", "Witness"};
    private Scanner scanner;
    private Database database;

    public DatabaseUI()
    {
        scanner = new Scanner(System.in);
        database = new Database();
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
                database.searchPerson();
                break;

                case(5):
                //create this method in database
                database.searchCase();
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
            Person criminal = createCriminal(criminal);
            break;

            case(1):
            Person victim = createVictim(victim);
            database.addToPeople(victim);
            break;

            case(2):
            Person policeOfficer = createOfficer(policeOfficer);
            database.addToPeople(policeOfficer);
            break;

            case(3):
            Person witness = createWitness(witness);
            database.addToPeople(witness); 
            break;


        }
        }


    }


    private Person createCriminal(Person criminal)
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

        double weight = Double.parseDouble(("Weight", "Criminal"));
        String race = enterInfo("Race", "Criminal");
        String[] tattoos = enterInfoLoop("Tattoos (Enter tattoo then hit ENTER, either continue to enter tattoos or enter \"exit\" to exit)", "Criminal");

        double shoeSize = Double.parseDouble(enterInfo("Shoe Size", "Criminal"));
        String[] piercings = enterInfoLoop("Piercings (Enter piercing then hit ENTER, either continue to enter piercings or enter \"exit\" to exit)", "Criminal");

        database.createCriminal(firstName, lastName, age, sex, nickname, feet, inches, weight, race, tattoos, shoeSize, piercings);
    }

    private Person createVictim(Person victim)
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
        boolean cust
        if(custody.equalsIgnoreCase("y"))
        if(scanner.next().equalsIgnoreCase("y"))
            victim.protectCustody = custody;
        else if(scanner.next().equalsIgnoreCase("n"))
        {
            custody = !custody;
            victim.protCustody = custody;
        }
        nextLine();

        return victim;
    }

    private void createOfficer()
    {
        Person officer = new Officer();

        enterInfo("First Name", "Officer");
        officer.firstName = scanner.next();
        nextLine();

        enterInfo("Last Name", "Officer");
        officer.lastName = scanner.next();
        nextLine();

        enterInfo("Age", "Officer");
        officer.age = scanner.nextInt();
        nextLine();

        enterInfo("Sex", "Officer");
        officer.sex = scanner.nextLine();
        nextLine();

        enterInfo("Rank (Officer, Detective, Corporal, Lieutenant, Sergeant, Captian)", "Officer");
        officer.rank = scanner.next();
        nextLine();

        enterInfo("Case No.", "Officer");
        officer.caseNum = scanner.nextInt();
        nextLine();

        enterInfo("City", "Officer");
        officer.city = scanner.nextLine();
        nextLine();

        enterInfo("Phone number", "Officer");
        officer.phoneNum = scanner.nextLine();
        nextLine();

        enterInfo("Address", "Officer");
        officer.address = scanner.nextLine();
        nextLine();

        return officer;
    }

    private Person createWitness()
    {
        Person witness = new Witness();

        enterInfo("First Name", "Witness");
        witness.firstName = scanner.next();
        nextLine();

        enterInfo("Last Name", "Witness");
        witness.lastName = scanner.next();
        nextLine();

        enterInfo("Age", "Witness");
        witness.age = scanner.nextInt();
        nextLine();

        enterInfo("Sex", "Witness");
        witness.sex = scanner.nextLine();
        nextLine();

        enterInfo("Testimony", "Witness");
        witness.testimony = scanner.nextLine();
        nextLine();

        enterInfo("Phone number", "Witness");
        witness.phoneNum = scanner.nextLine();
        nextLine();

        enterInfo("Address", "Witness");
        witness.address = scanner.nextLine();
        nextLine();

        enterInfo("Case No.", "Wintess");
        witness.caseNum = scanner.nextInt();
        nextLine();

        return witness;
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

    private void nextLine()
    {
        System.out.println("");
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
            Person criminal = database.searchCriminalByLastName(scanner.next());
            System.out.println(criminal.firstName + " " + criminal.lastName + " is a criminal in the database");
            database.changeCriminal(criminal);
            break;

            case(1):
            makeChanges("Victim");
            Person victim = database.searchVictimByLastName(scanner.next());
            System.out.println(victim.firstName + " " + victim.lastName + " is a victim in the database");
            database.changeVictim(victim);
            break;

            case(2):
            makeChanges("Officer");
            Person officer = database.searchOfficerByLastName(scanner.next());
            System.out.println(officer.firstName + " " + officer.lastName + " is a officer in the database");
            database.changeOfficer(officer);
            break;

            case(3):
            makeChanges("Witness");
            Person witness = database.searchWitnessByLastName(scanner.next());
            System.out.println(witness.firstName + " " + witness.lastName + " is a officer in the database");
            database.changeWitness(witness);
            break;
            
            
        }
        break;
        
        
    
    }
    }
    private void makeChanges(String person)
    {
        System.out.println("Which" + person + "'s profile would you like to make changes to? Enter their last name then ENTER.");
    }

    private Case createCase()
    {
        Case newCase = new Case();

        System.out.println("Enter the type of crime");
        newCase.crimeType = scanner.nextLine();
        nextLine();

        System.out.println("Enter the date of the crime (MM/DD/YYYY format)");
        newCase.date = scanner.next();
        nextLine();

        System.out.println("Enter a description of the crime");
        newCase.description = scanner.nextLine();
        nextLine();

        System.out.println("Enter the location of the crime");
        newCase.location = scanner.nextLine();
        nextLine();

        database.addToCase(newCase);

        return newCase;

    }


    private void changeCase()
    {
        System.out.println("Enter the case number you would like to change");
        //need to make searchByCaseNum method in database class
        Case caseToChange = database.searchCaseByCaseNum(scanner.nextInt());
        //need to make changeCase in database class, needs to print options as well
        database.changeCase(caseToChange);

    }
}