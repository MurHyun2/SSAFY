package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_7569_2 {

	static int M, N, H;
	static int[][][] arr;
	static int day, check = 0;
	static Queue<int[]> queue = new LinkedList<>();

	static int[] dh = { 1, -1, 0, 0, 0, 0 };
	static int[] dr = { 0, 0, 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 0, 0, 1, -1 };

	static void bfs() {
		if (check != 0) {
			while (!queue.isEmpty()) {
				int[] now = queue.poll();
				int h = now[0];
				int r = now[1];
				int c = now[2];
				int d = now[3];

				for (int i = 0; i < 6; i++) {
					int nh = h + dh[i];
					int nr = r + dr[i];
					int nc = c + dc[i];

					if (nh >= 0 && nh < H && nr >= 0 && nr < N && nc >= 0 && nc < M && arr[nh][nr][nc] == 0) {
						arr[nh][nr][nc] = 1;

						queue.add(new int[] { nh, nr, nc, d + 1 });
						day = d + 1;
					}
				}
			}

			for (int h = 0; h < H; h++) {
				for (int x = 0; x < N; x++) {
					for (int y = 0; y < M; y++) {
						if (arr[h][x][y] == 0) {
							System.out.println(-1);
							return;
						}
					}
				}
			}

		}
		System.out.println(day);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		arr = new int[H][N][M];

		for (int h = 0; h < H; h++) {
			for (int x = 0; x < N; x++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int y = 0; y < M; y++) {
					arr[h][x][y] = Integer.parseInt(st.nextToken());

					if (arr[h][x][y] == 1)
						queue.add(new int[] { h, x, y, day });
					if (arr[h][x][y] == 0)
						check++;
				}
			}
		}

		bfs();
	}
}
