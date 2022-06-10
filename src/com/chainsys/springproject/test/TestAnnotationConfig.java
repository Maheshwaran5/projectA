package com.chainsys.springproject.test;

import org.springframework.context.ApplicationContext; //parent
import org.springframework.context.annotation.AnnotationConfigApplicationContext; // child
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.springproject.appconfig.AppConfig;
import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;

public class TestAnnotationConfig {
	public static void testA() {
		ApplicationContext apcontext=new AnnotationConfigApplicationContext(AppConfig.class);
//		ApplicationContext apcontext1=new AnnotationConfigApplicationContext(AppConfig.class);
		Employee emp= apcontext.getBean(Employee.class);
		emp.setName("Maheshwaran");
		emp.setId(121);
		emp.print();
		Employee emp2= apcontext.getBean(Employee.class);
		emp.setName("Nagarathnam");
		emp.setId(1);
		emp.print();
		Customer c= apcontext.getBean(Customer.class);
		c.setId(645);
		c.setName("Elanjiyam");
		c.print();
		
	}
}