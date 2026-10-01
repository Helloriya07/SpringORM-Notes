package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ioc = new AnnotationConfigApplicationContext(Config.class);
        Employee emp = new Employee("Riya","Account");
        EmployeeService ee = ioc.getBean(EmployeeService.class);
        ee.save(emp);
    }
}
