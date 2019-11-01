package ru.mmo.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mmo.database.user.User;
import ru.mmo.database.user.UserService;

@Controller
public class SignUpController {

    private UserService userService;

    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUp(Model model){
        return "signup";
    }

    @RequestMapping(value = "/signUpCheck", method = RequestMethod.POST)
    public String signUpCheck(Model model,
                              @RequestParam("login") String login,
                              @RequestParam("password") String password) {
        if (userService.getByLogin(login) != null){
            model.addAttribute("warning", "Login \"" + login + "\" is already used.");
            return "signup";
        }
        userService.addUser(new User(login, password));
        return "redirect:/users/" + login;
    }
}
