package example.application.controllers;

import example.data.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for the leaderboard page.
 */
@Controller
public class LeaderboardController {
    /**
     * The singleton instance of the database connection. This is used to access the
     * database of users.
     */
    private final StaticUserDAO userDAO = new StaticUserDAO();

    private User logged;
    private User user;

    private LeaderboardLogic logic = new LeaderboardLogic();

    /**
     * Displays the leaderboard page.
     *
     * @param model The model that defines the attributes to be displayed.
     * @return The name of the view to display.
     */
    @GetMapping("/leaderboard")
    public String showLeaderboardForm(Model model) {

        logic.loadDummyDatabase();

        model.addAttribute("allUsers", userDAO.listUsers());
        model.addAttribute("users2", logic.sortPoints());
        model.addAttribute("sortType", "Saver Points");

        return "leaderboard-page";
    }

    @GetMapping("/leaderboard/{sort}")
    public String showLeaderboardForm(Model model, @PathVariable("sort") String sort) {
        String sortType = "unknown";

        System.out.println(sort);
        List<User> list2 = new ArrayList<>();

        if (sort == "SaverPoints"){
            sortType = "Saver Points (from URL)";
            list2 = logic.sortPoints();
        }

        model.addAttribute("users2", list2);
        model.addAttribute("allUsers", userDAO.listUsers());
        model.addAttribute("sortType", sortType);


        return "leaderboard-page";
    }
}