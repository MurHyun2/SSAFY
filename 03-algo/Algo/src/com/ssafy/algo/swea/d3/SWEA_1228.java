package com.ssafy.algo.swea.d3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1228 {

	static int n1, n2;
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1228.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = 10;
		// 입력
		for (int i = 1; i <= tc; i++) {
			list.clear();
			
			n1 = Integer.parseInt(br.readLine().trim());
			StringTokenizer st = new StringTokenizer(br.readLine().trim());

			for (int j = 0; j < n1; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			n2 = Integer.parseInt(br.readLine().trim());
			st = new StringTokenizer(br.readLine().trim());

			while (st.hasMoreTokens()) {
				if (st.nextToken().equals("I")) {
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());

					for (int k = 0; k < b; k++) {
						list.add(a++, Integer.parseInt(st.nextToken()));
					}
				}
			}

			bw.append("#" + i + " ");

			for (int j = 0; j < 10; j++) {
				bw.append(list.get(j) + " ");
			}

			bw.newLine();
			bw.flush();
		}

		bw.close();
	}

}