package com.ssafy.algo.beak.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_14696 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int[] aArr = new int[5];
			int[] bArr = new int[5];

			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(br.readLine());
				int count = Integer.parseInt(st.nextToken());

				for (int k = 0; k < count; k++) {
					if (j == 0) {
						int idx = Integer.parseInt(st.nextToken());
						aArr[idx]++;
					} else {
						int idx = Integer.parseInt(st.nextToken());
						bArr[idx]++;
					}
				}
			}

			for (int j = 4; j > 0; j--) {
				if (aArr[j] > bArr[j]) {
					System.out.println("A");
					break;
				} else if (aArr[j] < bArr[j]) {
					System.out.println("B");
					break;
				}

				if (j == 1) {
					System.out.println("D");
				}
			}
		}
	}
}
