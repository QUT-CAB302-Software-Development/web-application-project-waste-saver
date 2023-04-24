package example.application;


import example.data.ProfileLogic;
import example.data.StaticUserDAO;
import example.data.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UserStatsTests {

    private User loggedIn = new User("Jayden", "Hobbs", "Pass1", "jayden@qut", new double[]{});
    private final StaticUserDAO userDAO = new StaticUserDAO();


    @Test
    public void testConstructor(){
        assertEquals(loggedIn.getStatistics().getPoints(), 0);
        assertEquals(loggedIn.getStatistics().getDonationsTotal(), 0);

    }

    @Test
    public void testProcessPersonalDetails(){

    }

    @Test
    public void testProcessPreferences(){

    }

    @Test
    public void testDeleteAccount(){

    }

    @Test
    public void testResetPreferences(){


    }

}
