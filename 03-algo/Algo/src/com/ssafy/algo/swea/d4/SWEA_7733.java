package com.ssafy.algo.swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_7733 {

	static int N, max;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/7733.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[N][N];
			visited = new boolean[N][N];
			max = 0;

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력 끝

			for (int i = 0; i < 101; i++) {
				visited = new boolean[N][N];
				int sum = 0;

				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (arr[r][c] > i && !visited[r][c]) {
							bfs(r, c, i);
							sum++;
						}
					}
				}

				max = Math.max(max, sum);
			}

			sb.append("#").append(tc).append(" ").append(max);
			sb.append("\n");
		} // tc 끝
		
		System.out.println(sb);
	}

	private static void bfs(int x, int y, int day) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && arr[nr][nc] > day) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}
		}
	}
}