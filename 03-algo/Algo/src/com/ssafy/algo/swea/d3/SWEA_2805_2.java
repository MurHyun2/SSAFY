package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class SWEA_2805_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int i = 1; i <= T; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			int[][] arr = new int[n][n];

			for (int j = 0; j < n; j++) {
				String str = br.readLine().trim();
				char[] c = str.toCharArray();

				for (int k = 0; k < n; k++) {
					arr[j][k] = c[k] - '0';
				}
			}
			// 입력
			int sum = 0;

			for (int j = 0; j < arr.length; j++) {
				int range = Math.abs(j - n / 2);
				for (int k = range; k < n - range; k++) {
					sum += arr[j][k];
				}
			}

			System.out.println("#" + i + " " + sum);
		}
	}
}
