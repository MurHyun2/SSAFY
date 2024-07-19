package com.ssafy.ws.day02.step4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AirCrashes {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[T];
		int max = 0;

		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (arr[i] > max)
				max = arr[i];
		}

		int min = arr[arr.length - 1];
		int result = 0;

		for (int j = arr.length - 1; j >= 0; j--) {
			if (arr[j] < min) {
				min = arr[j];
				result = max - min;
				break;
			} else
				result = -1;
		}
		System.out.println(result);
	}
}
