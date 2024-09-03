package com.ssafy.algo.swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_14510 {

	static int N, day;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/14510.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			arr = new int[N];
			day = 0;

			st = new StringTokenizer(br.readLine().trim());

			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			// 입력 끝

			Arrays.sort(arr);

			watering();

			System.out.printf("#%d %d\n", tc, day);
		}
	}

	private static void watering() {
		int oddDays = 0;
		int evenDays = 0;

		for (int i = 0; i < N - 1; i++) {
			int diff = arr[N - 1] - arr[i];
			if (diff == 0)
				continue;
			oddDays += diff % 2;
			evenDays += diff / 2;
		}

		if (oddDays < evenDays) {
			while (evenDays - oddDays > 1) {
				evenDays--;
				oddDays += 2;
			}
		}

//		System.out.println(tc + " => " + oddDays + " " + evenDays);

		if (oddDays > evenDays)
			day = oddDays * 2 - 1;
		else if (oddDays < evenDays)
			day = evenDays * 2;
		else
			day = oddDays + evenDays;
	}
}
