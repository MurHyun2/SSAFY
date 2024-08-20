package com.ssafy.offline.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 최소비용 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine().trim());

		for (int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int N = Integer.parseInt(st.nextToken());
			int W1 = Integer.parseInt(st.nextToken());
			int W2 = Integer.parseInt(st.nextToken());
			int sum = 0;
			int[] arr = new int[N];

			st = new StringTokenizer(br.readLine().trim());

			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			int cnt = N - 1;
			int w1Cnt = 1;
			int w2Cnt = 1;

			while (cnt >= 0) {
				if (w1Cnt <= W1) {
					sum += w1Cnt * arr[cnt--];
					w1Cnt++;
				}
				
				if (w2Cnt <= W2) {
					sum += w2Cnt * arr[cnt--];
					w2Cnt++;
				}
			}

			System.out.printf("#%d %d\n", i, sum);
		}

	}
}

// 27분
