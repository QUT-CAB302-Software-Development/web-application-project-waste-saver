package example.application.controllers;

import example.application.exception.RecordNotFoundException;
import example.application.model.ReviewEntity;
import example.application.model.UserEntity;
import example.application.service.ReviewService;
import example.application.service.UserService;
import example.data.Ranks;
import example.data.User;
import example.data.UserStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PublicProfileController {

    @Autowired
    UserService uservice;

    @Autowired
    ReviewService rservice;
    private User user;

//    /**
//     * Displays the Public Profile page.
//     *
//     * @param model The model that defines the attributes to be displayed.
//     * @return The name of the view to display.
//     */
//    @GetMapping("/public-profile")
//    public String showPublicProfileForm(Model model) {
//
//
//        model.addAttribute("user", user);
//        return "public-profile";
//    }

    @GetMapping("/public-profile/{username}")
    public String showUserProfileForm(Model model, @PathVariable("username") String username) {
        UserEntity user = new UserEntity();

        try{
            user = uservice.getUserByUsername(username);
            model.addAttribute("user", user);
        }
        catch (RecordNotFoundException x){
            System.err.println(x.getMessage());
        }

        int points = user.getSaverPoints();
        List<ReviewEntity> reviews = rservice.getAllReviewTo(user.getId());

        model.addAttribute("reviews", reviews);
        model.addAttribute("ranks", Ranks.values());
        model.addAttribute("tillNext", UserStats.pointsTillNextRank(points));
        model.addAttribute("userTitle", UserStats.achievedTitle(points));
        return "public-profile";

    }






}
