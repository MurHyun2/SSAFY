package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_15650 {
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

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}

		comb(0, 0);

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void comb(int now, int depth) {
		if (depth == M) {
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
