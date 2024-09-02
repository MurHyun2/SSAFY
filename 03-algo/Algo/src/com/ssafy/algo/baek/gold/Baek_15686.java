package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_15686 {

	static class loc {
		int x, y;

		public loc(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, min;
	static int[][] arr;
	static List<loc> chicken = new ArrayList<>();
	static List<loc> house = new ArrayList<>();
	static boolean[] open;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine().trim());

			for (int c = 0; c < N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());

				if (arr[r][c] == 1) {
					house.add(new loc(r, c));
				} else if (arr[r][c] == 2) {
					chicken.add(new loc(r, c));
				}
			}
		}
		// 입력 끝

		min = Integer.MAX_VALUE;
		open = new boolean[chicken.size()];

		comb(0, 0);

		System.out.println(min);
	}

	private static void comb(int now, int depth) {
		if (depth == M) {
			int sum = 0;

			for (int i = 0; i < house.size(); i++) {
				int minDis = Integer.MAX_VALUE;

				for (int j = 0; j < chicken.size(); j++) {
					if (open[j]) {
						int dis = Math.abs(house.get(i).x - chicken.get(j).x)
								+ Math.abs(house.get(i).y - chicken.get(j).y);

						minDis = Math.min(minDis, dis);
					}
				}

				sum += minDis;
			}

			min = Math.min(min, sum);
			return;
		}

		for (int i = now; i < chicken.size(); i++) {
			open[i] = true;
			comb(i + 1, depth + 1);
			open[i] = false;
		}
	}
}