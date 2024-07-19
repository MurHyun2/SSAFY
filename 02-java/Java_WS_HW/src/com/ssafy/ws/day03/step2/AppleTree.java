package com.ssafy.ws.day03.step2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AppleTree {

	public static void main(String[] args) throws NumberFormatException, IOException {
		FileInputStream f1 = new FileInputStream("data/AppleTree.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(f1));

		int T = Integer.parseInt(br.readLine());
		int[][] map = new int[T][T];

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < T; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				int sum = map[i][j];

				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if (nr >= 0 && nr < map.length && nc >= 0 && nc < map.length) {
						sum += map[nr][nc];

						if (result < sum)
							result = sum;
					}
				}
			}
		}
		System.out.println(result);
	}
}
