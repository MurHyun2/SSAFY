package com.ssafy.algo.baek.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_10808 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine().trim();
		char[] input = str.toCharArray();

		int[] alpCnt = new int[26];

		for (int i = 0; i < input.length; i++)
			alpCnt[input[i] - 97]++;

		for (int i : alpCnt)
			System.out.print(i + " ");
	}
}
