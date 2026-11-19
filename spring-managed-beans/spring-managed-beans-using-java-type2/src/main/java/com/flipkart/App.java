package com.flipkart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.flipkart.config.SpringConfig;
import com.flipkart.service.OrderService;

public class App 
{
    public static void main( String[] args )
    {
    	// 1. create IoC Container using Java Config
    	ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    	
    	// 2. request for Bean
    	OrderService orderService = context.getBean("orderService1", OrderService.class);
    	
    	// 3. execute business logic
    	orderService.placeOrder();
    	
    	// 4. close the IoC container
    	((AnnotationConfigApplicationContext)context).close();
    }
}
