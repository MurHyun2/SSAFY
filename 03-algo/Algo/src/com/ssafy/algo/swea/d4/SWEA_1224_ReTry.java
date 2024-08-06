package com.ssafy.algo.swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SWEA_1224_ReTry {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1224.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 10; i++) {
			int T = Integer.parseInt(br.readLine());

			char[] arr = br.readLine().toCharArray();

			String getPostfix = getPostfix(arr);
			int result = sumPostfix(getPostfix);

			System.out.println(getPostfix);
			System.out.printf("#%d %s\n", i, result);
		}
	}

	static Map<Character, Integer> map = new HashMap<>();

	static {
		map.put('+', 1);
		map.put('*', 2);
	}

	static String getPostfix(char[] arr) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];

			if (c >= '0' && c <= '9') {
				sb.append(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				char popItem = stack.pop();
				
				while(popItem != '(') {
					sb.append(popItem);
					popItem = stack.pop();
				}
			} else {
				while(!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(c)) {
					sb.append(stack.pop());
				}
				stack.push(c);
			}

		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

	static int sumPostfix(String str) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c >= '0' && c <= '9')
				stack.push(c - '0');
			else if (c == '+')
				stack.push(stack.pop() + stack.pop());
			else if (c == '*')
				stack.push(stack.pop() * stack.pop());
		}

		return stack.pop();
	}
}
