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

    /**
     * Displays the Public Profile page.
     *
     * @param model The model that defines the attributes to be displayed.
     * @return The name of the view to display.
     */
    @GetMapping("/public-profile")
    public String showPublicProfileForm(Model model) {

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
