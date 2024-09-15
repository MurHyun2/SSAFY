package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek_18258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine().trim());

		Deque<Integer> deque = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			String input = br.readLine().trim();

			switch (input) {
			case "pop": {
				if (deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.pollFirst()).append("\n");
				break;
			}
			case "size": {
				sb.append(deque.size()).append("\n");
				break;
			}
			case "empty": {
				if (deque.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
			}
			case "front": {
				if (deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.peekFirst()).append("\n");
				break;
			}
			case "back": {
				if (deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.peekLast()).append("\n");
				break;
			}
			default: {
				int num = Integer.parseInt(input.substring(5));
				deque.addLast(num);
			}
			}
		}

		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
