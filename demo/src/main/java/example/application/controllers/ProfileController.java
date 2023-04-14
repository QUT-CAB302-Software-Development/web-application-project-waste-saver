package example.application.controllers;


import example.data.StaticUserDAO;
import example.data.User;
import example.data.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Controller for the profile page.
 */
@Controller
public class ProfileController {
    /**
     * The singleton instance of the database connection. This is used to access the
     * database of users.
     */
    private final StaticUserDAO userDAO = new StaticUserDAO();
    private boolean firstTime = true;

    private User logged;
    private User user;

    /**
     * Displays the preferences page.
     *
     * @param model The model that defines the attributes to be displayed.
     * @return The name of the view to display.
     */
    @GetMapping("/profile")
    public String showProfileForm(Model model) {
        System.out.println(firstTime);
        if (firstTime){
            User u = new User("Jayden H", "password", "jayden@gmail", new double []{-27.4785, 153.0284});
            u.setFirstName("Jayden");
            u.setLastName("Hobbs");
            userDAO.addUser(u);
            firstTime=false;
        }
        logged = userDAO.getUser("jayden@gmail");

        user = userDAO.getUser("jayden@gmail");

        for (User u1 : userDAO.listUsers())
        {
            System.out.println(u1.getEmail());
        }
        model.addAttribute("logged", logged);
        model.addAttribute("user", user);
        return "profile-page";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST, params = "save")
    public String saveSubmit(@ModelAttribute User user, Model model) {

        User temp = userDAO.getUser(logged.getEmail());

        if (user.getFirstName() != null && !user.getFirstName().isEmpty()){
            temp.setFirstName(user.getFirstName());
        }

        if (user.getLastName() != null && !user.getLastName().isEmpty()){
            temp.setLastName(user.getLastName());
        }

        userDAO.updateUser(temp);


        model.addAttribute("logged", userDAO.getUser(logged.getEmail()));
        model.addAttribute("user", userDAO.getUser(logged.getEmail()));
        return "profile-page";
    }
}
