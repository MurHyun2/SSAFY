package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2293 {

	static int N, K;
	static int[] dp, coins;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K + 1];
		coins = new int[N];

		for (int i = 0; i < N; i++)
			coins[i] = Integer.parseInt(br.readLine().trim());
		// 입력 끝

		dp[0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j - coins[i] < 0)
					continue;

				dp[j] += dp[j - coins[i]];
			}
		}

		System.out.println(dp[K]);
	}
}
