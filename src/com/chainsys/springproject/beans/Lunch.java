package com.chainsys.springproject.beans;

public class Lunch {
	private Starters entree;
	private MainCourse mainfood;
	private Dessert sweets;
//	 Constructor based Dependency injection
	public Lunch(Starters s,MainCourse m,Dessert d) {
		System.out.println("Lunch is ready");
		entree=s;
		mainfood=m;
		sweets=d;
	}
	public void serve() {
		System.out.println(entree.name);
		System.out.println(mainfood.name);
		System.out.println(sweets.name);

	}
}
/*
 * Lunch
 * Starters,Chicken, soup,vegroll
 */