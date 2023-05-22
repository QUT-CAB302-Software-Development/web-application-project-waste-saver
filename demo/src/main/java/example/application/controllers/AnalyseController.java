package example.application.controllers;

import example.application.model.UserEntity;
import example.data.AnalyseCalc;
//import example.data.ProfileLogic;
import example.data.StaticUserDAO;
import example.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

@Controller
public class AnalyseController {
    /**
     * The singleton instance of the database connection. This is used to access the
     * database of users.
     */
    private final StaticUserDAO userDAO = new StaticUserDAO();


    private final AnalyseCalc calculate = new AnalyseCalc();

    private int userPoints = 0;

    private User logged;


    public AnalyseController() {

    }


    @GetMapping({"/analyse"})
    public String analyse(Model model) {
        return "Analyse";
    }


    /**
     * Saves user's points
     *
     * @param model The model to add attributes to.
     * @return The name of the view to display.
     */

    @RequestMapping(value = "/analyse", method = RequestMethod.POST, params = "save")
    public String savePoints(@ModelAttribute User user, Model model) {


        // Needs to get the user's firstName and lastName and overrides user's points and to save them into the database.
        // Return to the analyse page

        /*calculate.saveUserPoints(logged, user.getFirstName(), user.getLastName(), userPoints);
        model.addAttribute("user", userPoints);
        model.addAttribute("logged", userPoints);*/

        return "analyse-page";


    }}

