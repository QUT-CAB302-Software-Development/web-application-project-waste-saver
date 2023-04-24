package example.application.controllers;

import example.data.StaticUserDAO;
import example.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    public class FoodItem {
        public String name;
        public int expirationDate;

        public FoodItem(String name, int expirationDate) {
            this.name = name;
            this.expirationDate = expirationDate;
        }

    }
    private final StaticUserDAO userDAO = new StaticUserDAO();
    public String dummyRadius = "80";

    public String getUserRadius(User currentUser) {
        return dummyRadius;
    }

    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double radiusOfEarth = 6371; // Radius of Earth in kilometers

        double sinLat1 = Math.sin(Math.toRadians(lat1));
        double sinLat2 = Math.sin(Math.toRadians(lat2));
        double cosLat1 = Math.cos(Math.toRadians(lat1));
        double cosLat2 = Math.cos(Math.toRadians(lat2));
        double cosLonDiff = Math.cos(Math.toRadians(lon2 - lon1));

        return Math.acos(sinLat1 * sinLat2 + cosLat1 * cosLat2 * cosLonDiff) * radiusOfEarth * 1000;
    }

    public Boolean withinDistance(double [] chosenUserCoords, double [] comparedUserCoords){
        return calculateDistance(chosenUserCoords[0], chosenUserCoords[1], comparedUserCoords[0], comparedUserCoords[1])
                <= Integer.parseInt(getUserRadius(new User("", "","",new double[]{})));
    }

    public String expirationDateColor(int time){
        return time >= 1000 ? "Red" : time >= 500 ? "Orange" : time >= 10 ? "Red" : "Black";
    }

    /**
     * Displays the map page.
     *
     * @param model The model that defines the attributes to be displayed.
     * @return The name of the view to display.
     */
    @GetMapping("/viewmap")
    public String viewmap(@RequestParam(name = "radius", defaultValue = "80") String radius, Model model) {
        /*
         *  Creates a list of example Users with coordinates, in the real implementation, should fetch from the database.
         */
        List<User> dummyUsers = new ArrayList<>();
        dummyUsers.add(new User("Adam", "123", "adam@gmail.com", new double[]{-27.4785, 153.0284}));
        dummyUsers.add(new User("Jayden", "321", "jayden@gmail.com", new double[]{-27.4783, 153.0290}));
        dummyUsers.add(new User("Jason", "213", "jason@gmail.com", new double[]{-27.4788, 153.0279}));

        List<FoodItem> dummyFoodItems = new ArrayList<>();
        dummyFoodItems.add(new FoodItem("Tomahawk Steak", 10052));
        dummyFoodItems.add(new FoodItem("Halal Khebabs", 4922));
        dummyFoodItems.add(new FoodItem("Chicken and Rice", 40));


        for (User user : dummyUsers) {
            if (!(withinDistance(dummyUsers.get(0).getCoordinates(), user.getCoordinates()))) {
                dummyUsers.remove(user);
            }
        }

        // add attributes to the model
        model.addAttribute("mapusers", dummyUsers);
        model.addAttribute("chosenuser", dummyUsers.get(0));
        model.addAttribute("users", userDAO.listUsers());
        model.addAttribute("radius", radius);
        model.addAttribute("dummyfood", dummyFoodItems);

        dummyRadius = radius;
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
