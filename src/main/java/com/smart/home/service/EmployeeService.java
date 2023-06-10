package com.smart.home.service;

import com.smart.home.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee createEmployee(Employee employee);
}
