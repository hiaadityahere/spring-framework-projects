package com.flipkart.spring_applicationcontext_java_config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.flipkart.spring_applicationcontext_java_config.config.SpringConfig;
import com.flipkart.spring_applicationcontext_java_config.service.OrderService;

public class App {
	public static void main(String[] args) {

		// 1. Creating ApplicationContext and registering SpringConfig
		// Spring automatically processes @Configuration and @Bean annotations
		// and registers the corresponding bean definitions.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		// 2. Retrieving OrderService bean using its bean name and type
		OrderService orderService = context.getBean("orderService", OrderService.class);

		// 3. Calling the business method
		orderService.placeOrder();

		// 4. Closing ApplicationContext
		// Releases resources and destroys singleton beans managed by the context.
		context.close();
	}
}
