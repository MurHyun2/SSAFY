package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1941 {

	static int N, cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = 5;
		arr = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();

			for (int j = 0; j < N; j++) {
				if (ch[j] == 'Y')
					arr[i][j] = 1;
			}
		}
		// 입력 끝

		cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					visited[i][j] = true;
					dfs(i, j, 0, 1);
					visited[i][j] = false;
				}
			}
		}

		System.out.println(cnt);
	}

	private static void dfs(int r, int c, int yCnt, int depth) {
		if (yCnt >= 4)
			return;

		if (depth == 7) {
			cnt++;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
				continue;

			visited[nr][nc] = true;
			if (arr[nr][nc] == 0)
				dfs(nr, nc, yCnt, depth + 1);
			else
				dfs(nr, nc, yCnt + 1, depth + 1);
			visited[nr][nc] = false;
		}
	}
}
