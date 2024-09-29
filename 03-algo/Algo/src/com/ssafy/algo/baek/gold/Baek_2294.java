package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_2294 {

	static int N, K;
	static int[] coins;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coins = new int[N];
		dp = new int[K + 1];

		for (int i = 0; i < N; i++)
			coins[i] = Integer.parseInt(br.readLine().trim());
		// 입력 끝

		Arrays.fill(dp, 100_001);
		dp[0] = 0;
		Arrays.sort(coins);

		for (int i = 1; i <= K; i++) {
			for (int j = 0; j < N; j++) {
				if (i < coins[j])
					continue;
				
				else
					dp[i] = Math.min(dp[i] + 1, dp[i - coins[j]] + 1);
			}
		}

		System.out.println(dp[K] == 100_001 ? -1 : dp[K]);
	}
}
