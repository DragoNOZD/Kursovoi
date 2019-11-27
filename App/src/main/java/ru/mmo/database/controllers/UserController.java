package ru.mmo.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mmo.database.account.Account;
import ru.mmo.database.account.AccountService;

@Controller
public class UserController {

    private AccountService accountService;

    @Autowired
    public UserController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/users")
    public String users(Model model){
        model.addAttribute("accounts", accountService.getAll());
        return "user/users";
    }

    @RequestMapping(value = "/users/{login}")
    public String user(Model model, @PathVariable String login){
        Account account = accountService.getByLogin(login);
        if (account != null) {
            model.addAttribute("login", account.getLogin());
        }
        return "user/user";
    }
}
