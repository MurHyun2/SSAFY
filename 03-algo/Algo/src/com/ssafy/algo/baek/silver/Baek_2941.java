package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_2941 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] croAlp = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		
		String input = br.readLine().trim();
		for (int i = 0; i < croAlp.length; i++) {
				input = input.replaceAll(croAlp[i], "1");
			}
		
		System.out.println(input.length());
	}
}
