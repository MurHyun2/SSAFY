package com.ssafy.algo.swea.imitation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952_2 {

	static int min;
	static int[] cost, month;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			cost = new int[4];
			month = new int[13];

			st = new StringTokenizer(br.readLine().trim());

			for (int i = 0; i < 4; i++)
				cost[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine().trim());

			for (int i = 1; i <= 12; i++)
				month[i] = Integer.parseInt(st.nextToken());
			// 입력 끝

			min = cost[3];

			dfs(1, 0);

			sb.append("#").append(tc).append(" ").append(min);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int mon, int sum) {
		if (sum >= min)
			return;

		if (mon > 12) {
			min = Math.min(min, sum);
			return;
		}
		
		dfs(mon + 1, sum + month[mon] * cost[0]);
		dfs(mon + 1, sum + cost[1]);
		dfs(mon + 3, sum + cost[2]);
	}

}
