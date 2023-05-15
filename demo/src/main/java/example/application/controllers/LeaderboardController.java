package example.application.controllers;

import example.data.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        logged = userDAO.getUser("jayden@gmail");


        String loggedPos = "unranked";

        List<User> list2 = logic.sortPoints("SaverPoints");
        int i = 1;

        for (User u : list2){
            if (u.getEmail() == logged.getEmail()) {
                loggedPos = Integer.toString(i);
                break;
            }
            i++;
        }

        model.addAttribute("counter", new Counter());
        model.addAttribute("loggedPos", loggedPos);
        model.addAttribute("allUsers", userDAO.listUsers());
        model.addAttribute("users2", logic.sortPoints("SaverPoints"));
        model.addAttribute("sortType", "Saver Points");
        model.addAttribute("logged", logged);

        return "leaderboard-page";
    }

    @GetMapping("/leaderboard/{sort}")
    public String showLeaderboardForm(Model model, @PathVariable("sort") String sort) {
        logic.loadDummyDatabase();
        logged = userDAO.getUser("jayden@gmail");
        String sortType = "unknown";

        if (sort.equals("SaverPoints")) {
            sortType = "Saver Points";
        } else if (sort.equals("Reviews")) {
            sortType = "Reviews";
        }
        List<User> list2 = logic.sortPoints(sort);

        String loggedPos = "unranked";

        int i = 1;

        for (User u : list2){
            if (u.getEmail() == logged.getEmail()) {
                loggedPos = Integer.toString(i);
                break;
            }
            i++;
        }
        model.addAttribute("counter", new Counter());
        model.addAttribute("loggedPos", loggedPos);
        model.addAttribute("users2", list2);
        model.addAttribute("allUsers", userDAO.listUsers());
        model.addAttribute("sortType", sortType);
        model.addAttribute("logged", userDAO.getUser("jayden@gmail"));


        return "leaderboard-page";
    }
}