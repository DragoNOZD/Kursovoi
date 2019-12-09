package ru.mmo.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mmo.database.account.Account;
import ru.mmo.database.account.AccountService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private AccountService accountService;

    @Autowired
    public UserController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/users")
    public String users(Model model,
                        @RequestParam(value = "countPerPage", defaultValue = "30") int countPerPage,
                        @RequestParam(value = "page", defaultValue = "0") int page){
        List<Integer> pages = new ArrayList<>();
        long pagesCount = (long)Math.ceil((double)(accountService.getEntitiesCount()/countPerPage));
        for (int i = 0; i < pagesCount; i++){
            if (i != page) {
                pages.add(i);
            }
        }
        if (page > 0){
            model.addAttribute("prevPage", page-1);
        }
        if (page + 1 <= pagesCount){
            model.addAttribute("nextPage", page+1);
        }
        int from = countPerPage*page;
        model.addAttribute("accounts", accountService.getAllLimited(from, countPerPage))
                .addAttribute("pages", pages)
                .addAttribute("countPerPage", countPerPage);
        return "user/users";
    }

    @RequestMapping(value = "/users/{login}")
    public String user(Model model, @PathVariable String login, HttpServletRequest request) throws UsernameNotFoundException {
        Account account = accountService.getByLogin(login);
        if (account == null) {
            throw new UsernameNotFoundException("User is not exists");
        }
        Account currentAccount = (Account)request.getSession().getAttribute("currentUser");
        model.addAttribute("edit", (currentAccount != null && account.getLogin().equals(currentAccount.getLogin())));
        model.addAttribute("login", account.getLogin());
        model.addAttribute("img", account.getImage());
        return "user/user";
    }

    @RequestMapping(value = "/users/{login}/settings")
    public String userSettings(Model model, @PathVariable String login, HttpServletRequest request){
        Account account = accountService.getByLogin(login);
        if (account == null) {
            throw new UsernameNotFoundException("User is not exists");
        }
        Account currentAccount = (Account)request.getSession().getAttribute("currentUser");
        if (!account.getLogin().equals(currentAccount.getLogin())){
            return "redirect: /users/" + login;
        }
        model.addAttribute("login", account.getLogin());
        return "user/userSettings";
    }
}
