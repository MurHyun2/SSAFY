package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_9084 {

	static int N, M;
	static int[] dp, coins;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			coins = new int[N];

			st = new StringTokenizer(br.readLine().trim());

			for (int i = 0; i < N; i++) {
				coins[i] = Integer.parseInt(st.nextToken());
			}

			M = Integer.parseInt(br.readLine().trim());
			dp = new int[M + 1];
			// 입력 끝

			dp[0] = 1;

			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= M; j++) {
					if (j - coins[i] < 0)
						continue;

					dp[j] += dp[j - coins[i]];
				}
			}

			sb.append(dp[M]).append("\n");
		} // tc 끝

		System.out.println(sb.toString());
	}
}
