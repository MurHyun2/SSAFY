package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2206 {

	static int N, M, min;
	static int[][] arr;
	static boolean[][][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M][2];

		for (int r = 0; r < N; r++) {
			String str = br.readLine().trim();
			char[] ch = str.toCharArray();

			for (int c = 0; c < M; c++) {
				arr[r][c] = ch[c] - '0';
			}
		}
		// 입력 끝

		min = Integer.MAX_VALUE;

		bfs(0, 0, 1, 0);
//		dfs(0, 0, 1, true);

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

//	private static void dfs(int x, int y, int sum, boolean skill) {
//		if (sum >= min)
//			return;
//
//		if (x == N - 1 && y == M - 1) {
//			min = Math.min(min, sum);
//			return;
//		}
//
//		visited[x][y] = true;
//
//		for (int i = 0; i < 4; i++) {
//			int nr = x + dr[i];
//			int nc = y + dc[i];
//
//			if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || arr[nr][nc] == 1 && !skill)
//				continue;
//
//			if (arr[nr][nc] == 1) {
//				visited[nr][nc] = true;
//				dfs(nr, nc, sum + 1, false);
//				visited[nr][nc] = false;
//			} else {
//				visited[nr][nc] = true;
//				dfs(nr, nc, sum + 1, skill);
//				visited[nr][nc] = false;
//			}
//		}
//	}

	private static void bfs(int r, int c, int dist, int skill) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c, dist, skill });
		visited[r][c][skill] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int sum = now[2];
			int sk = now[3];

			if (x == N - 1 && y == M - 1) {
				min = Math.min(min, sum);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (arr[nr][nc] == 1 && sk == 0 && !visited[nr][nc][1]) {
					q.add(new int[] { nr, nc, sum + 1, 1 });
					visited[nr][nc][1] = true;
				}

				if (arr[nr][nc] == 0 && !visited[nr][nc][sk]) {
					q.add(new int[] { nr, nc, sum + 1, sk });
					visited[nr][nc][sk] = true;
				}
			}
		}
	}

}
