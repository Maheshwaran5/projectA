package com.chainsys.springproject.beans;

public class Employee
{
	private int id;
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

private String name;

public void print()
{
System.out.println(this.getId());	
System.out.println(this.getName());
}
public Employee()
{
	System.out.println("Employee object created" + hashCode());
	
}
}