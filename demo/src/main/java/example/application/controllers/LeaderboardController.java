package example.application.controllers;

import example.application.exception.RecordNotFoundException;
import example.application.model.UserEntity;
import example.application.service.ReviewService;
import example.application.service.UserService;
import example.data.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserService uservice;

    private LeaderboardLogic logic = new LeaderboardLogic();

//    /**
//     * Displays the leaderboard page.
//     *
//     * @param model The model that defines the attributes to be displayed.
//     * @return The name of the view to display.
//     */
//    @GetMapping("/leaderboard")
//    public String showLeaderboardForm(Model model) {
//
//        logic.loadDummyDatabase();
//        logged = userDAO.getUser("jayden@gmail");
//
//
//        String loggedPos = "unranked";
//
//        List<User> list2 = logic.sortPoints("SaverPoints");
//        int i = 1;
//
//        for (User u : list2){
//            if (u.getEmail() == logged.getEmail()) {
//                loggedPos = Integer.toString(i);
//                break;
//            }
//            i++;
//        }
//
//        model.addAttribute("counter", new Counter());
//        model.addAttribute("loggedPos", loggedPos);
//        model.addAttribute("allUsers", userDAO.listUsers());
//        model.addAttribute("users2", logic.sortPoints("SaverPoints"));
//        model.addAttribute("sortType", "Saver Points");
//        model.addAttribute("logged", logged);
//
//        return "leaderboard-page";
//    }

    @GetMapping("/leaderboard/{sort}")
    public String showLeaderboardForm(Model model, @PathVariable("sort") String sort) {
        UserEntity logged = new UserEntity();
        List<UserEntity> allUsers = uservice.getAllUser();

        try {
            logged = uservice.getUserById(1L);

        } catch (RecordNotFoundException x) {
            System.out.println(x.getMessage());
        }

        String sortType = "unknown";

        if (sort.equals("SaverPoints")) {
            sortType = "Saver Points";
        } else if (sort.equals("Reviews")) {
            sortType = "Reviews";
        }
        List<UserEntity> list2 = logic.sortPoints(allUsers, sort);

        String loggedPos = "unranked";

        int i = 1;

        for (UserEntity u : list2){
            if (u.getEmail() == logged.getEmail()) {
                loggedPos = Integer.toString(i);
                break;
            }
            i++;
        }
        model.addAttribute("counter", new Counter());
        model.addAttribute("loggedPos", loggedPos);
        model.addAttribute("users2", list2);
        model.addAttribute("allUsers", allUsers);
        model.addAttribute("sortType", sortType);
        model.addAttribute("logged", logged);


        return "leaderboard-page";
    }
}