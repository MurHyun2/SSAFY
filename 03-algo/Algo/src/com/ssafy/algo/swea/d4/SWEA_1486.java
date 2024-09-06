package com.ssafy.algo.swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1486 {

	static int N, B, min;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1486.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arr = new int[N];

			st = new StringTokenizer(br.readLine().trim());

			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			// 입력 끝

			min = Integer.MAX_VALUE;

			subs();

			sb.append("#" + tc + " " + (min - B));
			sb.append("\n");
		}

		System.out.println(sb);
	}

	private static void subs() {
		for (int i = 1; i < (1 << N); i++) {
			int sum = 0;

			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					sum += arr[j];
				}
			}

			if (sum == B) {
				min = B;
				return;
			}

			if (sum > B)
				min = Math.min(min, sum);
		}
	}
}