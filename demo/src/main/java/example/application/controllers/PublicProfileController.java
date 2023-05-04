package example.application.controllers;

import example.data.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@Controller
public class PublicProfileController {
    /**
     * The singleton instance of the database connection. This is used to access the
     * database of users.
     */
    private final StaticUserDAO userDAO = new StaticUserDAO();
    private User logged;
    private User user;

    private boolean firstTime = true;

    public void firstTimeFunc(){
        if (firstTime){
            User u = new User("Jayden", "Hobbs", "password", "jayden@gmail", new double []{-27.4785, 153.0284});
            userDAO.addUser(u);
            u = new User("Bob", "Dylan", "123", "bob@dylan.com", new double []{-27.4785, 153.0284});
            UserStats stats = u.getStatistics();
            stats.setPoints(369);
            stats.setJoinDate(LocalDate.of(2022, 3, 7));
            stats.addReview(new Review(5, "bestuser", "this guy is pretty good"));
            stats.addReview(new Review(1, "baduser", "this guy is pretty bad"));
            u.setStatistics(stats);

            userDAO.addUser(u);
            firstTime=false;
        }
    }


    /**
     * Displays the Public Profile page.
     *
     * @param model The model that defines the attributes to be displayed.
     * @return The name of the view to display.
     */
    @GetMapping("/public-profile")
    public String showPublicProfileForm(Model model) {
        if (firstTime){
            firstTimeFunc();
        }
        logged = userDAO.getUser("jayden@gmail");

        user = userDAO.getUser("jayden@gmail");

        System.out.println(logged.getFirstName());
        System.out.println(logged.getLastName());

        model.addAttribute("logged", logged);
        model.addAttribute("user", user);
        return "public-profile";
    }

    @GetMapping("/public-profile/{user_email}")
    public String showUserProfileForm(Model model, @PathVariable("user_email") String user_email) {
        if (firstTime){
            firstTimeFunc();
        }

        logged = userDAO.getUser(user_email);
        user = userDAO.getUser(user_email);

        System.out.println(user_email);
        System.out.println("SUCCESS");

        model.addAttribute("logged", logged);
        model.addAttribute("user", user);
        model.addAttribute("ranks", Ranks.values());
        return "public-profile";

    }






}
