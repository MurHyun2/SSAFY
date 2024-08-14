package com.ssafy.algo.beak.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2615 {

	static int[][] arr;

	static int[] dx = { 0, 1, 1, -1 };
	static int[] dy = { 1, 1, 0, 1 };

	static void calFive() {
		for (int r = 1; r < 20; r++) {
			for (int c = 1; c < 20; c++) {
				if (arr[r][c] != 0) {
					int now = arr[r][c];

					for (int i = 0; i < 4; i++) {
						int nr = r + dx[i];
						int nc = c + dy[i];
						int count = 1;

						while (nr >= 1 && nr < 20 && nc >= 1 && nc < 20 && arr[nr][nc] == now) {
							count++;
							nr += dx[i];
							nc += dy[i];
						}

						if (count == 5) {
							nr = r - dx[i];
							nc = c - dy[i];

							if (nr >= 1 && nr < 20 && nc >= 1 && nc < 20 && arr[nr][nc] == now)
								continue;
						}
						if (count == 5) {
							System.out.println(now);
							System.out.println(r + " " + c);
							return;
						}
					}

				}
			}

		}
		
		System.out.println(0);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[20][20];

		for (int i = 1; i < 20; i++) {
			st = new StringTokenizer(br.readLine().trim());

			for (int j = 1; j < 20; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
		}

		calFive();
	}
}
