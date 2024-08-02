package com.ssafy.algo.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1209 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1209.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		for (int i = 1; i <= 10; i++) {
			int[][] arr = new int[100][100];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 100; j++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 0; k < 100; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}

			}

			// 출력
			System.out.printf("#%d %d\n", i, calMax(arr));
		}
		
	}

	static int calMax(int[][] arr) {
		int max = -1;

		// 가로줄의 합
		for (int r = 0; r < arr.length; r++) {
			int sum = 0;

			for (int c = 0; c < arr.length; c++) {
				// r
				sum += arr[r][c];
			}

			max = Math.max(max, sum);
		}

		// 세로줄의 합
		for (int c = 0; c < arr.length; c++) {
			int sum = 0;

			for (int r = 0; r < arr.length; r++) {
				// r
				sum += arr[r][c];
			}

			max = Math.max(max, sum);
		}

		// 오른쪽 대각선의 합
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i][i];
		}

		max = Math.max(max, sum);

		// 왼쪽 대각선의 합
		sum = 0;
		int c = arr.length - 1;

		for (int r = 0; r < arr.length; r++) {
			sum += arr[r][c];
			c--;
		}

		max = Math.max(max, sum);

		return max;
	}
}
