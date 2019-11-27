package ru.mmo.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mmo.database.account.Account;
import ru.mmo.database.account.AccountService;

@Controller
public class SignUpController {

    private AccountService accountService;

    @Autowired
    public SignUpController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUp(Model model){
        return "user/signup";
    }

    @RequestMapping(value = "/signUpCheck", method = RequestMethod.POST)
    public String signUpCheck(Model model,
                              @RequestParam("login") String login,
                              @RequestParam("password") String password) {
        if (accountService.getByLogin(login) != null){
            model.addAttribute("warning", "Login \"" + login + "\" is already used.");
            return "user/signup";
        }
        accountService.addUser(new Account(login, password));
        return "redirect:/users/" + login;
    }
}
