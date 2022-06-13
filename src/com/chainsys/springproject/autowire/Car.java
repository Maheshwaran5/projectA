package com.chainsys.springproject.autowire;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource; //@Resources not working in java 9. Because it is deprecated.
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

public class Car {
	@Autowired
	private Engine petrolEngine;
	@Autowired(required=false)
	private Wheel alloy;

	public Car() {
		System.out.println("1 Car Object created " + hashCode());
	}

	public void begin() {
		petrolEngine.start();
	}

	public void move() {
		alloy.rotate();
	}

	@PostConstruct
	public void start() {
		System.out.println("Start AnnotationLc...");
	}

	@PreDestroy
	public void stop() {
		System.out.println("Stoped AnnotationLc...");
	}
}

@Component("SportsCar")
class SportsCar extends Car {
	public SportsCar() {
		System.out.println("Sports Car Created" + hashCode());
	}
}

@Component("SuvCar")
class SuvCar extends Car {
	public SuvCar() {
		System.out.println("Suv Car Created" + hashCode());
	}
}