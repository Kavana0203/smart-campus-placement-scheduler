package com.placement.scheduler.Controller;

import com.placement.scheduler.Model.Company;
import com.placement.scheduler.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // Show add company page
    @GetMapping("/admin/company/add")
    public String showAddCompanyPage(Model model) {
        model.addAttribute("company", new Company());
        return "company-add";
    }

    // Handle add company form
    @PostMapping("/admin/company/add")
    public String addCompany(@ModelAttribute Company company, Model model) {
        try {
            companyService.addCompany(company);
            model.addAttribute("success", "Company added successfully!");
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "company-add";
    }

    // Show all companies
    @GetMapping("/admin/companies")
    public String getAllCompanies(Model model) {
        model.addAttribute("companies", companyService.getAllCompanies());
        return "company-list";
    }
}