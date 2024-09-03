package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_7562 {

	static int L, R, C;
	static int[][] arr;
	static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 0; tc < T; tc++) {
			L = Integer.parseInt(br.readLine().trim());
			arr = new int[L][L];
			visited = new boolean[L][L];

			st = new StringTokenizer(br.readLine().trim());

			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine().trim());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			bfs(startR, startC);

			System.out.println(arr[R][C]);
		}

	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			if (now[0] == R && now[1] == C)
				return;

			for (int i = 0; i < 8; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if (nr >= 0 && nc >= 0 && nr < L && nc < L && !visited[nr][nc] && arr[nr][nc] == 0) {
					q.add(new int[] { nr, nc });
					arr[nr][nc] = arr[now[0]][now[1]] + 1;
					visited[nr][nc] = true;
				}
			}
		}
	}
}
