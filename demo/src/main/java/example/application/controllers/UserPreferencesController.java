package example.application.controllers;

import example.application.exception.RecordNotFoundException;
import example.application.model.UserEntity;
import example.application.service.UserService;
import example.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for the user preferences page.
 */
@Controller
public class UserPreferencesController {

    /**
     * An instance of the preferences logic class. This is used to access the
     * logic of the preferences screen.
     */
    private final PreferencesLogic logic = new PreferencesLogic();

    private UserEntity logged;
    private UserEntity user;

    private long loggedID = 1;
    @Autowired
    UserService service;


    /**
     * Displays the preferences page.
     *
     * @param model The model that defines the attributes to be displayed.
     * @return The name of the view to display.
     */
    @GetMapping("/preferences")
    public String showPreferencesForm(Model model) {

        logged = new UserEntity();
        user = new UserEntity();

        try {
            logged = service.getUserById(loggedID);
            user = service.getUserById(loggedID);
        } catch (RecordNotFoundException x) {
            System.out.println(x.getMessage());
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
    public String saveSubmit(@ModelAttribute UserEntity user, Model model) {

        processPersonalDetails(logged, user.getFirstName(), user.getLastName(), user.getEmail(), user.getUsername());
//        logic.processPreferences(logged, user.getPreferences());


        try {
            logged = service.getUserById(loggedID);
        } catch (RecordNotFoundException x) {
            System.out.println(x.getMessage());
        }

        model.addAttribute("logged", logged);
        model.addAttribute("user", logged);
        return "user-preferences-page";
    }

    public void processPersonalDetails(UserEntity user, String fname, String lname, String email, String username) {

        if (fname != null && !fname.isEmpty()){
            user.setFirstName(fname);
        }

        if (lname != null && !lname.isEmpty()) {
            user.setLastName(lname);
        }

        if (email != null && !email.isEmpty()) {
            user.setEmail(email);
        }

        if (username != null && !username.isEmpty()) {
            user.setUsername(username);
        }

        service.createOrUpdateUser(user);

    }
}
