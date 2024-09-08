package com.ssafy.algo.swea.imitation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1949 {

	static int N, K, max, highest;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			visited = new boolean[N][N];
			highest = 0;

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
					highest = Math.max(highest, arr[r][c]);
				}
			}

			max = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (highest == arr[r][c])
						dfs(r, c, highest, 1, true);
				}
			}

			sb.append("#" + tc + " " + max);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int r, int c, int h, int depth, boolean cuttable) {
		visited[r][c] = true;
		max = Math.max(max, depth);

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
				continue;

			if (arr[nr][nc] < h)
				dfs(nr, nc, arr[nr][nc], depth + 1, cuttable);
			else if (cuttable && arr[nr][nc] - K < h) {
				int tmp = arr[nr][nc];
				arr[nr][nc] = h - 1;
				dfs(nr, nc, arr[nr][nc], depth + 1, false);
				arr[nr][nc] = tmp;
			}
		}

		visited[r][c] = false;

	}
}
