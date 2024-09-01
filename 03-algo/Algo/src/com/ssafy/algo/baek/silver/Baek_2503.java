package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import javax.swing.text.AbstractDocument.BranchElement;

public class Baek_2503 {
	static int T, S, B, cnt;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine().trim());
		cnt = 0;
		arr = new int[T][5];

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			String str = st.nextToken();
			char[] c = str.toCharArray();

			for (int j = 0; j < 3; j++) {
				arr[tc][j] = c[j] - '0';
			}

			arr[tc][3] = Integer.parseInt(st.nextToken());
			arr[tc][4] = Integer.parseInt(st.nextToken());
		}
		// 입력 끝

		numberBaseBall();

		System.out.println(cnt);
	}

	private static void numberBaseBall() {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (i == j)
					continue;

				for (int k = 1; k < 10; k++) {
					if (j == k || k == i)
						continue;

					boolean isValid = true;

					for (int l = 0; l < T; l++) {
						int strike = 0;
						int ball = 0;

						if (i == arr[l][0])
							strike++;
						if (j == arr[l][1])
							strike++;
						if (k == arr[l][2])
							strike++;

						if (j == arr[l][0] || k == arr[l][0])
							ball++;
						if (k == arr[l][1] || i == arr[l][1])
							ball++;
						if (i == arr[l][2] || j == arr[l][2])
							ball++;

						if (strike != arr[l][3] || ball != arr[l][4]) {
							isValid = false;
							break;
						}
					}

					if (isValid)
						cnt++;
				}
			}
		}
	}
}
