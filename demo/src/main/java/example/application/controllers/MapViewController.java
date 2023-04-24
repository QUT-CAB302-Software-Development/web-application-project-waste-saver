package example.application.controllers;

import example.data.StaticUserDAO;
import example.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.ArrayList;

import java.io.Console;

/**
 * Controller for the main page, displayed after the user has logged in.
 */
@Controller
public class MapViewController {
    /**
     * The singleton instance of the database connection. This is used to access the
     * database of users.
     */
    private final StaticUserDAO userDAO = new StaticUserDAO();

    /**
     * Displays the map page.
     *
     * @param model The model that defines the attributes to be displayed.
     * @return The name of the view to display.
     */
    @GetMapping("/viewmap")
    public String viewmap(Model model) {
        /*
         *  Creates a list of example Users with coordinates, in the real implementation, should fetch from the database.
         */
        List<User> dummyUsers = new ArrayList<>();
        dummyUsers.add(new User("Adam", "Le", "123", "adam@gmail.com", new double []{-27.4785, 153.0284}));
        dummyUsers.add(new User("Jayden", "Hobbs", "321", "jayden@gmail.com", new double []{-27.4783, 153.0290}));
        dummyUsers.add(new User("Jason", "Siu", "213", "jason@gmail.com", new double []{-27.4788, 153.0279}));

        // add attributes to the model
        model.addAttribute("mapusers", dummyUsers);
        model.addAttribute("chosenuser", dummyUsers.get(0));
        model.addAttribute("users", userDAO.listUsers());
        model.addAttribute("mapScript", "<script>\n" +
                "const map = L.map('map').setView([-27.4785, 153.0284], 13);\n" +
                "L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {\n" +
                "maxZoom: 19,\n" +
                "attribution: '&copy; <a href=\"http://www.openstreetmap.org\">OpenStreetMap</a>'\n" +
                "}).addTo(map);\n");

        // Add a marker for each user to the map
        for (User user : dummyUsers) {
            double[] coordinates = user.getCoordinates();
            model.addAttribute("mapScript", String.format("%sL.marker([%f, %f]).addTo(map);\n",
                    model.getAttribute("mapScript"), coordinates[0], coordinates[1]));
        }

        return "map-view"; //return the name of the view to display
    }

    /**
     * Logs the user out.
     *
     * @return The name of the view to display.
     */
    @PostMapping("/login")
    public String goback() {
        return "redirect:/login";
    }

}
