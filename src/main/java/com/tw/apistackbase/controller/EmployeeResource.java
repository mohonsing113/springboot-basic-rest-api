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
@RequestMapping("/employees")
public class EmployeeResource {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> list(){
        return EmployeeService.list();
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee){
        return EmployeeService.create(employee);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public Employee update(@PathVariable int id, @RequestBody Employee employee){
        return EmployeeService.update(id, employee);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public Employee delete(@PathVariable int id){
        return EmployeeService.delete(id);
    }

}