package com.amazon.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amazon.config.SpringConfig;
import com.amazon.employee.Employee;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Creating Spring Beans using Java..." );
        
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        
        Employee emp1 =  context.getBean("emp1", Employee.class);
        emp1.displayInfo();
        
        Employee emp2 = context.getBean("emp2", Employee.class);
        emp2.displayInfo();
        
        Employee emp3 = context.getBean("createEmp3", Employee.class);
        emp3.displayInfo();
    }
}
