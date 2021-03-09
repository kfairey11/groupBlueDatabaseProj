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
        int tattooCount = 0;
        


    }

    private void enterInfo(String data, String person)
    {
        System.out.println("Enter the "+ person + "'s " + data + ": ");
    }

    private void nextLine()
    {
        System.out.println("");
    }
}