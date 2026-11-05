package com.amazon.employee;

public class Employee {

	private int id;
	private String name;

	private Address address;
	private Department department;

	public Employee(int id, String name, Address address, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.department = department;
	}

	public void displayEmployeeInfo() {
		System.out.println(
			"Employee Details: "
			+ "\nName: " + name
			+ "\nAddress: " + address
			+ "\nDepartment: " + department
		);
	}	
}
