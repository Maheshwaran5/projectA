package com.chainsys.springproject.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CarServices {
	@Autowired
	@Qualifier("SportsCar")
	private Car car;

	public void startTrip() {
		car.start();
	}
}
