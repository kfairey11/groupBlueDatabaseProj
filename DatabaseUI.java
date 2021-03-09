/**
 * user interface
 * @author Kennedy Fairey
 */
import java.util.Scanner;
public class DatabaseUI {

    private static final String HOME_MSG = "Welcome to the Criminal Investigation Database";
    private String[] mainMenuOptions = {"Create a Person(s) Profile", "Add to an existing Person(s) Profile", "Create a Case Profile", 
    "Add to a Case Profile", "Search a Person(s) Profile", "Search a Case Profile", "Logout"};
    private Scanner scanner;
    private Database database;
}