package com.ssafy.algo.swea.imitation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1767_ReTry {

	static int N, min;
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1767.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine().trim());
			arr = new int[N][N];

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());

				}
			}

			min = Integer.MAX_VALUE;

			for (int x = 1; x < N - 1; x++) {
				for (int y = 1; y < N - 1; y++) {
//					if (x != 0 && y != 0 && x != N - 1 && y != N - 1 && arr[x][y] == 1) {
					
					if(arr[x][y] == 1) {
						bfs(1, 1, 0);
					}
				}
			}

			System.out.println(min);
		}
	}

	private static void bfs(int r, int c, int sum) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c, sum });

		while (!q.isEmpty()) {
			int[] now = q.poll();

			int x = now[0];
			int y = now[1];

			if (x == N - 2 && x == N - 2) {
				min = Math.min(sum, min);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];

				if (nr >= 0 && nc >= 0 && nr < N && nc < N && arr[nr][nc] == 0) {
					q.add(new int[] { nr, nc, sum + 1 });
					arr[nr][nc] = 2;
				}
			}
		}

	}

}
