package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_17471_2 {

	static int N, min;
	static int[] counts;
	static int[][] adj;
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine().trim());
		adj = new int[N + 1][N + 1];
		counts = new int[N + 1];
		selected = new boolean[N + 1];

		st = new StringTokenizer(br.readLine().trim());

		for (int i = 1; i <= N; i++) {
			counts[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int cnt = Integer.parseInt(st.nextToken());

			for (int j = 0; j < cnt; j++) {
				int input = Integer.parseInt(st.nextToken());
				adj[i][input] = adj[input][i] = 1;
			}
		} // 입력 끝

		min = Integer.MAX_VALUE;

		for (int i = 1; i < (1 << N); i++) {
			Arrays.fill(selected, false);

			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					selected[j] = true;
				}
			}

			if (isCon(true) && isCon(false)) {
				int sumA = 0;
				int sumB = 0;

				for (int j = 1; j <= N; j++) {
					if (selected[j])
						sumA += counts[j];
					else
						sumB += counts[j];
				}

				min = Math.min(min, Math.abs(sumA - sumB));
			}
		}

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	private static boolean isCon(boolean group) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			if (selected[i] == group) {
				q.offer(i);
				visited[i] = true;
				break;
			}
		}

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 1; i <= N; i++) {
				if (adj[now][i] == 0 || visited[i] || selected[i] != group)
					continue;

				q.offer(i);
				visited[i] = true;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (selected[i] == group && !visited[i])
				return false;
		}

		return true;
	}
}
