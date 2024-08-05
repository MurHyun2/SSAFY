package com.ssafy.algo.swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1218_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 10; i++) {
			int T = Integer.parseInt(br.readLine());
			String str = br.readLine();
			char arr[] = str.toCharArray();

			Stack<Character> stack = new Stack<>();
			for (int j = 0; j < arr.length; j++) {
				stack.push(arr[j]);

				if (j > 0) {
					if (arr[j] == ')' && arr[stack.size() - 2] == '(') {
						stack.pop();
						stack.pop();
					} else if (arr[j] == ']' && arr[stack.size() - 2] == '[') {
						stack.pop();
						stack.pop();
					} else if (arr[j] == '}' && arr[stack.size() - 2] == '{') {
						stack.pop();
						stack.pop();
					} else if (arr[j] == '>' && arr[stack.size() - 2] == '<') {
						stack.pop();
						stack.pop();
					}
				}
			}

			int result = 0;

			if (stack.isEmpty())
				result = 1;

			System.out.println("#" + i + " " + result);
		}
	}
}
