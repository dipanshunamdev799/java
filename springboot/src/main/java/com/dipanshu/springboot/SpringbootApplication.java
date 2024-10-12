package com.dipanshu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
/*
 * IoC and Dependency Injection
 * Containers?
 */
@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringbootApplication.class, args);
		//applicationContext : container access
		//Wring : connect objects/beans/classes in the container
		System.out.println("Hello Dipanshu");
		Student student1 = applicationContext.getBean(Student.class);  //bean == class/object in spring
		student1.code();

		//IOC
		//Let spring create and handle objexts ***Application Context***

	}

}
