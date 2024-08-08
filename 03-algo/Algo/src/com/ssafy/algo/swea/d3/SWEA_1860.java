package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1860 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1860.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine().trim());

			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);
			String result = "Possible";
			int[] counting = new int[arr[n - 1] + 1];
			double cnt = 0;

			if (arr[0] < m) {
				result = "Impossible";
			} else {
				for (int j = 0; j < n; j++) {
					counting[arr[j]]++;
				}

				double bps = (double) k / m;

				loop: for (int j = 0; j < counting.length; j++) {
					cnt += bps;

					while (counting[j] > 0) {
						if (cnt < counting[j]) {
							result = "Impossible";
							break loop;
						}

						counting[j] -= cnt;
						cnt--;
					}

				}

			}

			System.out.println("#" + i + " " + result);
		}
	}
}
