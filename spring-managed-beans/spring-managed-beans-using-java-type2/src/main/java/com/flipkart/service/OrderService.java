package com.flipkart.service;

import com.flipkart.model.Order;
import com.flipkart.repository.OrderRepository;

public class OrderService {

	private Order order;
	private OrderRepository orderRepository;

	public OrderService(Order order, OrderRepository orderRepository) {
		super();
		this.order = order;
		this.orderRepository = orderRepository;
	}
	
	public void placeOrder() {
		System.out.println("Processing Order...");
		orderRepository.saveOrder(order);
	}
	
}
