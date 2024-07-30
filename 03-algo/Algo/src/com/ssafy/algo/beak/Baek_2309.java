package com.ssafy.algo.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_2309 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[9];
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		loop:
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int a = arr[i] + arr[j];

				if (a == sum - 100) {
					arr[i] = 0;
					arr[j] = 0;
					break loop;
				}
			}
		}

		Arrays.sort(arr);

		for (int i = 2; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
