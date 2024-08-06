package com.ssafy.algo.swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9490 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/9490.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int k = 0; k < M; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}

			}

			int result = maxFlower(map);

			System.out.printf("#%d %d\n", i, result);
		}
	}

	static int maxFlower(int[][] map) {
		int max = 0;

		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				int cnt = map[r][c];
				int sum = map[r][c];

				for (int i = 1; i <= cnt; i++) {
					int[] dr = { i, -i, 0, 0 };
					int[] dc = { 0, 0, i, -i };

					for (int j = 0; j < 4; j++) {
						int nr = r + dr[j];
						int nc = c + dc[j];

						if (nr >= 0 && nr < map.length && nc >= 0 && nc < map[r].length) {
							sum += map[nr][nc];
						}
					}
				}

				if (max < sum) {
					max = sum;
				}
			}
		}

		return max;
	}
}
