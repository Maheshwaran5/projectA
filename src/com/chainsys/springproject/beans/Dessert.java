package com.chainsys.springproject.beans;

public abstract class Dessert {
	public String name;
}
class Icecream extends Dessert{
	public Icecream() {
		name="Vennila";
	}
}
class Sweets extends Dessert{
	public Sweets() {
		name="Laddu";
	}
}
class Cakes extends Dessert{
	public Cakes() {
		name="PlumCake";
	}
	public Cakes(String name) {
		this.name=name;
	}
}