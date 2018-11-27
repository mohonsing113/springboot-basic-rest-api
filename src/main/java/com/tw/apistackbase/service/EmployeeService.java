package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {

    private Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
    static int currentId=4;

    public EmployeeService(List<Employee> employees) {
        employees.stream().forEach( employee -> this.employees.put(employee.getId(), employee));
//        employees.put(0, new Employee(0, "Xiaoming", 20, "Male", 5000));
//        employees.put(1, new Employee(1, "Xiaohong", 19, "Female", 3000));
//        employees.put(2, new Employee(2, "Xiaozhi", 15, "Male", 2500));
//        employees.put(3, new Employee(3, "Xiaogang", 16, "Male", 5200));
//        employees.put(4, new Employee(4, "Xiaoxia", 15, "Female", 3523));
    }


    public List<Employee> list(){
        return new ArrayList<Employee>(employees.values());
    }

    public Employee create(Employee employee) {
        currentId+=1;
        employee.setId(currentId);
        employees.put(currentId, employee);
        return employee;
    }

    public Employee update(int id, Employee employee) {
        employees.put(id, employee);
        return employee;
    }

    public Employee delete(int id) {
        return employees.remove(id);
    }

    public List<Employee> listGender(String gender) {
        return list().stream().filter(s -> s.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());
    }
}