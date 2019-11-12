package ru.mmo.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mmo.database.item.weapon.WeaponMount;
import ru.mmo.database.item.weapon.melee.Melee;
import ru.mmo.database.item.weapon.melee.MeleeService;

@Controller
public class WeaponController {

    private MeleeService meleeService;

    @Autowired
    public WeaponController(MeleeService meleeService) {
        this.meleeService = meleeService;
    }

    @RequestMapping(value = "/weapons/melee/newMelee", method = RequestMethod.GET)
    public String newMelee(Model model){
        return "weapons/melee/newMelee";
    }

    @RequestMapping(value = "/weapons/melee/addMelee", method = RequestMethod.POST)
    public String addMelee(Model model,
                           @RequestParam(value = "name", defaultValue = "") String name,
                           @RequestParam(value = "pos", defaultValue = "") String pos) {
        Melee melee = new Melee(name, WeaponMount.valueOf(pos.toUpperCase()));
        meleeService.addMelee(melee);
        return "home";
    }
}
