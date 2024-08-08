package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());

		for (int i = 1; i <= T; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			int[][] arr = new int[n][n];

			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine().trim());
				char[] c = st.nextToken().toCharArray();

				for (int k = 0; k < n; k++) {
					arr[j][k] = c[k] - '0';
				}
			}
			// 입력

			int r = n / 2;
			int sum = 0;

			for (int j = 0; j <= r; j++) {
				for (int k = r - j; k <= r + j; k++) {
					sum += arr[j][k];
				}
			}

			int idx = 1;

			for (int j = r + 1; j < n; j++) {
				for (int k = idx; k <= n - 1 - idx; k++) {
					sum += arr[j][k];
				}
				idx++;
			}

			System.out.println("#" + i + " " + sum);
		}
	}
}
