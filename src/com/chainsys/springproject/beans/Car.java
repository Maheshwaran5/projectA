package com.chainsys.springproject.beans;

public class Car {
	private Engine petrolEngine;
	private Wheel alloy;
	public Engine getPetrolEngine() {
		return petrolEngine;
	}
	public void setPetrolEngine(Engine petrolEngine) {
		this.petrolEngine = petrolEngine;
	}
	public Wheel getAlloy() {
		return alloy;
	}
	public void setAlloy(Wheel alloy) {
		this.alloy = alloy;
	}
	
	public Car() {
		System.out.println("1 Car Object created "+ hashCode());
	}
	public Car(Engine petrolEngine,Wheel alloy) {
		System.out.println("2 Car Object created "+ hashCode());
		this.petrolEngine=petrolEngine;
		this.alloy=alloy;
	}
	public void start() {
		petrolEngine.start();
	}
	public void move() {
		alloy.rotate();
	}
}