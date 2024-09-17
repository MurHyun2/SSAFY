package com.ssafy.algo.baek.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Baek_10250 {

	static int H, W, N;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			arr = new int[H + 1][W + 1];

//			int h = 1;
//			int w = 1;
//
//			for (int i = 0; i < N; i++) {
//				if (arr[h][w] != 0) {
//					if (h + 1 <= H)
//						h++;
//					else if (w + 1 <= W) {
//						h = 1;
//						w++;
//					}
//				}
//
//				arr[h][w] = 1;
//			}

			int h = N % H;
			int w = N / H + 1;

			if (h == 0) {
				h = H;
				w = N / H;
			}

			if (w >= 10)
				sb.append(h + "" + w).append("\n");
			else
				sb.append(h + "0" + w).append("\n");
		}

		System.out.println(sb);
	}
}
