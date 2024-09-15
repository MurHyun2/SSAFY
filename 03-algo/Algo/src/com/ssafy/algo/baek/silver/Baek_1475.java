package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine().trim();

		int[] sets = new int[9];

		char[] nums = str.toCharArray();

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == '6' || nums[i] == '9')
				sets[6]++;
			else
				sets[nums[i] - '0']++;
		}

		sets[6] = (int) Math.ceil(sets[6] / 2.0);
		int max = 0;
		
		for (int i : sets)
			max = (int) Math.max(i, max);

		System.out.println(max);
	}
}
