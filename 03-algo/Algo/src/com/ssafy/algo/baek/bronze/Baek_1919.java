package com.ssafy.algo.baek.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_1919 {

	static int cnt;
	static String first, second;
	static int[] arr, arr2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		first = br.readLine().trim();
		second = br.readLine().trim();
		arr = new int[26];
		arr2 = new int[26];
		cnt = 0;

		anagram();

		System.out.println(cnt);
	}

	private static void anagram() {
		for (char c : first.toCharArray())
			arr[c - 'a']++;

		for (char c : second.toCharArray())
			arr2[c - 'a']++;

		for (int i = 0; i < 26; i++) {

			while (arr[i] != arr2[i]) {
				if (arr[i] > arr2[i]) {
					arr[i]--;
					cnt++;
					continue;
				}

				if (arr[i] < arr2[i]) {
					arr2[i]--;
					cnt++;
					continue;
				}
			}
		}
	}
}
