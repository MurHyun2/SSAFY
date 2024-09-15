package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek_5430 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < T; i++) {
			String str = br.readLine().trim();

			int N = Integer.parseInt(br.readLine().trim());

			String input = br.readLine();
			input = input.substring(1, input.length() - 1);

			Deque<Integer> deque = new ArrayDeque<>();

			if (N > 0) {
				String[] strs = input.split(",");

				for (String num : strs)
					deque.add(Integer.parseInt(num));
			}
			// 입력 끝

			boolean isReversed = false;
			boolean isError = false;

			String[] alps = str.split("");

			for (String alp : alps) {
				switch (alp) {
				case "R": {
					isReversed = !isReversed;
					break;
				}
				case "D": {
					if (deque.isEmpty())
						isError = true;
					else {
						if (isReversed)
							deque.pollLast();
						else
							deque.pollFirst();
					}
					break;
				}
				}
			}
			if (isError) {
				sb.append("error").append("\n");
				continue;
			} else {
				sb.append("[");

				while (!deque.isEmpty()) {
					if (isReversed) {
						sb.append(deque.pollLast());
					} else {
						sb.append(deque.pollFirst());
					}

					if (!deque.isEmpty()) {
						sb.append(",");
					}
				}

				sb.append("]").append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
