package com.chainsys.springproject.beans;

public class LunchFactory {
	public Lunch createNonVegSouthIndianLunch() {
		Starters s1=new Chicken();
		s1.name="HoneyChicken";
		MainCourse m=new SouthIndian();
		m.name="Rice";
		Dessert d=new Cakes();
		d.name="BlackForest";
		Lunch l=new Lunch(s1,m,d);
		return l;
	}
	public Lunch createVegSouthIndianLunch() {
		Starters s1=new VegRoll();
		s1.name="PanneerRool";
		MainCourse m=new SouthIndian();
		m.name="Rice";
		Dessert d=new Icecream();
		d.name="StarwBerry";
		Lunch l=new Lunch(s1,m,d);
		return l;
	}
	public Lunch createNorthIndianLunch() {
		Starters s1=new Soup();
		s1.name="MushroomSoup";
		MainCourse m=new NorthIndian();
		m.name="Chappathi";
		Dessert d=new Sweets();
		d.name="GulabJamun";
		Lunch l=new Lunch(s1,m,d);
		return l;
	}
		
	
	public Lunch createChineseLunch() {
		Starters s1=new VegRoll();
		s1.name="SpringRoll";
		MainCourse m=new Chinese();
		m.name="Noodles";
		Dessert d=new Icecream();
		d.name="Snake";
		Lunch l=new Lunch(s1,m,d);
		return l;
	}
}
