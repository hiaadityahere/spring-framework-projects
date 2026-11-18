package com.flipkart.spring_applicationcontext_java_config.service;

import com.flipkart.spring_applicationcontext_java_config.repository.OrderRepository;

public class OrderService {

	private OrderRepository orderRepository; // HAS-A

	// Injecting Constructor Dependency
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public void placeOrder() {
		System.out.println("Placing order...");
		orderRepository.saveOrder();
	}
}
