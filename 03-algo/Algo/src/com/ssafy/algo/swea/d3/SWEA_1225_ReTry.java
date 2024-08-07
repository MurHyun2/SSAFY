package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225_ReTry {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1225.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Queue<Integer> queue = new LinkedList<>();

		int[] arr = new int[8];

		for (int i = 1; i <= 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st = new StringTokenizer(br.readLine().trim());

			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				queue.add(arr[j]);
			}

			for (int j = 1; j <= 5; j++) {
				int item = queue.poll();
				item -= j;
				j %= 5;

				if (item <= 0) {
					queue.add(0);
					break;
				}
				queue.add(item);
			}

			bw.append("#" + i + " ");

			for (int j = 0; j < 8; j++) {
				bw.append(queue.poll() + " ");
			}

			bw.newLine();
			bw.flush();
		}
		bw.close();
	}
}
