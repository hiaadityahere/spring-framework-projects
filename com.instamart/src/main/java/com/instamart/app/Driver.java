package com.instamart.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.instamart.employee.Employee;

public class Driver {

	public static void main(String[] args) {
		String path = "beans.xml";
		
		// create an IOC container
		ApplicationContext iocContainer = new ClassPathXmlApplicationContext(path);
		
		Employee employee = (Employee)iocContainer.getBean("emp1");
		
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		
		
		Employee employee1 = (Employee)iocContainer.getBean("emp2");
		
		System.out.println(employee1.getId());
		System.out.println(employee1.getName());
		
		System.out.println("Total Employee: " + com.instamart.employee.Employee.counter);
	}
}
