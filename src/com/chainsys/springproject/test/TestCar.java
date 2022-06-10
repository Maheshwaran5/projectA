package com.chainsys.springproject.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.springproject.beans.Car;

public class TestCar {
	public static void firsttest() {
		ApplicationContext apcontext=new ClassPathXmlApplicationContext("Car2.xml");
		Car car=apcontext.getBean("jaguvar",Car.class);
		car.start();
		car.move();
	}
}