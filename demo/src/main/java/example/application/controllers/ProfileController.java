package example.application.controllers;


import example.data.StaticUserDAO;
import example.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller for the profile page.
 */
@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String showProfileForm(Model model) {
        return "profile-page";
    }
}
