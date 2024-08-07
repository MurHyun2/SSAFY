package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_3499 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/3499.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			int cnt = Integer.parseInt(br.readLine().trim());
			String str = br.readLine().trim();
			Queue<Character> queue = new LinkedList<>();
			Queue<Character> queue2 = new LinkedList<>();

			char[] c = str.toCharArray();
			if (cnt % 2 == 0) {
				for (int i = 0; i < str.length() / 2; i++) {
					queue.add(c[i]);
				}
			} else {
				for (int i = str.length() / 2; i < str.length(); i++) {
					queue2.add(c[i]);
				}
			}

			bw.append("#" + tc + " ");
			while (!queue.isEmpty()) {
				bw.append(queue.poll());
			}

			while (!queue2.isEmpty()) {
				bw.append(queue2.poll());
			}

			bw.newLine();
			bw.flush();
		}
		
		bw.close();
	}
}
