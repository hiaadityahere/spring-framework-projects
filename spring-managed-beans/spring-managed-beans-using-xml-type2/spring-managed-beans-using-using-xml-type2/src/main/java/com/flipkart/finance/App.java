package com.flipkart.finance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flipkart.finance.service.OrderService;

public class App 
{
    public static void main( String[] args )
    {
    	// 1. Create IoC Container
    	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
    	
    	// 2. Request for Bean
    	OrderService orderService1 = context.getBean("orderService1", OrderService.class);
    	orderService1.placeOrder();
    }
}
