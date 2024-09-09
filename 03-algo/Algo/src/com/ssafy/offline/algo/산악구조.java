package com.ssafy.offline.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 산악구조 {

	static int N, min;
	static int[][] arr, fuelCost;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[N + 1][N + 1];
			fuelCost = new int[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int j = 1; j <= N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					fuelCost[i][j] = Integer.MAX_VALUE;
				}
			}

			min = Integer.MAX_VALUE;

			bfs(1, 1, arr[1][1]);

//			visited[1][1] = true;
//			dfs(1, 1, arr[1][1], 0);

			sb.append("#").append(tc).append(" ").append(fuelCost[N][N]);
			sb.append("\n");
		}

		System.out.println(sb);
	}

//	private static void dfs(int r, int c, int h, int fuel) {
//		if (r == N && c == N) {
//			min = Math.min(min, fuel);
//			return;
//		}
//
//		if (fuel >= min)
//			return;
//
//		for (int i = 0; i < 4; i++) {
//			int nr = r + dr[i];
//			int nc = c + dc[i];
//
//			if (nr < 1 || nc < 1 || nr > N || nc > N || visited[nr][nc])
//				continue;
//
//			int nh = arr[nr][nc];
//
//			visited[nr][nc] = true;
//			if (nh < h)
//				dfs(nr, nc, nh, fuel);
//			else if (nh > h) {
//				dfs(nr, nc, nh, fuel + (nh - h) * 2);
//			} else {
//				dfs(nr, nc, nh, fuel + 1);
//			}
//			visited[nr][nc] = false;
//		}
//	}

	private static void bfs(int x, int y, int height) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { x, y, height });
		fuelCost[x][y] = 0;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			int h = now[2];
			int fuel = fuelCost[r][c];
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 1 || nc < 1 || nr > N || nc > N)
					continue;

				int nh = arr[nr][nc];
				int nextFuel = fuel;

				if (nh < h)
					nextFuel += 0;
				else if (nh > h)
					nextFuel += (nh - h) * 2;
				else
					nextFuel += 1;

				if (nextFuel < fuelCost[nr][nc]) {
					fuelCost[nr][nc] = nextFuel;
					q.offer(new int[] { nr, nc, nh });
				}
			}
		}
	}
}