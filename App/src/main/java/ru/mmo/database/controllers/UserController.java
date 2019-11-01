package ru.mmo.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mmo.database.user.User;
import ru.mmo.database.user.UserService;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users")
    public String users(Model model){
        return "user/users";
    }

    @RequestMapping(value = "/users/{login}")
    public String user(Model model, @PathVariable String login){
        User user = userService.getByLogin(login);
        if (user != null) {
            model.addAttribute("login", user.getLogin());
        }
        return "user/user";
    }
}
