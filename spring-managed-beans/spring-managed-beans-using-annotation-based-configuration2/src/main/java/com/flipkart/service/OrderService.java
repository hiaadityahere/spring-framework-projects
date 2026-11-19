package com.flipkart.service;

import com.flipkart.config.SpringConfig;
import com.flipkart.model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flipkart.repository.OrderRepository;

@Component
public class OrderService {

	private final SpringConfig springConfig;
	private OrderRepository orderRepository;
	
	@Autowired
	public OrderService(OrderRepository orderRepository, SpringConfig springConfig) {
		this.orderRepository = orderRepository;
		this.springConfig = springConfig;
	}

	public void placeOrder() {
		Order order = new Order("ORD-154", "Sony Camera Lens F-15");
		System.out.println("Processing Order");
		orderRepository.saveOrder(order);
		System.out.println("Order Placed Successfully!");
	}
	
}
