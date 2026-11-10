package com.amazon.employee;

public class Employee {

	private String name;
	private String id;
	private String band;
	
	private Department department;
	private Address address;
	
	public Employee(String name, String id, String band, Department department, Address address) {
		super();
		this.name = name;
		this.id = id;
		this.band = band;
		this.department = department;
		this.address = address;
	}

	public void displayInfo() {
		System.out.println(
			"Employee Details: "
			+ "\n\tName: " + name 
			+ "\n\tID: " + id 
			+ "\n\tBand: " + band 
			+ "\n\tDepartment: " + department 
			+ "\n\tAddress: " + address
		);
	}
}
