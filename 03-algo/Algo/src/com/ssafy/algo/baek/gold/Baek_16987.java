package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_16987 {

	static int N, max;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		// 입력 끝w

		max = 0;

		dfs(0, 0);

		System.out.println(max);
	}

	private static void dfs(int depth, int cnt) {
		if (cnt == N - 1 || depth == N) {
			max = Math.max(max, cnt);
			return;
		}

		if (arr[depth][0] <= 0) {
			dfs(depth + 1, cnt);
		} else {
			for (int i = 0; i < N; i++) {
				if (i == depth)
					continue;

				if (arr[i][0] > 0) {
					arr[i][0] -= arr[depth][1];
					arr[depth][0] -= arr[i][1];
					dfs(depth + 1, cnt + (arr[i][0] > 0 ? 0 : 1) + (arr[depth][0] > 0 ? 0 : 1));
					arr[i][0] += arr[depth][1];
					arr[depth][0] += arr[i][1];
				}
			}
		}
	}
}
