package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_11663 {

	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int leftIdx = lowerBound(a);
			int rightIdx = upperBound(b);

			sb.append(rightIdx - leftIdx).append("\n");
		}

		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}

	private static int upperBound(int b) {
		int left = 0, right = N;

		while (left < right) {
			int mid = (left + right) / 2;

			if (arr[mid] > b)
				right = mid;
			else
				left = mid + 1;
		}

		return left;
	}

	private static int lowerBound(int a) {
		int left = 0, right = N;

		while (left < right) {
			int mid = (left + right) / 2;

			if (arr[mid] >= a)
				right = mid;
			else
				left = mid + 1;
		}
		return left;
	}
}
