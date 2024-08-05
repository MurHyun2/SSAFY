package com.ssafy.live.day05;

import java.util.Stack;

public class Stack_스택의구현 {

	static String[] stack = new String[100];
	static int top = -1;

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();

		stack.push("cat");
		stack.push("dog");
		stack.push("mouse");

		for (int i = 0; i < 3; i++) {
			System.out.println(stack.pop());
		}

	}

	static boolean isEmpty() {
//		if (top == -1)
//			return true;
//		return false;
		return top == -1;
	}
	
	static boolean isFull() {
		return top == stack.length - 1;
	}
	
	static void push(String item) {
		if(!isFull())
			stack[++top] = item;
	}
	
	static String pop() {
		if(isEmpty())
			return null;
		return stack[top--];
	}
}
