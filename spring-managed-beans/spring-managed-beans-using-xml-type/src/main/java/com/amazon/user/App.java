package com.amazon.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        
    	String configFile = "beans.xml";
    	
    	// 1. create IOC container
    	ApplicationContext context = new ClassPathXmlApplicationContext(configFile);
    	
    	// 2. Request for Bean
    	User user1 = context.getBean("user1", User.class); // 1st way
    	User user2 = (User)context.getBean("user2"); // 2nd way (Downcasting)
    	User user3 = context.getBean("user3", User.class);
    	User user4 = context.getBean("user4", User.class);
    	User user5 = context.getBean("user5", User.class);
    	
    	// 3. Use the Bean
    	user1.displayUserInfo();
    	user2.displayUserInfo();
    	user3.displayUserInfo();
    	user4.displayUserInfo();
    	user5.displayUserInfo();
    }
}
