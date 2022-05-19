package com.manu.spring.rest.dao;


import com.manu.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeesImpl implements EmployeeDAO{


   // SessionFactory facroty= new Configuration().configure("hibernate_test_connection.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

    @Autowired
    SessionFactory fac;


    @Override
    public List<Employee> getAllEmployees() {
        Session session=fac.getCurrentSession();
       // session.beginTransaction();
        List<Employee> allEmp=session.createQuery("from Employee",Employee.class).getResultList();
        Query<Employee> query=session.createQuery("from Employee",Employee.class);
        List<Employee> e=query.getResultList();


        System.out.println("Emps="+e);
        System.out.println("AllEmps="+allEmp);

        //session.getTransaction().commit();
        //session.close();
        //facroty.close();

        return e;
    }

    @Override
    public void save(Employee employee) {
        Session session=fac.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session=fac.getCurrentSession();
        return session.get(Employee.class,id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session=fac.getCurrentSession();

        Query<Employee> emp=session.createQuery("delete from Employee where id=:employee");
        emp.setParameter("employee",id);
        emp.executeUpdate();
    }
}
