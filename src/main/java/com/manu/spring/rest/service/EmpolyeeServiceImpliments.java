package com.manu.spring.rest.service;


import com.manu.spring.rest.dao.EmployeesImpl;
import com.manu.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpolyeeServiceImpliments implements EmployeeService{

    @Autowired
    private EmployeesImpl employeeDAO;

    @Transactional
    @Override
    public List<Employee> getAllEmploy() {
        return employeeDAO.getAllEmployees();
    }

    @Transactional
    @Override
    public void saveEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Transactional
    @Override
    public void deleteEmployee(int id) {
     employeeDAO.deleteEmployee(id);

    }
}
