package com.amazon.employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	String configFile = "beans.xml";
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext(configFile);
    	
    	Employee employee1 = context.getBean("employee", Employee.class);
    	
    	employee1.displayEmployeeInfo();
    }
}
