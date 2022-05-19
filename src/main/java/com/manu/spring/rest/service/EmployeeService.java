package com.manu.spring.rest.service;


import com.manu.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmploy();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public  void deleteEmployee(int id);
}
