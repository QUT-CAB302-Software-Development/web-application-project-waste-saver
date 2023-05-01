package example.application.controllers;

import example.data.StaticUserDAO;
import example.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicProfileController {
    /**
     * The singleton instance of the database connection. This is used to access the
     * database of users.
     */
    private final StaticUserDAO userDAO = new StaticUserDAO();
    private User logged;
    private User user;

    private boolean firstTime = false;

    /**
     * Displays the Public Profile page.
     *
     * @param model The model that defines the attributes to be displayed.
     * @return The name of the view to display.
     */
    @GetMapping("/public-profile")
    public String showPublicProfileForm(Model model) {

        if (firstTime){
            User u = new User("Jayden", "Hobbs", "password", "jayden@gmail", new double []{-27.4785, 153.0284});
            userDAO.addUser(u);
            firstTime=false;
        }
        logged = userDAO.getUser("jayden@gmail");

        user = userDAO.getUser("jayden@gmail");

        System.out.println(logged.getFirstName());
        System.out.println(logged.getLastName());

        model.addAttribute("logged", logged);
        model.addAttribute("user", user);
        return "public-profile";
    }






}
