package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1010 {
	static int N, M, cnt;
	static int[] arr;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			cnt = 0;

			comb(0, 0);
//			long result = comb(M, N);

			System.out.println(cnt);
		}
	}

//	private static long fac(long num) {
//		long result = 1;
//
//		for (long i = 2; i <= num; i++)
//			result *= i;
//
//		return result;
//	}
//
//	private static long comb(long m, long n) {
//		return fac(m) / (fac(n) * fac(m - n));
//	}

	private static void comb(int start, int depth) {
		if (depth == N) {
			cnt++;
			return;
		}

		for (int i = start; i < M; i++) {
			comb(i + 1, depth + 1);
		}
	}
}
