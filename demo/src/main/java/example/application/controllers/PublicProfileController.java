package example.application.controllers;

import example.application.exception.RecordNotFoundException;
import example.application.model.ReviewEntity;
import example.application.model.UserEntity;
import example.application.service.ReviewService;
import example.application.service.UserService;
import example.data.*;
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
        List<ReviewEntity> entities = rservice.getAllReviewTo(user.getId());
        Review dummy = new Review(0, 0, 0, "0");
        List<Review> reviews = dummy.convertToUsable(entities);

        for(Review r : reviews){
            try{
                r.setAuthorUsername(uservice.getUserById(Integer.toUnsignedLong(r.getAuthorID())).getUsername());
            } catch (RecordNotFoundException x){
                System.out.println(x.getMessage());
            }
        }


        model.addAttribute("reviews", reviews);
        model.addAttribute("ranks", Ranks.values());
        model.addAttribute("tillNext", UserStats.pointsTillNextRank(points));
        model.addAttribute("userTitle", UserStats.achievedTitle(points));
        return "public-profile";

    }






}
