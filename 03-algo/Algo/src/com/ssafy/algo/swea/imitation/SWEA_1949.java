package com.ssafy.algo.swea.imitation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1949 {

	static int N, K, max, maxH;
	static int[][] arr;
	static boolean[][] visited;
	static StringBuilder sb;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			visited = new boolean[N][N];
			max = 0;
			maxH = 0;

			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int c = 0; c < N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
					maxH = Math.max(maxH, arr[r][c]);
				}
			}
			// 입력 끝

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (maxH == arr[r][c]) {
						work(r, c, arr[r][c], 1, true);
					}
				}
			}

			sb.append("#" + tc + " " + max);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void work(int r, int c, int h, int dist, boolean skill) {
		if (dist > max)
			max = dist;
		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
				int nh = arr[nr][nc];

				if (h > nh) {
					work(nr, nc, nh, dist + 1, skill);
				} else if (skill && arr[r][c] > nh - K) {
					work(nr, nc, nh - 1, dist + 1, false);
				}
			}
		}

		visited[r][c] = false;
	}
}
