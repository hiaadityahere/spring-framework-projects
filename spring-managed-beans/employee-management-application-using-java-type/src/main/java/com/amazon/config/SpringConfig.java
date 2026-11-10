package com.amazon.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazon.employee.Address;
import com.amazon.employee.Department;
import com.amazon.employee.Employee;

@Configuration
public class SpringConfig {

	@Bean("developerDepartment")
	public Department createDepartment1() {
		Department department = new Department(155, "Developer");
		return department;
	}
	
	@Bean("bengaluruAddress")
	public Address createAddress1() {
		Address address = new Address("Bengaluru", "Karnataka", "India");
		return address;
	}
	
	
	@Bean("emp1")
	public Employee createEmployee1(
		@Qualifier("developerDepartment") Department department,
		@Qualifier("bengaluruAddress") Address address
	) {
		Employee employee = new Employee("Alpha", "EMP-101", "PREMIUM", department, address); 
		return employee;
	}
	
	
	@Bean("qaDepartment")
	public Department createDepartment2() {
		Department department = new Department(165, "QA");
		return department;
	}
	
	@Bean("hyderabadAddress")
	public Address createAddress2() {
		Address address = new Address("Hyderabad", "Telangana", "India");
		return address;
	}
	
	
	
	@Bean("emp2")
	public Employee createEmployee2(
		@Qualifier("qaDepartment") Department department,
		@Qualifier("hyderabadAddress") Address address
	) {
		Employee employee = new Employee("Beta", "EMP-102", "REGULAR", department, address);
		return employee;
	}
}
