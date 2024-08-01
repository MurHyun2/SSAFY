package com.ssafy.answer;

import java.util.*;

class SWEA_Sum_1209_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			sc.nextInt();
			int[][] array = new int[100][100];
			// 입력
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					array[r][c] = sc.nextInt();
				}
			}

			int ans = 0;
			int line1Sum = 0, line2Sum = 0;
			for (int r = 0; r < 100; r++) {
				int rSum = 0, cSum = 0;
				for (int c = 0; c < 100; c++) {
					rSum += array[r][c];
					cSum += array[c][r];
					if (r == c)
						line1Sum += array[r][c];
					if (c == 99 - r)
						line2Sum += array[r][c];
				}
				ans = Math.max(ans, rSum);
				ans = Math.max(ans, cSum);
			}
			ans = Math.max(ans, line1Sum);
			ans = Math.max(ans, line2Sum);

			System.out.println("#" + t + " " + ans);
		}
	}
}