package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_9663 {

	static int N, cnt;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine().trim());
		arr = new int[N];
		cnt = 0;

		dfs(0);

		System.out.println(cnt);
	}

	private static void dfs(int col) {
		if (col == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[col] = i;
			if (check(col)) {
				dfs(col + 1);
			}
		}
	}

	private static boolean check(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i])
				return false;

			if (Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
				return false;
		}

		return true;
	}
}
