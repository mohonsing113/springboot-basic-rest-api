package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;

import java.util.*;

public class CompanyService {

    private Map<Integer, Company> companys = new HashMap<Integer, Company>();
    static int currentId = 2;

    public CompanyService() {
        companys.put(1, new Company(1, "apple",
                Arrays.asList(new Employee(0, "Xiaoming", 20, "Male", 5000)
                        , new Employee(1, "Xiaohong", 19, "Female", 3000))));
        companys.put(2, new Company(2, "microsoft",
                Arrays.asList(new Employee(2, "Xiaozhi", 15, "Male", 2500)
                        , new Employee(3, "Xiaogang", 16, "Male", 5200),
                        new Employee(4, "Xiaoxia", 15, "Female", 3523))));
    }

    public List<Company> list() {
        return new ArrayList<Company>(companys.values());
    }

    public Company getCompanyById(int id) {
        return companys.get(id);
    }


    public Company create(Company company) {
        currentId+=1;
        company.setId(currentId);
        companys.put(currentId, company);
        return company;
    }

    public Company update(int id, Company company) {
        companys.put(id, company);
        return company;
    }

    public Company delete(int id) {
        return companys.remove(id);
    }
}