package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("companies/{id}/employees")
public class EmployeeResource {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    CompanyResource companyResource;

    public EmployeeResource() {
        companyResource = new CompanyResource();
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> listGender(@PathVariable int id, @RequestParam (value= "gender",  required = false) String gender) {
        if(gender==null)
            return loadEmployeeService(id).list();
        return loadEmployeeService(id).listGender(gender);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee create(@PathVariable int id, @RequestBody Employee employee) {
        return loadEmployeeService(id).create(employee);
    }

    @RequestMapping(value = "/{eid}", method = RequestMethod.PUT)
    public Employee update(@PathVariable int id,@PathVariable int eid, @RequestBody Employee employee) {
        return loadEmployeeService(id).update(eid, employee);
    }

    @RequestMapping(value = "/{eid}", method = RequestMethod.DELETE)
    public Employee delete(@PathVariable int id,@PathVariable int eid) {
        return loadEmployeeService(id).delete(eid);
    }

    public EmployeeService loadEmployeeService(int id) {
        return new EmployeeService(companyResource.getCompanyById(id).getEmployees());
    }
}