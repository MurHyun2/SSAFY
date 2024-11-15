package com.ssafy.off.day07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class colorPaper {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[] x = new int[T];
		int[] y = new int[T];

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			x[i] = Integer.parseInt(st.nextToken()) + 10;
			y[i] = Integer.parseInt(st.nextToken()) + 10;
		}

		int result = T * 100;
		System.out.println(result);
		for (int i = 0; i < T; i++) {
			for (int j = i + 1; j < T; j++) {
				int r = 0;
				int c = 0;

				if (Math.abs(x[i] - x[j]) < 10 && Math.abs(y[i] - y[j]) < 10) {
					r = 10 - Math.abs(x[i] - x[j]);
					c = 10 - Math.abs(y[i] - y[j]);
					System.out.println(r*c);
				}
				result -= r * c;
			}
		}
		System.out.println(result);
	}

}
