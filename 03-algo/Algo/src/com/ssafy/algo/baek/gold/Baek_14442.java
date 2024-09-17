package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_14442 {

	static int N, M, K, min;
	static int[][] arr;
	static boolean[][][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M][K + 1];

		for (int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			char[] ch = str.toCharArray();

			for (int j = 0; j < M; j++) {
				arr[i][j] = ch[j] - '0';
			}
		}
		// 입력 끝

		min = 0;

		bfs();

		System.out.println(min == 0 ? -1 : min);
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0, K, 1 });
		visited[0][0][K] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			int skill = now[2];
			int time = now[3];

			if (r == N - 1 && c == M - 1) {
				min = time;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;

				if (arr[nr][nc] == 1 && skill == 0)
					continue;

				if (arr[nr][nc] == 1 && !visited[nr][nc][skill - 1]) {
					visited[nr][nc][skill - 1] = true;
					q.add(new int[] { nr, nc, skill - 1, time + 1 });
				}

				if (arr[nr][nc] != 1 && !visited[nr][nc][skill]) {
					visited[nr][nc][skill] = true;
					q.add(new int[] { nr, nc, skill, time + 1 });
				}
			}
		}
	}
}
