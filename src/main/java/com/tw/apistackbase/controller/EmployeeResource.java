package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.service.EmployeeService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.logging.*;

@RestController
@RequestMapping("companies/{id}/employees")
public class EmployeeResource {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    EmployeeResource employeeResource;
    CompanyResource companyResource;

    public EmployeeResource() {
        companyResource = new CompanyResource();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> list(@PathVariable int id) {
        return loadEmployeeService(id).list();
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