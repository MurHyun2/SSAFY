package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek_10773 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine().trim());

		Stack<Integer> stack = new Stack<>();
		int sum = 0;

		for (int i = 0; i < K; i++) {
			int input = Integer.parseInt(br.readLine().trim());

			if (input == 0)
				stack.pop();
			else
				stack.add(input);
		}

		for (Integer i : stack)
			sum += i;
		
		System.out.println(sum);
	}
}
