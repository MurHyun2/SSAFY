package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_9095 {

	static int[] nums;
	static int[] dp;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		nums = new int[T];
		int max = 0;

		for (int i = 0; i < T; i++) {
			nums[i] = Integer.parseInt(br.readLine().trim());
			max = Math.max(max, nums[i]);
		}

		dp = new int[max + 1];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for (int i = 4; i <= max; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}

		for (int i : nums) {
			System.out.println(dp[i]);
		}
	}
}
