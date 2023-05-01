package example.application;


import example.data.StaticUserDAO;
import example.data.User;
import example.data.PreferencesLogic;
import example.data.UserPref;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProfileTests {

    private User loggedIn = new User("Jayden", "Hobbs", "Pass1", "jayden@qut", new double[]{});
    private PreferencesLogic logic = new PreferencesLogic();
    private final StaticUserDAO userDAO = new StaticUserDAO();



    @BeforeEach @Test
    public void prelimInit(){
        loggedIn.setFirstName("Jayden");
        loggedIn.setLastName("Hobbs");
        assertEquals(loggedIn.getFirstName(), "Jayden");
        assertEquals(loggedIn.getEmail(), "jayden@qut");
    }

    @Test
    public void testProcessPersonalDetails(){
        loggedIn.setFirstName("Jayden");

        logic.processPersonalDetails(loggedIn, null, null, "Pass2");

        assertEquals(userDAO.getUser(loggedIn.getEmail()).getFirstName(), "Jayden");
        assertEquals(userDAO.getUser(loggedIn.getEmail()).getPassword(), "Pass2");

    }

    @Test
    public void testProcessPreferences(){
        UserPref newPrefs = new UserPref();
        newPrefs.setDonationRange(4);
        newPrefs.setExpiryNotifications(false);
        newPrefs.setDonationNotifications(true);
        logic.processPreferences(loggedIn, newPrefs);

        assertEquals(userDAO.getUser(loggedIn.getEmail()).getPreferences().isDonationNotifications(), true);
        assertEquals(userDAO.getUser(loggedIn.getEmail()).getPreferences().getDonationRadius(), 4);
        assertEquals(userDAO.getUser(loggedIn.getEmail()).getPreferences().isExpiryNotifications(), false);


    }

    @Test
    public void testDeleteAccount(){
        logic.deleteUserAccount(loggedIn);

        assertEquals(userDAO.getUser(loggedIn.getEmail()), null);
    }

    @Test
    public void testResetPreferences(){
        loggedIn.setFirstName("Jayden");

        logic.resetPreferences(loggedIn);

        assertEquals(userDAO.getUser(loggedIn.getEmail()).getPreferences().isDonationNotifications(), true);
        assertEquals(userDAO.getUser(loggedIn.getEmail()).getPreferences().getDonationRadius(), 5);
        assertEquals(userDAO.getUser(loggedIn.getEmail()).getFirstName(), "Jayden");

    }

}
