package com.flipkart.finance.service;

import com.flipkart.finance.model.Order;
import com.flipkart.finance.repository.OrderRepository;

public class OrderService {

	private Order order;
	private OrderRepository orderRepository;

	public OrderService(Order order, OrderRepository orderRepository) {
		super();
		this.order = order;
		this.orderRepository = orderRepository;
	}
	
	public void placeOrder() {
		System.out.println("Processing order...");
		orderRepository.save(order);
		System.out.println("Order placed successfully!");
	}
}
