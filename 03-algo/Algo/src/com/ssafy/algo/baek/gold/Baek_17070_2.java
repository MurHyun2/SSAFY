package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_17070_2 {

	static int N, cnt;
	static int[][] arr;
	static int[][][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N][N];
		dp = new int[N][N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

			}
		} // 입력 끝

		// DP(0,1,0) 1로 초기화
		dp[0][1][0] = 1;

		int result = dp();

		System.out.println(result);
	}

	private static int dp() {
		for (int r = 0; r < N; r++) {
			for (int c = 2; c < N; c++) {
				if (arr[r][c] == 1)
					continue;

				dp[r][c][0] = dp[r][c - 1][0] + dp[r][c - 1][2];

				if (r == 0)
					continue;
				dp[r][c][1] = dp[r - 1][c][1] + dp[r - 1][c][2];

				if (arr[r][c - 1] == 1 || arr[r - 1][c] == 1)
					continue;
				dp[r][c][2] = dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2];
			}
		}

		int result = 0;

		for (int i = 0; i < 3; i++) {
			result += dp[N - 1][N - 1][i];
		}

		return result;
	}
}
