package org.tr.swapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainPageController {

    @PostMapping("/main")
    public String main(Model model,
                            @RequestParam(value = "login", defaultValue = "") String login,
                            @RequestParam(value = "name", defaultValue = "") String name) {
        if (name.equals("") && login.equals("")){
            model.addAttribute("warning", "Set name and login");
            return "redirect:login";
        }
        else if (name.equals("")){
            model.addAttribute("warning", "Set name");
            return "redirect:login";
        }
        else if (login.equals("")){
            model.addAttribute("warning", "Set login");
            return "redirect:login";
        }
        model.addAttribute("message", "Hello, " + name);
        return "main";
    }
}
