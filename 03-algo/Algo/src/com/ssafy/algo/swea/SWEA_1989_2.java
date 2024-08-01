package com.ssafy.algo.swea;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1989_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src\\com\\ssafy\\algo\\swea\\input\\1989.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			String input = br.readLine();
			int l = input.length();
			int palindrome = 1;
			
			char[] arr = input.toCharArray();

			for (int j = 0; j < l; j++) {
				if (!(arr[j] == arr[l - 1 - j])) {
					palindrome = 0;
					break;
				}
			}

			System.out.printf("#%d %d\n", i, palindrome);
		}
	}
}
