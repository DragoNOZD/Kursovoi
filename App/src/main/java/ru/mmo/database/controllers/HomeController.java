package ru.mmo.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.mmo.database.item.weapon.WeaponMount;
import ru.mmo.database.item.weapon.melee.Melee;
import ru.mmo.database.item.weapon.melee.MeleeService;
import ru.mmo.database.item.weapon.melee.combo.Action;
import ru.mmo.database.item.weapon.melee.combo.Combo;
import ru.mmo.database.item.weapon.melee.combo.ComboService;
import ru.mmo.database.item.weapon.melee.combo.Condition;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private MeleeService meleeService;

    private ComboService comboService;

    public HomeController(MeleeService meleeService, ComboService comboService) {
        this.meleeService = meleeService;
        this.comboService = comboService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        Melee melee = new Melee("Test melee", WeaponMount.BACK);
        Combo combo = new Combo(50);
        List<Action> actions = new ArrayList<>();
        actions.add(Action.MELEE_ATTACK);
        actions.add(Action.MELEE_ATTACK);
        actions.add(Action.MELEE_ATTACK);
        actions.add(Action.MELEE_ATTACK);
        actions.add(Action.MELEE_ATTACK);
        combo.setSeq(actions);
        List<Condition> conditions = new ArrayList<>();
        conditions.add(Condition.AT_FLOOR);
        combo.setConditions(conditions);
        comboService.addCombo(combo);
        List<Combo> combos = new ArrayList<>();
        combos.add(comboService.getCombo(combo.getId()));
        melee.setComboList(combos);
        meleeService.addMelee(melee);
        return "home";
    }
}
