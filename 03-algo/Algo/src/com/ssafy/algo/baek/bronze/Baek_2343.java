package com.ssafy.algo.baek.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_2343 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		for (int i = N; i > 0; i--) {
			int re = (i * 2) - 1;

			for (int j = N; j > i; j--)
				System.out.print(" ");

			for (int j = 1; j <= re; j++)
				System.out.print("*");

			System.out.println();
		}

	}
}
