package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_2477 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int K = Integer.parseInt(br.readLine().trim());
		List<int[]> list = new ArrayList<>();
		boolean[] check = new boolean[5];
		int bVal = 1;
		int mVal = 1;

		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine().trim());

			int d = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());

			list.add(new int[] {d, val});
			check[d] = !check[d];
		}
		
		int idx = 0;
		
		for (int[] i : list) {
			if(check[i[0]]) {
				int calIdx = (idx + 3) % 6;
				mVal *= list.get(calIdx)[1];
				bVal *= i[1];
			}
			idx++;
		}
		
		int result = (bVal - mVal) * K;
		
		System.out.println(result);
	}
}
