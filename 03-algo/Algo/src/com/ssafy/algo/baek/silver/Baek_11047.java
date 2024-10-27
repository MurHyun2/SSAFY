package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_11047 {

	static int N, K;
	static int coins[];
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coins = new int[N];
		result = 0;

		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine().trim());
		}

		min();

		System.out.println(result);
	}

	private static void min() {
		for (int i = N - 1; i >= 0; i--) {
			while (coins[i] <= K) {
				K -= coins[i];
				result++;
			}
		}
	}
}
