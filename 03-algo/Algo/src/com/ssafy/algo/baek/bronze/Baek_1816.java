package com.ssafy.algo.baek.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		for (int tc = 0; tc < N; tc++) {
			long num = Long.parseLong(br.readLine().trim());
			String result = "YES";

			for (int i = 2; i <= 1_000_000; i++) {
				if (num % i == 0) {
					result = "NO";
					break;
				}
			}

			System.out.println(result);
		}
	}
}
