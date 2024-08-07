package com.ssafy.barking.x01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test_02 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] count = new int[101];
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < T; i++) {
			int input = Integer.parseInt(st.nextToken());
			arr[i] = input;
			count[input] = 1;
		}

		int result = 0;

		for (int i = 0; i < T - 1; i++) {
			for (int j = i + 1; j < T; j++) {
				if (arr[i] + arr[j] == 100)
					result = 1;
			}
		}
		
		int result2 = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(count[100 - arr[i]] == 1) {
				result2 = 1;
				break;
			}
		}

		System.out.println(result);
		System.out.println(result2);
	}
	
}
