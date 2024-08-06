package com.ssafy.algo.swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SWEA_1223 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1223.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 10; i++) {
			int T = Integer.parseInt(br.readLine());

			String str = br.readLine();

			String getPostfix = getPostfix(str);
			int result = sumPostfix(getPostfix);

			System.out.printf("#%d %s\n", i, getPostfix);
		}
	}

	static Map<Character, Integer> map = new HashMap<>();

	static {
		map.put('+', 1);
		map.put('*', 2);
	}

	static String getPostfix(String str) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c >= '0' && c <= '9')
				sb.append(c);
			else if (c == '+')
				stack.push(c);
			else if (c == '*')
				stack.push(c);
			else {
				while (!stack.isEmpty() && stack.peek() != '(' && map.get(stack.peek()) >= map.get(c)) {
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
		}

		return stack.pop();
	}
}
