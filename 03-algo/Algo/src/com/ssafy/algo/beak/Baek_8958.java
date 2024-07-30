package com.ssafy.algo.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Baek_8958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String str = br.readLine();

			char[] arr = new char[str.length()];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = str.charAt(j);
			}

			int count = 0;
			int plus = 0;

			for (int j = 0; j < arr.length; j++) {
				plus++;
				
				if (arr[j] == 'X')
					plus = 0;

				count += plus;
			}
			System.out.println(count);
		}
	}
}
