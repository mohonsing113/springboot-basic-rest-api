package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompanyService {

    private Map<Integer, Company> companys = new HashMap<Integer, Company>();
    static int currentId=4;

    public CompanyService(){
        companys.put(1, new Company(1, "apple"));
        companys.put(2, new Company(2, "microsoft"));
    }

    public List<Company> list(){
        return new ArrayList<Company>(companys.values());
    }
}