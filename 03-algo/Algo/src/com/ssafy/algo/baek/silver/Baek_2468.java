package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2468 {

	static int N;
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N][N];
		int maxHeight = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] > maxHeight)
					maxHeight = arr[i][j];
			}
		}

		int maxCom = 1;

		for (int h = 1; h < maxHeight; h++) {
			int cnt = 0;
			visited = new boolean[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!visited[r][c] && arr[r][c] > h) {
						bfs(r, c, h);
						cnt++;
					}
				}
			}

			maxCom = Math.max(maxCom, cnt);
		}

		System.out.println(maxCom);
	}

	static void bfs(int r, int c, int height) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc] && arr[nr][nc] > height) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}
		}
	}

}
