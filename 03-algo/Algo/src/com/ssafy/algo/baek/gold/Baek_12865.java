package com.ssafy.algo.baek.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_12865 {

	static int N, K;
	static int[] arr, weight, value;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[K + 1];
		weight = new int[N + 1];
		value = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());

			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 끝

		dp();

		System.out.println(arr[K]);
	}

	private static void dp() {
		for (int i = 1; i <= N; i++)
			for (int j = K; j >= 1; j--)
				if (weight[i] <= j)
					arr[j] = Math.max(arr[j], arr[j - weight[i]] + value[i]);
	}
}
