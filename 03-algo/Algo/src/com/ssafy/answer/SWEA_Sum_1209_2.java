package com.ssafy.answer;

import java.util.*;

class SWEA_Sum_1209_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			int[][] array = new int[100][100];
			int ans = 0, sum = 0;
			// 입력
			for (int r = 0; r < 100; r++)
				for (int c = 0; c < 100; c++)
					array[r][c] = sc.nextInt();

			// 가장 큰 행의 합 구하기
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++)
					sum += array[r][c];

				ans = Math.max(ans, sum);
				sum = 0;
			}

			// 가장 큰 열의 합 구하기
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++)
					sum += array[c][r];

				ans = Math.max(ans, sum);
				sum = 0;
			}

			// 왼쪽위 에서 오른쪽 아래 방향 대각선
			for (int i = 0; i < 100; i++)
				sum += array[i][i];

			ans = Math.max(ans, sum);
			sum = 0;

			// 오른쪽위에서 왼쪽 아래 방향 대각선
			for (int i = 0; i < 100; i++)
				sum += array[i][99 - i];

			ans = Math.max(ans, sum);

			System.out.println("#" + t + " " + ans);
		}
	}
}