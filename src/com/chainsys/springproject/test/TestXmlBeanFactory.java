package com.chainsys.springproject.test;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.chainsys.springproject.beans.Customer;
import com.chainsys.springproject.beans.Employee;

public class TestXmlBeanFactory {
	public static void testA() {
//		ApplicationContext apcontext=new ClassPathXmlApplicationContext("beans.xml");
		ClassPathResource res = new ClassPathResource("Beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);
		Employee emp = factory.getBean(Employee.class);
		emp.setId(324);
		emp.setName("Maheshwaran");
		emp.print();
		System.out.println(factory.isSingleton("emp"));
		System.out.println(factory.getBean("emp") instanceof Employee);
		System.out.println(factory.getBean("emp") instanceof Customer);
		System.out.println(factory.isPrototype("emp"));
		System.out.println(factory.isTypeMatch("emp", Employee.class));

	}
}