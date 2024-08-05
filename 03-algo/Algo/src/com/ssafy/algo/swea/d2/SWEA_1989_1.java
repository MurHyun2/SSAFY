package com.ssafy.algo.swea.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1989_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1989.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = null;
		
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			int palindrome = 0;
			sb = new StringBuffer(br.readLine());
			String input = sb.toString();
			String reverse = sb.reverse().toString();
			
			if(input.equals(reverse)) {
				palindrome = 1;
			}
			
			System.out.printf("#%d %d\n", i, palindrome);
		}
	}
}
