package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2573 {

	static int N, M, days;
	static boolean find;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine().trim());

			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 끝

		days = 0;
		find = false;

		while (!find) {
			findIceberg();

			if (!find) {
				visited = new boolean[N][M];

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < M; c++) {
						if (arr[r][c] != 0) {
							meltingIceberg(r, c);
							visited[r][c] = true;
						}
					}
				}
				
			}
		}

		System.out.println(days);
	}

	private static void meltingIceberg(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || arr[nr][nc] != 0)
				continue;

			if (arr[r][c] != 0)
				arr[r][c]--;
		}
	}

	private static void findIceberg() {
		int lump = 0;
		visited = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (arr[r][c] != 0 && !visited[r][c]) {
					findLump(r, c);
					lump++;

					if (lump >= 2) {
						find = true;
						return;
					}
				}
			}
		}

		if (lump == 0) {
			days = 0;
			find = true;
			return;
		}

		days++;
	}

	private static void findLump(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			for (int i = 0; i < 4; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || arr[nr][nc] == 0)
					continue;

				visited[nr][nc] = true;
				q.add(new int[] { nr, nc });
			}
		}
	}
}