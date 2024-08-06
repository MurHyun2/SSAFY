package com.ssafy.algo.swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1222 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1222.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 10; i++) {
			int T = Integer.parseInt(br.readLine());

			String str = br.readLine();

			String getPostfix = getPostfix(str);
			int result = sumPostfix(getPostfix);

			System.out.printf("#%d %d\n", i, result);
		}
	}

	static String getPostfix(String str) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (c >= '0' && c <= '9')
				sb.append(c);
			else if (stack.isEmpty() && c == '+')
				stack.push(c);
			else
				sb.append(c);
		}

		sb.append(stack.pop());

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
