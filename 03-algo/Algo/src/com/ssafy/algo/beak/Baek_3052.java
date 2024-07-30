package com.ssafy.algo.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_3052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int arr[] = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int[] rem = new int[10];
		for (int i = 0; i < 10; i++) {
			rem[i] = arr[i] % 42;
		}

		int count = 10;
		for (int i = 0; i < 10; i++) {
			for (int j = i + 1; j < 10; j++) {
				if (rem[i] == rem[j]) {
					count--;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
