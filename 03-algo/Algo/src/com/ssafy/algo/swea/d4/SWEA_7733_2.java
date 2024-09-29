package com.ssafy.algo.swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7733_2 {

	static int N, max;
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/7733.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[N][N];
			int minday = Integer.MAX_VALUE;
			int maxday = 0;

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());

					minday = Math.min(minday, arr[r][c]);
					maxday = Math.max(maxday, arr[r][c]);
				}

			}

			max = 1;

			for (int day = minday; day <= maxday; day++) {
				visited = new boolean[N][N];
				int pieces = 0;

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (arr[r][c] > day && !visited[r][c]) {
							bfs(r, c, day);
							pieces++;
						}
					}
				}

				max = Math.max(max, pieces);
			}

			System.out.printf("#%d %d\n", tc, max);
		}
	}

	private static void bfs(int r, int c, int day) {
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

				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || arr[nr][nc] <= day)
					continue;

				visited[nr][nc] = true;
				q.add(new int[] { nr, nc });
			}
		}
	}
}