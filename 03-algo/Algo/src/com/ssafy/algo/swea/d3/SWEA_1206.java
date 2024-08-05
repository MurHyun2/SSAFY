package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1206 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i <= 10; i++) {
			int T = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> list = new ArrayList<>();

			for (int j = 0; j < T; j++)
				list.add(Integer.parseInt(st.nextToken()));

			int count = 0;

			for (int j = 2; j < list.size() - 2; j++) {
				int val = list.get(j);
				int[] arr = { -2, -1, 1, 2 };

				if (val >= list.get(j + 1) && val >= list.get(j + 2) && val >= list.get(j - 1)
						&& val >= list.get(j - 2)) {
					int max = Integer.MIN_VALUE;

					for (int k = 0; k < arr.length; k++) {
						if (max < list.get(j + arr[k]))
							max = list.get(j + arr[k]);
					}
					
					count += list.get(j) - max;
				}
			}
			
			System.out.println("#" + i + " " + count);
		}
	}
}
