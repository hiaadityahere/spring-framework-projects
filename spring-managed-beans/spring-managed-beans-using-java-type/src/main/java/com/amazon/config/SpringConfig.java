package com.amazon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazon.employee.Employee;


@Configuration
public class SpringConfig {

	@Bean("emp1")
	public Employee createEmp1() {
		Employee employee = new Employee("Alpha", "EMP-101", "PREMIUM");
		return employee;
	}
	
	@Bean("emp2")
	public Employee createEmp2() {
		Employee employee = new Employee("Beta", "EMP-102", "SEMI-PREMIUM");
		return employee;
	}
	
	// if no bean name is written then method name will act like bean id
	@Bean
	public Employee createEmp3() {
		Employee employee = new Employee("Charlie", "EMP-103", "REGULAR");
		return employee;
	}
	
}
