package com.amazon.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.config.SpringConfig;
import com.amazon.employee.Employee;

public class App 
{
    public static void main(String[] args)
    {
        System.out.println("Creating Spring beans using Annotation Type");
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Employee employee = context.getBean(Employee.class);
        
        employee.displayInfo();
    }
}
