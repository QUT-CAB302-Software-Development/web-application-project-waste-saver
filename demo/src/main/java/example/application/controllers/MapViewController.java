package example.application.controllers;

import example.application.model.UserEntity;
import example.application.service.UserService;
import example.data.StaticUserDAO;
import example.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import example.application.model.UserEntity;
import example.application.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import example.application.exception.RecordNotFoundException;


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
    // Creating fake Database and Radius
    public String dummyRadius = "80";
    public String getUserRadius(User currentUser) {
        return dummyRadius;
    }

    //Connect to singleton Database
    @Autowired
    private UserService userService;

    public String expirationDateColor(int time){
        return time >= 1000 ? "Red" : time >= 500 ? "Orange" : time >= 10 ? "Red" : "Black";
    }

    //Controller for handling backside logic.
    @GetMapping("/viewmap")
    public String viewmap(@ModelAttribute("currentuser") UserEntity currentuser, Model model) {

        //If there is no logged-in user, throw an exception.
        if(currentuser.getFirstName() == null) {
            throw new IllegalArgumentException("Must be logged in");
        }


        // Retrieve all users from the database.
        List<UserEntity> userList = userService.getAllUser();

        // Create fake database of food.
        List<FoodItem> dummyFoodItems = new ArrayList<>();
        dummyFoodItems.add(new FoodItem("Tomahawk Steak", 10052));
        dummyFoodItems.add(new FoodItem("Halal Khebabs", 4922));
        dummyFoodItems.add(new FoodItem("Chicken and Rice", 40));
        dummyFoodItems.add(new FoodItem("Spaghetti Bolognese", 7314));
        dummyFoodItems.add(new FoodItem("Taco Salad", 5500));
        dummyFoodItems.add(new FoodItem("Vegetable Stir Fry", 2481));
        dummyFoodItems.add(new FoodItem("Fish and Chips", 1123));
        dummyFoodItems.add(new FoodItem("Pepperoni Pizza", 9136));
        dummyFoodItems.add(new FoodItem("Chicken Tikka Masala", 6745));
        dummyFoodItems.add(new FoodItem("Beef Burger", 8321));
        dummyFoodItems.add(new FoodItem("Vegan Pad Thai", 4275));
        dummyFoodItems.add(new FoodItem("Seafood Paella", 5621));
        dummyFoodItems.add(new FoodItem("Falafel Wrap", 3692));
        dummyFoodItems.add(new FoodItem("Sushi Platter", 9182));
        dummyFoodItems.add(new FoodItem("Beef Stroganoff", 7786));
        dummyFoodItems.add(new FoodItem("Gourmet Grilled Cheese", 2843));
        dummyFoodItems.add(new FoodItem("Pesto Pasta", 5121));
        dummyFoodItems.add(new FoodItem("Shrimp Scampi", 6462));
        dummyFoodItems.add(new FoodItem("Lobster Roll", 8623));
        dummyFoodItems.add(new FoodItem("BBQ Ribs", 7321));

        // add attributes to the model
        model.addAttribute("mapusers", userList);
        model.addAttribute("chosenuser", currentuser);
        model.addAttribute("radius", 80);
        model.addAttribute("dummyfood", dummyFoodItems);


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

    @PostMapping("/public-profile")
    public String publicprofile() {
        return "redirect:/public-profile";
    }

}
