package com.ssafy.algo.swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_14510_2 {

	static int N, day, max;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/14510.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[N];
			max = 0;
			st = new StringTokenizer(br.readLine().trim());

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, arr[i]);
			}
			// 입력 끝

			day = 0;

			watering();

			System.out.println(day);
		}
	}

	private static void watering() {
		int oddDays = 0;
		int evenDays = 0;

		for (int i = 0; i < N; i++) {
			int diff = max - arr[i];
			oddDays += diff % 2;
			evenDays += diff / 2;
		}

		while (evenDays - oddDays > 1) {
			evenDays--;
			oddDays += 2;
		}

		if (evenDays > oddDays) {
			day = evenDays * 2;
		} else if (oddDays > evenDays) {
			day = oddDays * 2 - 1;
		} else {
			day = oddDays + evenDays;
		}
	}
}
