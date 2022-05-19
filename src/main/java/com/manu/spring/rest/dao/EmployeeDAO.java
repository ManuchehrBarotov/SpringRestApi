package com.manu.spring.rest.dao;


import com.manu.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
     List<Employee> getAllEmployees();

     public void save(Employee employee);

     public Employee  getEmployee( int id);

     public void deleteEmployee(int id);
}
