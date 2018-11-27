package com.tw.apistackbase.service;

import com.tw.apistackbase.model.Company;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyServiceTest {

    @Test
    public void should_return_all_company() {

        Map<Integer, Company> expectedCompanys = new HashMap<Integer, Company>();
        expectedCompanys.put(1, new Company(1, "apple"));
        expectedCompanys.put(2, new Company(2, "microsoft"));

        assertEquals(expectedCompanys.size(), (new CompanyService().list().size()));
    }

}