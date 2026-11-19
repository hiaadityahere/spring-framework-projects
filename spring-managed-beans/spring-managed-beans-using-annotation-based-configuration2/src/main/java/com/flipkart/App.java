package com.flipkart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.flipkart.config.SpringConfig;
import com.flipkart.service.OrderService;

public class App {
	public static void main(String[] args) {
		
		// 1. create the IoC Container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		// 2. request the bean
		OrderService orderService = context.getBean(OrderService.class);
		
		// 3. execute business logic
		orderService.placeOrder();
		
		// 4. close IoC Container
		context.close();
	}
}
