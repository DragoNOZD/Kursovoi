package org.tr.swapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainPageController {



    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String main(Model model) {
        model.addAttribute("message", "Hello");
        return "main";
    }
}
