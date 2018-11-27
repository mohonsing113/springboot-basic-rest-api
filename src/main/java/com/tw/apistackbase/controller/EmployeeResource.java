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

    EmployeeService employeeService;
    public EmployeeResource() {
        employeeService = new EmployeeService();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> list(){
        return employeeService.list();
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public Employee update(@PathVariable int id, @RequestBody Employee employee){
        return employeeService.update(id, employee);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public Employee delete(@PathVariable int id){
        return employeeService.delete(id);
    }

}