import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsersTest {

    private Users users = Users.getInstance();
    private ArrayList<User> userList = users.getUsers();
    
    @BeforeEach
    public void setup() {

        userList.clear();
        userList.add(new User(new UUID(5, 2), "john", "smith", "jsmith", "password1234"));
        userList.add(new User(new UUID(5, 2), "mary", "samson", "msamson", "password2222"));
        DataWriter.saveUsers();

    }

    @AfterEach
    public void tearDown() {

        Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();

    }

    @Test
    void testHaveUserValidFirstItem() {

        boolean hasJohn = users.haveUser("jsmith");
        assertTrue(hasJohn);

    }

    @Test
    void testHaveUserValidSecondItem() {

        boolean hasMary = users.haveUser("msamson");
        assertTrue(hasMary);

    }

    @Test
    void testHaveUserInValid() {

        boolean hasSam = users.haveUser("sjohnson");
        assertFalse(hasSam);

    }

    @Test
    void testHaveUserEmpty() {

        boolean hasEmpty = users.haveUser("");
        assertFalse(hasEmpty);

    }

    @Test
    void testHaveUserNull() {

        boolean hasNull = users.haveUser(null);
        assertFalse(hasNull);

    }

}
