package com.ssafy.barking.x05;

import java.io.IOException;

public class Test_01 {
	
	static int mx = 1000005;
	static int[] dat = new int[mx];
	static int pos = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		test();
	}
	
	static void push(int x) {
		dat[++pos] = x;
	}
	
	static void peek() {
		System.out.println(dat[pos]);
	}
	
	static int pop() {
		return dat[pos--];
	}
	
	static void test() {
		push(1);
		push(3);
		push(5);
		push(7);
		
		peek();
		
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
		System.out.println(pop());
	}
}
