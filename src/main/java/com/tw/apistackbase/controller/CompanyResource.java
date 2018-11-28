package com.tw.apistackbase.controller;

import com.tw.apistackbase.service.Company;
import com.tw.apistackbase.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/companies")
public class CompanyResource {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    CompanyService companyService;

    @Autowired
    public CompanyResource(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Company>> list(){ return ResponseEntity.ok(companyService.list()); }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Company> getCompanyById(@PathVariable int id){ return ResponseEntity.ok(companyService.getCompanyById(id)); }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Company> create(@RequestBody Company company){
        return ResponseEntity.ok(companyService.create(company));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Company> update(@PathVariable int id, @RequestBody Company company){
        return ResponseEntity.ok(companyService.update(id, company));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Company> delete(@PathVariable int id){
        return ResponseEntity.ok(companyService.delete(id));
    }


}