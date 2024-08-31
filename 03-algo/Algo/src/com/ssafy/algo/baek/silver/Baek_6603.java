package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_6603 {

	static int N;
	static int[] arr, sel;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			sb = new StringBuilder();
			N = Integer.parseInt(st.nextToken());
			
			if (N == 0)
				return;

			arr = new int[N];
			sel = new int[6];

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			comb(0, 0);

			System.out.println(sb.toString());
		}
	}

	private static void comb(int now, int depth) {
		if (depth == 6) {
			for (int i : sel) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = now; i < N; i++) {
			sel[depth] = arr[i];
			comb(i + 1, depth + 1);
		}
	}
}
