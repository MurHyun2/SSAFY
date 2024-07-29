package com.ssafy.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1984_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			List<Integer> list = new ArrayList<>();

			for (int j = 0; j < 10; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			int max = Collections.max(list);
			int min = Collections.min(list);
			double sum = 0;
			int count = 0;

			for (Integer num : list) {
				if (num != max && num != min) {
					sum += num;
					count++;
				}
			}

			int result = (int) Math.round(sum / count);

			System.out.println("#" + i + " " + result);
		}
	}
}
