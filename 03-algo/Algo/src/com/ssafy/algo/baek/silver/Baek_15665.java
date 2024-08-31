package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_15665 {
	static int N, M;
	static int[] arr, sel;
	static BufferedWriter bw;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		sel = new int[M];

		st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		perm(0);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void perm(int depth) {
		if (depth == M) {
			for (int i : sel) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		int prev = 0;

		for (int i = 0; i < N; i++) {
			if (prev != arr[i]) {
				prev = arr[i];
				sel[depth] = arr[i];
				perm(depth + 1);
			}
		}
	}

}
