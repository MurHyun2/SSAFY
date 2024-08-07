package com.ssafy.algo.beak.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_17413_ReTry {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		Stack<Character> stack = new Stack<>();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '<') {
				while (!stack.isEmpty())
					sb.append(stack.pop());

				while (input.charAt(i) != '>') {
					sb.append(input.charAt(i));
					i++;
				}

				sb.append(input.charAt(i));
			} else if (input.charAt(i) == ' ') {
				while (!stack.isEmpty())
					sb.append(stack.pop());

				sb.append(' ');
			} else {
				stack.push(input.charAt(i));
			}
		}

		while (!stack.isEmpty())
			sb.append(stack.pop());

		System.out.println(sb);
	}
}