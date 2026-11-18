package com.flipkart.finance.model;

public class Order {

	private int orderId;
	private String productName;

	public Order(int orderId, String productName) {
		super();
		this.orderId = orderId;
		this.productName = productName;
	}

	public void displayOrder() {
		System.out.println("Order ID: " + orderId);
		System.out.println("Product: " + productName);
	}
	
}
