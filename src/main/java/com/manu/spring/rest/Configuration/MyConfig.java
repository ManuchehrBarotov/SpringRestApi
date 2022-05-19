package com.manu.spring.rest.Configuration;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.dialect.MySQLDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;


@ComponentScan("com.manu.spring.rest")
@EnableWebMvc
@EnableTransactionManagement
@Configuration
public class MyConfig {

    @Bean("data")
    public DataSource source(){

        ComboPooledDataSource dataSource =new ComboPooledDataSource();
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }


    @Bean
    public LocalSessionFactoryBean session(){
        LocalSessionFactoryBean local=new LocalSessionFactoryBean();
        local.setDataSource(source());
        local.setPackagesToScan("com.manu.spring.rest.entity");
        MySQLDialect dialect=new MySQLDialect();

        Properties dia = new  Properties();
        dia.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        dia.setProperty("hibernate.show_sql","true");

        local.setHibernateProperties(dia);

        return local;
    }


    @Bean
    public HibernateTransactionManager transaction(){
        HibernateTransactionManager tran=new HibernateTransactionManager();
        tran.setSessionFactory(session().getObject());
        return tran;
    }

}
