package com.ssafy.class1;

public class Test07_Array {
	public static void main(String[] args) {
		
		Member[] arr3 = new Member[2];
		arr3[0] = new Member("hong", 100);
		Member m = arr3[0];
		System.out.println(m.name);
		arr3[0].name = "Wang";
		System.out.println(m.name);
	}
}
