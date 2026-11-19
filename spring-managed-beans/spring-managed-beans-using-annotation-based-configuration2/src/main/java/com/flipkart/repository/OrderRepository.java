package com.flipkart.repository;

import org.springframework.stereotype.Component;

import com.flipkart.model.Order;

@Component
public class OrderRepository {

	public void saveOrder(Order order) {
		System.out.println("Saving order to database...");
		order.displayOrder();
	}
}
