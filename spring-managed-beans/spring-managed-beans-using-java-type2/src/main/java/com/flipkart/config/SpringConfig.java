package com.flipkart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.flipkart.model.Order;
import com.flipkart.repository.OrderRepository;
import com.flipkart.service.OrderService;

@Configuration
public class SpringConfig {

	// create Order bean
	@Bean("order1")
	public Order order1() {
		Order order = new Order("ORD-157", "Sony Camera f-56");
		return order;
	}
	
	// create OrderRepository bean
	@Bean("orderRepository1")
	public OrderRepository orderRepository1() {
		OrderRepository orderRepository = new OrderRepository();
		return orderRepository;
	}
	
	// create OrderService bean
	@Bean("orderService1")
	public OrderService orderService1() {
		OrderService orderService = new OrderService(order1(), orderRepository1());
		return orderService;
	}
}
