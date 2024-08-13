package com.ssafy.algo.beak.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_7569_2 {

	static int M, N, H;
	static int[][][] arr;
	static int day;
	static Queue<Node> queue = new LinkedList<>();

	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, 1, -1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, 1, -1 };
	static int maxDay = 0;

	static class Node {
		int h, x, y, day;

		public Node(int h, int x, int y, int day) {
			this.h = h;
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			Node now = queue.poll();

			for (int i = 0; i < 6; i++) {
				int nh = now.h + dh[i];
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nh < 0 || nh >= H || nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (arr[nh][nx][ny] == 1)
					continue;
				if (arr[nh][nx][ny] == -1)
					continue;

				arr[nh][nx][ny] = 1;
				queue.add(new Node(nh, nx, ny, now.day + 1));
				maxDay = now.day + 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		arr = new int[H][N][M];

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int c = 0; c < M; c++) {
					arr[h][r][c] = Integer.parseInt(st.nextToken());

					if (arr[h][r][c] == 1) {
						queue.add(new Node(h, r, c, 0));
					}
				}
			}
		}

		bfs();

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (arr[h][r][c] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}

		System.out.println(maxDay);
	}
}
