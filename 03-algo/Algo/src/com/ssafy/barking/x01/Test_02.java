package com.ssafy.barking.x01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test_02 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int result = 0;

		for (int i = 0; i < T - 1; i++) {
			for (int j = i + 1; j < T; j++) {
				if (arr[i] + arr[j] == 100)
					result = 1;
			}

		}

		System.out.println(result);
	}
}
