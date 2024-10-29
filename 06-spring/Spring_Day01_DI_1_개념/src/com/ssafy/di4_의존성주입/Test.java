package com.ssafy.di4_의존성주입;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Desktop desktop = new Desktop();
		Laptop laptop = new Laptop();

		Programmer p = new Programmer();
		p.setComputer(laptop);
		p.coding();
		
		p.setComputer(desktop);
		p.coding();
		
		Scanner sc = new Scanner(System.in);
		Programmer p2 = new Programmer();
		
		while(true) {
			p2.setComputer(ComputerFactory.getComputer(sc.next()));
			p2.coding();
		}
	}
}
