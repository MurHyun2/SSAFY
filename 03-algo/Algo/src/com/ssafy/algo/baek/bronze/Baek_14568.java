package com.ssafy.algo.baek.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_14568 {

	static int N, a, b, c, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine().trim());
		cnt = 0;

		// 영훈
		for (int i = 1; i < N; i++) {
			// 남규
			for (int j = i + 2; j < N; j++) {
				// 택희
				int k = N - i - j;

				if (k <= 0 || k % 2 != 0)
					continue;

				cnt++;
			}
		}

		System.out.println(cnt);
	}

}
