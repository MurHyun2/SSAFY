package com.ssafy.offline.day03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Flatten {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] boxes = new int[100 + 1];
			int max = -1;
			int min = 101;

			for (int i = 0; i < 100; i++) {
				int height = Integer.parseInt(st.nextToken());

				if (max < height)
					max = height;

				min = Math.min(min, height);
				boxes[height]++;
			}

			while (dump > 0 && min < max - 1) {
				boxes[max]--;
				boxes[max - 1]++;
				boxes[min]--;
				boxes[min + 1]++;

				if (boxes[max] == 0)
					max--;

				if (boxes[min] == 0)
					min++;

				dump--;
			}

			System.out.println("#" + t + " " + (max - min));
		}
	}
}
