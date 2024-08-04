package com.ssafy.algo.beak.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10163 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		int[][] map = new int[1001][1001];

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());

			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());

			for (int r = sr; r < sr + er; r++) {
				for (int c = sc; c < sc + ec; c++) {
					map[r][c] = i;
				}
			}
		}
		
		for (int j = 1; j <= T; j++) {
			int count = 0;

			for (int[] js : map) {
				for (int js2 : js) {
					if (js2 == j)
						count++;
				}
			}

			System.out.println(count);
		}
	}
}
