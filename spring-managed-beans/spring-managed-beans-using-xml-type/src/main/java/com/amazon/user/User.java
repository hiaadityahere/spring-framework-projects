package com.amazon.user;

public class User {

	private int id;
	private String name;
	private String type;
	private String location;

	public User() {
		super();
	}

	public User(int id, String name, String type, String location) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.location = location;
	}
	
	public void displayUserInfo() {
		System.out.println("User [id=" + id + ", name=" + name + ", type=" + type + ", location=" + location + "]");
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
