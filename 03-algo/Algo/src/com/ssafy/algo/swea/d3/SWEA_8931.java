package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_8931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/8931.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int K = Integer.parseInt(br.readLine());

			Stack<Integer> stack = new Stack<>();
			
			for (int j = 0; j < K; j++) {
				int input = Integer.parseInt(br.readLine());

				if (input == 0)
					stack.pop();
				else
					stack.push(input);
			}
			
			int sum = 0;
			
			for (Integer integer : stack) {
				sum += integer;
			}
			
			System.out.println("#" + i + " " + sum);
		}
	}
}
