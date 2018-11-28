package com.tw.apistackbase.controller;

import com.tw.apistackbase.service.CompanyService;
import com.tw.apistackbase.service.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.*;

@RestController
@RequestMapping("companies/{id}/employees")
public class EmployeeResource {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    CompanyService companyService;

    @Autowired
    public EmployeeResource(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listGender(@PathVariable int id,
        @RequestParam(value = "gender", required = false) String gender,
        @RequestParam(name = "page", required = false) Integer pageIndex,
        @RequestParam(name = "size", required = false) Integer pageSize) {
        if (gender != null) {
            return ResponseEntity.ok(loadEmployeeService(id).listGender(gender));
        }
        if(pageIndex!=null && pageSize!=null){
            return ResponseEntity.ok(loadEmployeeService(id).getPage(pageIndex, pageSize));
        }
        return ResponseEntity.ok(loadEmployeeService(id).list());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Employee> create(@PathVariable int id, @RequestBody Employee employee) {
        return ResponseEntity.ok(loadEmployeeService(id).create(employee));
    }

    @RequestMapping(value = "/{eid}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> update(@PathVariable int id, @PathVariable int eid, @RequestBody Employee employee) {
        return ResponseEntity.ok(loadEmployeeService(id).update(eid, employee));
    }

    @RequestMapping(value = "/{eid}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> delete(@PathVariable int id, @PathVariable int eid) {
        return ResponseEntity.ok(loadEmployeeService(id).delete(eid));
    }

    public EmployeeService loadEmployeeService(int id) {
        return new EmployeeService(companyService.getCompanyById(id).getEmployees());
    }
}