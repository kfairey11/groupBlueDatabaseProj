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
            Person criminal = databaseApp.searchCriminalByName(scanner.next());
            System.out.println(criminal.firstName + " " + criminal.lastName + " is a criminal in the database");
            databaseApp.changeCriminal(criminal);
            break;

            case(1):
            makeChanges("Victim");
            Person victim = databaseApp.searchVictimByName(scanner.next());
            System.out.println(victim.firstName + " " + victim.lastName + " is a victim in the database");
            databaseApp.changeVictim(victim);
            break;

            case(2):
            makeChanges("Officer");
            Person officer = databaseApp.searchOfficerByName(scanner.next());
            System.out.println(officer.firstName + " " + officer.lastName + " is a officer in the database");
            databaseApp.changeOfficer(officer);
            break;

            case(3):
            makeChanges("Witness");
            Person witness = databaseApp.searchWitnessByName(scanner.next());
            System.out.println(witness.firstName + " " + witness.lastName + " is a officer in the database");
            databaseApp.changeWitness(witness);
            break;
            
            
        }
        break;
        
        
    
    }
    }
    private void makeChanges(String person)
    {
        System.out.println("Which" + person + "'s profile would you like to make changes to? Enter their full name then ENTER.");
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


        databaseApp.createCase(crimeType, date, description, location, criminals, victims, officers, witnesses);

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