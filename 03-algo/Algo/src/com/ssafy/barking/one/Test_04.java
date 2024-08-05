package com.ssafy.barking.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test_04 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int result = 1;
		
		while(result * 2 <= T) {
			result *= 2;
		}
		
		System.out.println(result);
	}
}
