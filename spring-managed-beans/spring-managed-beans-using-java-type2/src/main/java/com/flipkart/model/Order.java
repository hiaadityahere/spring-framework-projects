package com.flipkart.model;

public class Order {

	private String orderId;
	private String productName;

	public Order(String orderId, String productName) {
		super();
		this.orderId = orderId;
		this.productName = productName;
	}

	public void displayOrder() {
		System.out.println(
				"\tOrder ID: " + orderId 
				+ "\n\tProduct Name: " + productName
			);
	}

}
