package org.tr.swapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainPageController {

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("message", "Hello");
        return "main";
    }

    @RequestMapping(value = "/main1", method = RequestMethod.GET)
    public String main(Model model, @RequestParam(value = "password", defaultValue = "") String password) {
        model.addAttribute("message", "Hello, " + password);
        return "main";
    }
}
