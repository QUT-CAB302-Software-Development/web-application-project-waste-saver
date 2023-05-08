package example.application.controllers;

import example.data.StaticUserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the main page, displayed after the user has logged in.
 */
@Controller
public class ListViewController {
    @GetMapping("/viewlist")
    public String viewlist(Model model) {
        return "ItemList"; //return the name of the view to display
    }
}
