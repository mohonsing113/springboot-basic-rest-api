package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.service.CompanyService;
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

    @RequestMapping(method = RequestMethod.POST)
    public Company create(@RequestBody Company company){
        return companyService.create(company);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Company update(@PathVariable int id, @RequestBody Company company){
        return companyService.update(id, company);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Company delete(@PathVariable int id){
        return companyService.delete(id);
    }


}