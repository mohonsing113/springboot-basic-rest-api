package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.CompanyService;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/companies")
public class CompanyResource {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    CompanyService companyService;

    public CompanyResource() {
        this.companyService = new CompanyService();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Company> list(){ return companyService.list(); }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Company getCompanyById(@PathVariable int id){ return companyService.getCompanyById(id); }


}