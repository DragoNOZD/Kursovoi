package org.tr.swapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }

    @GetMapping("/login2")
    public String login2(Model model){
        model.addAttribute("warning", "warning");
        return "login";
    }
}
