package ru.trapeznikov.database.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.trapeznikov.database.company.Company;
import ru.trapeznikov.database.company.CompanyService;

@Controller
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "NewCompany")
    public String newCompany(Model model){
        return "companies/newCompany";
    }

    @RequestMapping(value = "NewCompanyCheck", method = RequestMethod.POST)
    public String newCompanyCheck(Model model,
                              @RequestParam("inn") Long inn,
                              @RequestParam("name") String name) {
        if (companyService.getByINN(inn) != null){
            model.addAttribute("warning", "Company is already exists.");
            return "companies/newCompany";
        }
        companyService.addCompany(new Company(inn, name));
        return "redirect:/";
    }

    @RequestMapping(value = "companies")
    public String companies(Model model){
        return "companies/companies";
    }

    @RequestMapping(value = "companies/{inn}")
    public String company(Model model, @PathVariable Long inn){
        return "companies/company";
    }
}
