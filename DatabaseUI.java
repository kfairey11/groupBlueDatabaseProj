/**
 * user interface
 * @author Kennedy Fairey
 */
import java.util.Scanner;
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

            if(userCommand == homePageOptions.length)
                break;
            
            switch(userCommand){

                case(0):
                createPerson();
                break;

                case(1):
                changePerson();
                break;

            }

        }
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
            database.addToPeople(criminal);
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


    private Person createCriminal()
    {
        Person criminal = new Criminal();

        enterInfo("First Name", "Criminal");
        criminal.firstName = scanner.next();
        nextLine();

        enterInfo("Last Name", "Criminal");
        criminal.lastName = scanner.next();
        nextLine();

        enterInfo("Age", "Criminal");
        criminal.age = scanner.nextInt();
        nextLine();

        enterInfo("Sex", "Criminal");
        criminal.sex = scanner.nextLine();
        nextLine();

        enterInfo("Nickname", "Criminal");
        criminal.nickname = scanner.nextLine();
        nextLine();

        enterInfo("Height (Enter feet, hit ENTER, then enter inches)", "Criminal");
        criminal.height.feet = scanner.nextInt();
        criminal.height.inches = scanner.nextInt();
        nextLine();

        enterInfo("Weight", "Criminal");
        criminal.weight = scanner.nextDouble();
        nextLine();

        enterInfo("Race", "Criminal");
        criminal.race = scanner.next();
        nextLine();

        enterInfo("Tattoos (Enter tattoo then hit ENTER, either continue to enter tattoos or enter \"exit\" to exit)", "Criminal");
        while(true)
        {
            if(scanner.next().equalsIgnoreCase("Exit")) 
                break;
            criminal.tattoos.add(scanner.nextLine());
        }
        nextLine();

        enterInfo("Shoe Size", "Criminal");
        criminal.shoeSize = scanner.nextDouble();
        nextLine();

        enterInfo("Piercings (Enter piercing then hit ENTER, either continue to enter piercings or enter \"exit\" to exit)", "Criminal");
        while(true)
        {
            if(scanner.next().equalsIgnoreCase("Exit")) 
                break;
            criminal.piercings.add(scanner.nextLine());
        }
        nextLine();


        return criminal;
    }

    private Person createVictim()
    {
        Person victim = new Victim();

        enterInfo("First Name", "Victim");
        victim.firstName = scanner.next();
        nextLine();

        enterInfo("Last Name", "Victim");
        victim.lastName = scanner.next();
        nextLine();

        enterInfo("Age", "Victim");
        victim.age = scanner.nextInt();
        nextLine();

        enterInfo("Sex", "Victim");
        victim.sex = scanner.nextLine();
        nextLine();

        enterInfo("report", "Victim");
        victim.report = scanner.nextLine();
        nextLine();

        enterInfo("Case No.", "Victim");
        victim.caseNum = scanner.nextLine();
        nextLine();

        enterInfo("Hospital", "Victim");
        victim.hospital = scanner.nextLine();
        nextLine();

        enterInfo("Phone Number", "Victim");
        victim.phoneNum = scanner.nextLine();
        nextLine();

        enterInfo("Address", "Victim");
        victim.address = scanner.nextLine();
        nextLine();

        boolean custody = true;
        enterInfo("Protective Custody status (y/n)", "Victim");
        if(scanner.next().equalsIgnoreCase("y"))
            victim.protCustody = custody;
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
        Person officer = new policeOfficer();

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

    private void enterInfo(String data, String person)
    {
        System.out.println("Enter the "+ person + "'s " + data + ": ");
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

        int userInput = scanner.nextInt() - 1;
        if(userInput < 0 || userInput > personOptions.length)
        {
            System.out.println("That is not a valid input");
        }
        System.out.println("Which person(s) profile would you like to make changes to? Enter first name, then ENTER, then enter last name");
        
        
        String[] searchName = new String[2];
        searchName[0] = scanner.nextLine();
        searchName[1] = scanner.nextLine();
    }
    }
}