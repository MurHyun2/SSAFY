package com.ssafy.algo.swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1974 {

	static int[][] arr = new int[9][9];
	static int[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1974.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		loop: for (int tc = 1; tc <= T; tc++) {

			for (int r = 0; r < 9; r++) {
				st = new StringTokenizer(br.readLine().trim());

				for (int c = 0; c < 9; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			for (int r = 0; r < 9; r++) {
				check = new int[10];

				for (int c = 0; c < 9; c++) {
					check[arr[r][c]]++;
				}

				for (int i = 1; i < 10; i++) {
					if (check[i] != 1) {
						System.out.printf("#%d %d\n", tc, 0);
						continue loop;
					}
				}
			}

			for (int c = 0; c < 9; c++) {
				check = new int[10];

				for (int r = 0; r < 9; r++) {
					check[arr[r][c]]++;
				}

				for (int i = 1; i < 10; i++) {
					if (check[i] != 1) {
						System.out.printf("#%d %d\n", tc, 0);
						continue loop;
					}
				}
			}

			int cnt = 0;

			while (cnt <= 6) {
				check = new int[10];

				for (int r = cnt; r < cnt + 3; r++) {
					// 0
					for (int c = 0; c < 3; c++) {
						check[arr[r][c]]++;
					}
				}

				for (int i = 1; i < 10; i++) {
					if (check[i] != 1) {
						System.out.printf("#%d %d\n", tc, 0);
						continue loop;
					}
				}

				check = new int[10];

				for (int r = cnt; r < cnt + 3; r++) {
					// 3
					for (int c = 3; c < 6; c++) {
						check[arr[r][c]]++;
					}
				}

				for (int i = 1; i < 10; i++) {
					if (check[i] != 1) {
						System.out.printf("#%d %d\n", tc, 0);
						continue loop;
					}
				}

				check = new int[10];

				for (int r = cnt; r < cnt + 3; r++) {
					// 6
					for (int c = 6; c < 9; c++) {
						check[arr[r][c]]++;
					}
				}

				for (int i = 1; i < 10; i++) {
					if (check[i] != 1) {
						System.out.printf("#%d %d\n", tc, 0);
						continue loop;
					}
				}

				cnt += 3;
			}

			System.out.printf("#%d %d\n", tc, 1);
		}
	}
}
