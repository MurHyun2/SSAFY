package com.ssafy.algo.swea.imitation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952 {

	static int min;
	static int[] months, cost;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			months = new int[13];
			cost = new int[4];

			st = new StringTokenizer(br.readLine().trim());

			for (int i = 0; i < 4; i++)
				cost[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine().trim());

			for (int i = 1; i <= 12; i++)
				months[i] = Integer.parseInt(st.nextToken());

			min = cost[3];

			dfs(1, 0);

			sb.append("#").append(tc).append(" ").append(min);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int month, int sum) {
		if (sum >= min)
			return;

		if (month > 12) {
			min = Math.min(min, sum);
			return;
		}

		// 1d
		dfs(month + 1, sum + months[month] * cost[0]);

		// 1m
		dfs(month + 1, sum + cost[1]);

		// 3m
		dfs(month + 3, sum + cost[2]);
	}
}
