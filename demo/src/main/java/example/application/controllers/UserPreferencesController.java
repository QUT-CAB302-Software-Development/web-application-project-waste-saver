package example.application.controllers;

import example.data.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for the user preferences page.
 */
@Controller
public class UserPreferencesController {
    /**
     * The singleton instance of the database connection. This is used to access the
     * database of users.
     */
    private final StaticUserDAO userDAO = new StaticUserDAO();

    /**
     * An instance of the preferences logic class. This is used to access the
     * logic of the preferences screen.
     */
    private final PreferencesLogic logic = new PreferencesLogic();
    private User logged;
    private User user;

    /**
     * Displays the preferences page.
     *
     * @param model The model that defines the attributes to be displayed.
     * @return The name of the view to display.
     */
    @GetMapping("/preferences")
    public String showPreferencesForm(Model model) {

        logged = userDAO.getUser("jayden@gmail");
        user = userDAO.getUser("jayden@gmail");

        for (User u1 : userDAO.listUsers())
        {
            System.out.println(u1.getEmail());
        }
        model.addAttribute("logged", logged);
        model.addAttribute("user", user);
        return "user-preferences-page";
    }

    /**
     * Saves the user's edited preferences
     *
     * @param model The model to add attributes to.
     * @return The name of the view to display.
     */
    @RequestMapping(value = "/preferences", method = RequestMethod.POST, params = "save")
    public String saveSubmit(@ModelAttribute User user, Model model) {

        logic.processPersonalDetails(logged, user.getFirstName(), user.getLastName(), null);
        logic.processPreferences(logged, user.getPreferences());

        model.addAttribute("logged", userDAO.getUser(logged.getEmail()));
        model.addAttribute("user", userDAO.getUser(logged.getEmail()));
        return "user-preferences-page";
    }
}
