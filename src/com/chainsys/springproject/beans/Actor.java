package com.chainsys.springproject.beans;

public class Actor {
	private int id;
	private String name;
	
	public Actor(int id, String name) {
		this.id=id;
		this.name=name;
	}
	public Actor() {
		System.out.println("Actor class invoked "+hashCode());
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void print() {
		System.out.println("Name: "+this.name);
		System.out.println("Id: "+ this.id);
	}
	
}