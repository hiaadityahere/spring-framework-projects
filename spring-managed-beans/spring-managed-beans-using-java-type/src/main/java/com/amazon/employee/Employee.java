package com.amazon.employee;

public class Employee {

	private String name;
	private String id;
	private String band;
	
	public Employee(String name, String id, String band) {
		super();
		this.name = name;
		this.id = id;
		this.band = band;
	}

	public void displayInfo() {
		System.out.println("name=" + name + ", id=" + id + ", band=" + band);
	}
}
