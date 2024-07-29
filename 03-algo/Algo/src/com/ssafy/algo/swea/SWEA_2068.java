package com.ssafy.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2068 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int max = Integer.MIN_VALUE;

			for (int j = 0; j < 10; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(max < input)
					max = input;
			}

			System.out.println("#" + i + " " + max);
		}
	}
}
