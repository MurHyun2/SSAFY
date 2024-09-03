package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2178_2 {

	static int N, M;
	static int[][] arr;
	static Queue<int[]> q = new LinkedList<>();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];

		for (int r = 0; r < N; r++) {
			String str = br.readLine().trim();
			char[] cs = str.toCharArray();

			for (int c = 0; c < M; c++) {
				arr[r][c] = cs[c] - '0';
			}
		}
		// 입력 끝

		bfs(0, 0);

		System.out.println(arr[N - 1][M - 1]);
	}

	private static void bfs(int r, int c) {
		q.add(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && arr[nr][nc] != 0) {
					q.add(new int[] { nr, nc });
					arr[nr][nc] = arr[now[0]][now[1]] + 1;
					visited[nr][nc] = true;
				}
			}
		}
	}
}
