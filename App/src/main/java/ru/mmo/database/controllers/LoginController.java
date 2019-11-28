package ru.mmo.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mmo.database.account.Account;
import ru.mmo.database.account.AccountService;

@Controller
public class LoginController {

    private AccountService accountService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(AccountService accountService, PasswordEncoder passwordEncoder) {
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){
        return "user/login";
    }

    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
    public String loginCheck(Model model,
                             @RequestParam(value = "login", defaultValue = "") String login,
                             @RequestParam(value = "password", defaultValue = "") String password){
        Account account = accountService.getByLogin(login);
        if (account == null){
            model.addAttribute("warning", "User \"" + login + "\" is not exists.");
            return "user/login";
        }
        if (account.checkPassword(passwordEncoder.encode(password))) {
            model.addAttribute("warning", "Password is not correct.");
            return "user/login";
        }
        return "redirect:/users/" + login;
    }
}
