package example.application.controllers;

import example.application.exception.RecordNotFoundException;
import example.application.model.UserEntity;
import example.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller

public class DataBaseController {

    @Autowired
    UserService service;

    @RequestMapping("/alluser")

    public String getAllUser(Model model)
    {
        System.out.println("getAllUser");

        List<UserEntity> list = service.getAllUser();

        model.addAttribute("users", list);

        return "list-user";
    }




    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editUserId(Model model, @PathVariable("id") Optional<Long> id)
            throws RecordNotFoundException
    {

        System.out.println("editUserById" + id);
        if (id.isPresent()) {
            UserEntity entity = service.getUserById(id.get());
            model.addAttribute("users", entity);
        } else {
            model.addAttribute("users", new UserEntity());
        }


        return "Login_user_database";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteUserById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {

        System.out.println("deleteUserById" + id);

        service.deleteUserId(id);
        return "redirect:/alluser";
    }

    @RequestMapping(path = "/createUser", method = RequestMethod.POST)
    public String createOrUpdateUser(UserEntity users)
    {
        System.out.println("createOrUpdateUser ");

        service.createOrUpdateUser(users);

        return "redirect:/alluser";
    }
}
