package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_3273 {

	static int N, X, cnt;
	static int[] arr, cntArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		X = Integer.parseInt(br.readLine());
		// 입력 끝

		Arrays.sort(arr);

		cnt = 0;

		twoPointer();

		System.out.println(cnt);
	}

	private static void twoPointer() {
		int left = 0;
		int right = N - 1;

		while (left < right) {
			int sum = arr[left] + arr[right];

			if (sum == X) {
				cnt++;
				left++;
				right--;
				continue;
			}

			if (sum < X) {
				left++;
				continue;
			}

			if (sum > X) {
				right--;
				continue;
			}
		}
	}
}