package com.ssafy.class1;

public class Test06_ClassType {
	public static void main(String[] args) {
		Member mem = new Member("이대현", 26);
		mem.print();
		
		Member mem2 = mem;
		mem2.print();
		
		mem.age = 100;
		mem.name = "Hong";
		
		mem.print();
		mem2.print();
	}
}
