package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Baek_1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine().trim());
		Stack<Integer> stack = new Stack<>();
		int num = 1;
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine().trim());

			if (stack.isEmpty()) {
				sb.append("+").append("\n");
				stack.add(num++);
			}

			while (input > stack.peek()) {
				sb.append("+").append("\n");
				stack.add(num++);
			}

			if (input == stack.peek()) {
				sb.append("-").append("\n");
				stack.pop();
				cnt++;
			}
		}

		if (cnt != N) {
			bw.append("NO");
			bw.flush();
			return;
		}

		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
