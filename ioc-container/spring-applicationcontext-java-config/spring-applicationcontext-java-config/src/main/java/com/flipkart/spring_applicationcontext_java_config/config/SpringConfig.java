package com.flipkart.spring_applicationcontext_java_config.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.flipkart.spring_applicationcontext_java_config.repository.OrderRepository;
import com.flipkart.spring_applicationcontext_java_config.service.OrderService;

@Configuration
public class SpringConfig {

	@Bean
	public OrderRepository orderRepository() {
		return new OrderRepository();
	}
	
	@Bean("orderService")
	public OrderService orderService() {
		OrderService orderService = new OrderService(orderRepository());
		return orderService;
	}
}
