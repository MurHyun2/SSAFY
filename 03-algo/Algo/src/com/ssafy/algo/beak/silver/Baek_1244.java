package com.ssafy.algo.beak.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1244 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int count = Integer.parseInt(br.readLine());

		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int sNo = Integer.parseInt(st.nextToken());

			if (gender == 1) {
//				while (sNo <= arr.length) {
//					arr[sNo - 1] = 1 - arr[sNo - 1];
//					sNo *= 2;
//				}
				for (int j = sNo; j <= T; j += sNo) {
					arr[j - 1] = 1 - arr[j - 1];
				}

			} else {
				int m = sNo - 2;
				int p = sNo;

				while (m >= 0 && p < arr.length && arr[m] == arr[p]) {
					arr[m] = 1 - arr[m];
					arr[p] = 1 - arr[p];
					m--;
					p++;
				}

				arr[sNo - 1] = 1 - arr[sNo - 1];
			}
		}

		for (int i = 0; i < T; i++) {
			System.out.print(arr[i] + " ");
			if ((i + 1) % 20 == 0) {
				System.out.println();
			}
		}
	}
}
