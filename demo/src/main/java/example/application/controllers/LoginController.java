package example.application.controllers;

import example.application.model.UserEntity;
import example.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "login-page";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute("user") UserEntity user,
                              RedirectAttributes redirectAttrs) {
        System.out.println(userService.getUserByUserName(user.getUsername()));
        UserEntity existingUser = userService.getUserByUserName(user.getUsername());

        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            redirectAttrs.addFlashAttribute("user", existingUser);
            return "redirect:/main";
        } else {
            redirectAttrs.addFlashAttribute("error", "Invalid username or password");
            return "redirect:/login";
        }
    }
}

