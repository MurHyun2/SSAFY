package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_21736 {

	static int N, M;
	static String[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static String result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new String[N][M];
		visited = new boolean[N][M];

		int x = 0, y = 0;

		for (int r = 0; r < N; r++) {
			String str[] = br.readLine().split("");

			for (int c = 0; c < M; c++) {
				arr[r][c] = str[c];

				if (arr[r][c].equals("I")) {
					x = r;
					y = c;
				}
			}
		}

		result = "TT";

		bfs(x, y);

		System.out.println(result);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		visited[x][y] = true;
		int cnt = 0;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || arr[nr][nc].equals("X"))
					continue;

				if (arr[nr][nc].equals("P"))
					cnt++;
				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}

		if (cnt > 0)
			result = Integer.toString(cnt);
	}
}