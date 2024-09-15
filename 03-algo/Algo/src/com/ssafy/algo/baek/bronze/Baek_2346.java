package com.ssafy.algo.baek.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_2346 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int space = 0;
		int re = (N * 2) - 1;

		for (int i = 1; i <= N; i++) {
			System.out.println(repeat(" ", space) + repeat("*", re));
			space++;
			re -= 2;
		}

		re = 3;
		space = N - 2;

		for (int i = 2; i <= N; i++) {
			System.out.println(repeat(" ", space) + repeat("*", re));
			space--;
			re += 2;
		}
	}

	private static String repeat(String str, int num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num; i++) {
			sb.append(str);
		}

		return sb.toString();
	}
}
