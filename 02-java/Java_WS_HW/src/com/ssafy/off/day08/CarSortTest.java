package com.ssafy.off.day08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Car implements Comparable<Car> {
	String name;
	int price;

	public Car(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Car car) {
		return this.name.compareTo(car.name);
	}
}

class CarPriceComp implements Comparator<Car> {

	@Override
	public int compare(Car o1, Car o2) {
		return (o1.price - o2.price) * -1;
	}
}

public class CarSortTest {
	public static void main(String[] args) {
		Car c1 = new Car("aGv80", 5000);
		Car c4 = new Car("dk5", 2000);
		Car c3 = new Car("bK7", 3000);
		Car c2 = new Car("cGv70", 4000);

		List<Car> list = new ArrayList<>();

		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);

//		Collections.sort(list, new CarPriceComp());
		Collections.sort(list, (o1, o2) -> Integer.compare(o1.price, o2.price));
		

		for (Car car : list) {
			System.out.println(car);
		}

	}
}
