package com.flipkart.repository;

import com.flipkart.model.Order;

public class OrderRepository {
	
	public void saveOrder(Order order) {
		System.out.println("Saving order to database...");
		order.displayOrder();
	}
}
