package ru.mmo.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mmo.database.purchase.PaymentMethod;
import ru.mmo.database.purchase.Purchase;
import ru.mmo.database.purchase.PurchaseService;
import ru.mmo.database.account.AccountService;

@Controller
public class PurchaseController {

    private AccountService accountService;

    private PurchaseService purchaseService;

    @Autowired
    public PurchaseController(AccountService accountService, PurchaseService purchaseService) {
        this.accountService = accountService;
        this.purchaseService = purchaseService;
    }

    @RequestMapping(value = "/purchase")
    public String purchase(Model model){
        return "purchase";
    }

    @RequestMapping(value = "/purchaseCheck", method = RequestMethod.POST)
    public String purchaseCheck(Model model,
                                @RequestParam("userLogin") String userLogin,
                                @RequestParam("gameID") Long gameID){
        purchaseService.addPurchase(new Purchase(accountService.getByLogin(userLogin), PaymentMethod.DA));
        return "redirect:/";
    }
}
