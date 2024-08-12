package com.ssafy.algo.beak.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_7569 {

	static int M, N, H;
	static int[][][] box;
	static int maxDay = 0;

	static int dh[] = { 0, 0, 0, 0, 1, -1 };
	static int dr[] = { 1, -1, 0, 0, 0, 0 };
	static int dc[] = { 0, 0, 1, -1, 0, 0 };
	static Queue<Node> queue;

	static class Node {
		int h, r, c, count;

		public Node(int h, int r, int c, int count) {
			this.h = h;
			this.r = r;
			this.c = c;
			this.count = count;
		}
	}

	static void bfs() {
		while (!queue.isEmpty()) {
			Node now = queue.poll();

			for (int i = 0; i < 6; i++) {
				int nh = now.h + dh[i];
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];

				if (nh < 0 || nh >= H || nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (box[nh][nr][nc] != 0)
					continue;

				box[nh][nr][nc] = 1;
				queue.add(new Node(nh, nr, nc, now.count + 1));
				maxDay = now.count + 1;

			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[H][N][M];
		queue = new LinkedList<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());

					if (box[i][j][k] == 1) {
						queue.add(new Node(i, j, k, 0));
					}
				}
			}
		}

		// 모든 토마토가 이미 익어있는 경우
		if (queue.size() == H * N * M) {
			System.out.println(0);
			return;
		}
		
		bfs();
		
		for (int z = 0; z < H; z++) {
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					// 익지 않은 토마토가 남아있는 경우
					if(box[z][x][y] == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		
		System.out.println(maxDay);
	}
}
