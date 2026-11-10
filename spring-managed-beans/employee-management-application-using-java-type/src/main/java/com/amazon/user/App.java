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
    	
    	System.out.println("=============================================");
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    	
    	Employee employee1 = context.getBean("emp1", Employee.class);
    	employee1.displayInfo();
    	
    	System.out.println("=============================================");
    	
    	Employee employee2 = context.getBean("emp2", Employee.class);
    	employee2.displayInfo();
    }
}
