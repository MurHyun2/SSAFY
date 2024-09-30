package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_14501 {

	static int T;
	static int[] days, cost;
	static int dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine().trim());

		days = new int[T + 1];
		cost = new int[T + 1];
		dp = new int[T + 1];

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine().trim());

			days[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		} // 입력 끝

		System.out.println(dp[T]);
	}
}
