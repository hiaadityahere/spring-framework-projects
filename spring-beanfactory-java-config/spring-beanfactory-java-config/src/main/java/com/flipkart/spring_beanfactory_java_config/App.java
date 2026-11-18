package com.flipkart.spring_beanfactory_java_config;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;

import com.flipkart.spring_beanfactory_java_config.config.SpringConfig;
import com.flipkart.spring_beanfactory_java_config.service.OrderService;

public class App {
	public static void main(String[] args) {

		// 1. Creating BeanFactory (IoC Container)
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		// 2. Creating AnnotatedBeanDefinitionReader
		// It registers classes containing Spring annotations as bean definitions.
		AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);

		// 3. Registering SpringConfig class with BeanFactory
		// SpringConfig contains @Configuration and @Bean annotations.
		reader.registerBean(SpringConfig.class);

		// 4. Creating ConfigurationClassPostProcessor
		// It processes @Configuration and @Bean annotations.
		ConfigurationClassPostProcessor processor = new ConfigurationClassPostProcessor();

		// 5. Processing the registered configuration class
		// It identifies @Bean methods and registers their bean definitions
		// inside BeanFactory.
		processor.postProcessBeanDefinitionRegistry(beanFactory);

		// 6. Processing the BeanFactory
		// It performs additional processing of the BeanFactory after
		// registering the bean definitions.
		processor.postProcessBeanFactory(beanFactory);

		// 7. Retrieving OrderService bean using its bean name and type
		OrderService orderService = beanFactory.getBean("orderService", OrderService.class);

		// 8. Calling the business method
		orderService.placeOrder();

	}
}
