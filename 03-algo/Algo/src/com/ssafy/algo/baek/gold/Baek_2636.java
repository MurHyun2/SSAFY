package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2636 {

	static int N, M, cnt;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine().trim());

			for (int c = 0; c < M; c++) {
				// 외각 부분일시 공기로 취급
				if (r == 0 || c == 0 || r == N - 1 || c == M - 1) {
					st.nextToken();
					arr[r][c] = 2;
				} else
					arr[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		int day = 0;
		int lastCheese = 0;

		while (true) {
			visited = new boolean[N][M];
			int check = 0;

			// bfs를 통해 공기를 계산
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (arr[r][c] == 2)
						check++;

					if (arr[r][c] == 2 && !visited[r][c]) {
						bfs(r, c);
					}

				}
			}

			// 치즈가 전부 녹았다면 종료
			if (check == N * M) {
				System.out.println(day);
				System.out.println(lastCheese);
				return;
			}

			// 녹을 치즈를 Queue에 담아서 처리
			Queue<int[]> q = new LinkedList<int[]>();

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (arr[r][c] == 2) {
						for (int i = 0; i < 4; i++) {
							int nr = r + dr[i];
							int nc = c + dc[i];

							if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || arr[nr][nc] != 1)
								continue;

							visited[nr][nc] = true;
							q.add(new int[] { nr, nc });
						}
					}

				}
			}

			lastCheese = q.size();

			while (!q.isEmpty()) {
				int[] now = q.poll();
				int r = now[0];
				int c = now[1];
				arr[r][c] = 2;
			}

			day++;

		}
	}

	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || arr[nr][nc] != 0)
					continue;

				arr[nr][nc] = 2;
				visited[nr][nc] = true;
				q.add(new int[] { nr, nc });
			}
		}
	}
}
