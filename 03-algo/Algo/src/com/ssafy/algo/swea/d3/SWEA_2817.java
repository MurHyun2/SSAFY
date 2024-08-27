package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2817 {

	static int N, K, cnt;
	static int[] arr, sel;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/2817.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N];
			sel = new int[N];
			cnt = 0;

			st = new StringTokenizer(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			subset(0);

			System.out.printf("#%d %d\n", tc, cnt);
		}

	}

	static void subset(int depth) {
		if (depth == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i] == 0)
					continue;

				sum += arr[i];
			}

			if (sum == K)
				cnt++;

			return;
		}

		sel[depth] = 0;
		subset(depth + 1);

		sel[depth] = 1;
		subset(depth + 1);
	}
}
