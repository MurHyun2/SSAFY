package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_1600 {

	static int K, W, H, cnt;
	static int[][] arr;
	static boolean[][][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] knightR = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] knightC = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine().trim());

		st = new StringTokenizer(br.readLine().trim());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][W];
		visited = new boolean[H][W][K + 1];
		
		if(W == 1 && H == 1) {
			System.out.println(0);
			return;
		}

		for (int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine().trim());

			for (int c = 0; c < W; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 입력 끝

		bfs();

		System.out.println(cnt == 0 ? -1 : cnt);
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { 0, 0, K, 0 });
		visited[0][0][K] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			int skill = now[2];
			int time = now[3];

			if (r == H - 1 && c == W - 1) {
				cnt = time;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nc < 0 || nr >= H || nc >= W || arr[nr][nc] == 1 || visited[nr][nc][skill])
					continue;

				visited[nr][nc][skill] = true;
				q.add(new int[] { nr, nc, skill, time + 1 });
			}

			if (skill > 0) {
				for (int j = 0; j < 8; j++) {
					int nr = r + knightR[j];
					int nc = c + knightC[j];

					if (nr < 0 || nc < 0 || nr >= H || nc >= W || arr[nr][nc] == 1 || arr[nr][nc] == 1
							|| visited[nr][nc][skill - 1])
						continue;

					visited[nr][nc][skill - 1] = true;
					q.add(new int[] { nr, nc, skill - 1, time + 1 });
				}
			}
		}
	}
}
