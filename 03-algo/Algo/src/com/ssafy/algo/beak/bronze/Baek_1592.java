package com.ssafy.algo.beak.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1592 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		arr[0] = 1;
		int count = 0;
		int now = 0;

		while (true) {
			if (arr[now] == M) {
				System.out.println(count);
				break;
			}

			if (arr[now] % N != 0) {
				now = (now + L) % N;
			} else {
				now = (now - L + N) % N;
			}
			arr[now]++;
			count++;
		}
	}
}
