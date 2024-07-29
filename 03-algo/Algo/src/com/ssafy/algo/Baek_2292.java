package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int count = 1;
		int num = 1;
		int add = 0;

		while (true) {
			if (N <= num) {
				System.out.println(count);
				break;
			}
			add += 6;
			num += add;
			count++;
		}
	}
}

