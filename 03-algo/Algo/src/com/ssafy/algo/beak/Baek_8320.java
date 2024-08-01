package com.ssafy.algo.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_8320 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int count = 0;

		for (int i = 1; i * i <= T; i++) {
			
			for (int j = i; j <= T; j++) {
				if (i * j <= T) {
					count++;
				} else {
					break;
				}
				
			}
			
		}

		System.out.println(count);
	}
}
