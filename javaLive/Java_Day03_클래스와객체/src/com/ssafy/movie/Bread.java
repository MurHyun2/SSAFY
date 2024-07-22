package com.ssafy.movie;

public class Bread {
	String name;
	int price;
	int cal;

	public Bread() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bread(String name, int price, int cal) {
		this.name = name;
		this.price = price;
		this.cal = cal;
	}

	@Override
	public String toString() {
		return "Bread [name=" + name + ", price=" + price + ", cal=" + cal + "]";
	}

}
