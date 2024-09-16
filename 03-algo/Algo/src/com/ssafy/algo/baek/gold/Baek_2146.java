package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_2146 {

	static int N, min;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 끝

		int landNum = 2;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (arr[r][c] == 1) {
					landNumbering(r, c, landNum++);
				}
			}
		}
		// 섬 찾기 끝

		min = Integer.MAX_VALUE;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (arr[r][c] >= 2) {
					checkOutskirts(r, c);
				}
			}
		}

		System.out.println(min);
	}

	private static void checkOutskirts(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		visited = new boolean[N][N];
		q.add(new int[] { r, c, arr[r][c], 0 });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int landNum = now[2];
			int blength = now[3];

			if (blength > min)
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
					continue;

				if (arr[nr][nc] != 0 && arr[nr][nc] != landNum) {
					min = Math.min(min, blength);
					return;
				}

				if (arr[nr][nc] == 0) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc, landNum, blength + 1 });
				}
			}
		}
	}

	private static void landNumbering(int r, int c, int landNum) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { r, c, landNum });
		arr[r][c] = landNum;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			for (int i = 0; i < 4; i++) {
				int nr = x + dr[i];
				int nc = y + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N || arr[nr][nc] != 1)
					continue;

				arr[nr][nc] = landNum;
				q.add(new int[] { nr, nc });
			}

		}
	}
}
