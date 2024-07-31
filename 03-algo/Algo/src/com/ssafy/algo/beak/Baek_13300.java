package com.ssafy.algo.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_13300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] boys = new int[7];
		int[] girls = new int[7];

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());

			// 0일 경우 여학생, 1일 경우 남학생
			if (sex == 0)
				girls[grade]++;
			else
				boys[grade]++;
		}

		int count = 0;

		for (int i = 0; i < 7; i++) {
			if (boys[i] != 0)
				count += Math.ceil(boys[i] / (double) K);

			if (girls[i] != 0)
				count += Math.ceil(girls[i] / (double) K);
		}
		
		System.out.println(count);
	}
}
