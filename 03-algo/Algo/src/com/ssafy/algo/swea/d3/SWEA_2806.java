package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2806 {

	static int N, cnt;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/2806.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[N];
			cnt = 0;

			Queen(0);

			sb.append("#").append(tc).append(" ").append(cnt);
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static void Queen(int col) {
		if (col == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[col] = i;
			if (check(col)) {
				Queen(col + 1);
			}
		}
	}

	private static boolean check(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i])
				return false;

			if (Math.abs(arr[col] - arr[i]) == Math.abs(col - i))
				return false;
		}

		return true;
	}
}
