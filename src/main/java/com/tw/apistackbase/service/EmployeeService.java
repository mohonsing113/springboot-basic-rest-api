package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Employee;

import java.util.*;

public class EmployeeService {

    private static Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
    static int currentId=4;

    static {
        employees.put(0, new Employee(0, "Xiaoming", 20, "Male"));
        employees.put(1, new Employee(1, "Xiaohong", 19, "Female"));
        employees.put(2, new Employee(2, "Xiaozhi", 15, "Male"));
        employees.put(3, new Employee(3, "Xiaogang", 16, "Male"));
        employees.put(4, new Employee(4, "Xiaoxia", 15, "Female"));
    }

    public static List<Employee> list(){
        return new ArrayList<Employee>(employees.values());
    }

    public static Employee create(Employee employee) {
        currentId+=1;
        employee.setId(currentId);
        employees.put(currentId, employee);
        return employee;
    }

    public static Employee update(int id, Employee employee) {
        employees.put(id, employee);
        return employee;
    }

    public static Employee delete(int id) {
        return employees.remove(id);
    }
}