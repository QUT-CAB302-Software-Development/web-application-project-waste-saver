package example.application.controllers;

import example.application.model.UserEntity;
import example.application.service.UserService;
import example.data.StaticUserDAO;
import example.data.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import example.application.model.UserEntity;
import example.application.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.application.exception.RecordNotFoundException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.ArrayList;

import java.io.Console;

/*
 * This controller is to act as any page that passses the currently logged-in user as an attribute, the map can't be accessed
 * unless a 'currentuser' attribute is passed to it like this page does when redirecting with the 'goviewmap' function which
 * is called in a button in the corresponding html page.
 */



@Controller
public class TestLoggedInController {
    @Autowired
    private UserService userService;

    @GetMapping("/viewtest")
    public String viewtest(Model model) {


        return "viewtest"; //return the name of the view to display
    }

    @PostMapping("/goviewmap")
    public String goviewmap( RedirectAttributes redirectAttrs) {
        UserEntity testLoggedInUser = userService.getAllUser().get(0);
        System.out.println(testLoggedInUser);
        redirectAttrs.addFlashAttribute("currentuser", testLoggedInUser);
        return "redirect:/viewmap";
    }

}
