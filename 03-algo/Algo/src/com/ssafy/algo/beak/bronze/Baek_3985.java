package com.ssafy.algo.beak.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_3985 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int r = Integer.parseInt(br.readLine());
		int[] arr = new int[r + 1];
		int max = 0;
		int tIdx = 0;
		int rIdx = 0;
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			for (int j = start; j <= end; j++) {
				if (arr[j] == 0)
					arr[j] = i;
			}

			int minus = end - start + 1;

			if (max < minus) {
				max = minus;
				tIdx = i;
			}
		}

		max = 0;

		for (int i = 1; i <= T; i++) {
			int sum = 0;

			for (int j : arr) {
				if (i == j)
					sum++;
			}
			
			if(max < sum) {
				max = sum;
				rIdx = i;
			}
		}
		
		System.out.println(tIdx);
		System.out.println(rIdx);
	}
}
