package com.ssafy.barking.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test_01 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int sum = 0;
		
		for (int i = 1; i <= T; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		
		System.out.println(sum);
	}
}
