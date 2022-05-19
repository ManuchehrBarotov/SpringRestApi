package com.manu.spring.rest.controller;


import com.manu.spring.rest.entity.Employee;
import com.manu.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    EmployeeService emp;

    @GetMapping("/get")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmps=emp.getAllEmploy();
        return allEmps;
    }

    @GetMapping("get/{id}")
    public Employee getEmployee(@PathVariable int id){
        return emp.getEmployee(id);
    }





}
