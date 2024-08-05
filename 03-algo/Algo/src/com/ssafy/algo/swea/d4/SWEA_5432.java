package com.ssafy.algo.swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_5432 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/5432.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			String str = br.readLine();
			str = str.replace("()", "!");
			int count = 0;
			char[] cArr = str.toCharArray();

			Stack<Character> stack = new Stack<>();

			for (int j = 0; j < str.length(); j++) {
				char c = cArr[j];
				
				if (c == '(') {
					stack.push(c);
				} else if (!stack.isEmpty() && c == '!') {
					count += stack.size();
				} else if (c == ')') {
					stack.pop();
					count++;
				}
			}

			System.out.println("#" + i + " " + count);
		}
	}
}
