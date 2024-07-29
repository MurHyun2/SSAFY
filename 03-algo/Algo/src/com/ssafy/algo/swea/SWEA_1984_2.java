package com.ssafy.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1984_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[10];

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			int min = arr[0];
			int max = arr[arr.length - 1];

			double sum = 0;
			int count = 0;

			for (int j = 0; j < arr.length; j++) {
				if (arr[j] != min && arr[j] != max) {
					sum += arr[j];
					count++;
				}
			}
			
			int result = (int) Math.round(sum / count);

			System.out.println("#" + i + " " + result);
		}

	}
}
