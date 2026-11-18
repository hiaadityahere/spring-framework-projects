package com.flipkart.finance.repository;

import com.flipkart.finance.model.Order;

public class OrderRepository {
	
	public void save(Order order) {
		System.out.println("Saving order to DB...");
		order.displayOrder();
	}
}
