package com.ssafy.barking.x01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test_03 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int result = 0;

		for (int i = 1; i * i <= T; i++) {
			if(i * i == T)
				result = 1;
		}
		
		System.out.println(result);
	}
}
