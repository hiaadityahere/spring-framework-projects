package com.instamart.employee;

public class Employee {

	static {
		System.out.println(" Configuration Done...");
	}
	
	public static int counter = 0;
	
	{
		System.out.println("Object : " + (++counter));
	}
	
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
