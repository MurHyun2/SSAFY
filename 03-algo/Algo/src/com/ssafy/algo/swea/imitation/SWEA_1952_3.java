package com.ssafy.algo.swea.imitation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952_3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			int[] costs = new int[4];
			int[] months = new int[13];
			int[] dp = new int[13];

			st = new StringTokenizer(br.readLine().trim());

			for (int i = 0; i < 4; i++)
				costs[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine().trim());

			for (int i = 1; i < 13; i++)
				months[i] = Integer.parseInt(st.nextToken());
			// 입력 끝

			// 1달 기준 최솟값 업데이트
			for (int i = 1; i < 13; i++) {
				// 1일 이용권 vs 1달 이용권
				dp[i] = dp[i - 1] + Math.min(months[i] * costs[0], costs[1]);

				// 3달 이용권 비교
				if (i >= 3) {
					dp[i] = Math.min(dp[i], dp[i - 3] + costs[2]);
				}
			}

			// 1년 이용권 비교
			int result = Math.min(dp[12], costs[3]);

			System.out.printf("#%d %d\n", tc, result);
		}

	}
}
