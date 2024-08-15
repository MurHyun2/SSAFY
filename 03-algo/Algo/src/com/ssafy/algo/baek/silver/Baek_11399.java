package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baek_11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] arr = new int[T];

		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int[] sumArr = new int[T];
		int sum = 0;
		
		for (int i = 0; i < T; i++) {
			sum += arr[i];
			sumArr[i] = sum;
		}
		
		int result = 0;
		
		for (int i : sumArr) {
			result += i;
		}
		
		System.out.println(result);
	}
}
