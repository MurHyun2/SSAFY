package com.ssafy.algo.baek.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11050 {

	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int val = cal(N) / (cal(K) * cal(N - K));

		System.out.println(val);
	}

	private static int cal(int i) {
		if (i <= 1)
			return 1;
		else
			return i * cal(i - 1);
	}
}
