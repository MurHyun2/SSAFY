package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_14502 {

	static int N, M, max, wallCnt;
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		wallCnt = 0;
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());

			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					wallCnt++;
			}
		}
		// 입력 끝

		max = 0;

		dfs(0);

		System.out.println(max);
	}

	private static void dfs(int cnt) {
		if (cnt == 3) {
			int space = (N * M) - (wallCnt + 3) - cntVirus();
			max = Math.max(max, space);
			return;
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (arr[r][c] == 0) {
					arr[r][c] = 1;
					dfs(cnt + 1);
					arr[r][c] = 0;
				}
			}
		}
	}

	private static int cntVirus() {
		int cnt = 0;
		boolean[][] virus = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (arr[r][c] == 2) {
					q.add(new int[] { r, c });
					virus[r][c] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			int[] now = q.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || arr[nr][nc] == 1 || virus[nr][nc]) {
					continue;
				}

				virus[nr][nc] = true;
				q.add(new int[] { nr, nc });
			}
		}

		return cnt;
	}
}
