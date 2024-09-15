package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Baek_10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < T; i++) {
			String input = br.readLine().trim();
			int size = list.size();
			int lastIdx = size - 1;

			switch (input) {
			case "pop": {
				if (size == 0)
					sb.append(-1).append("\n");
				else {
					sb.append(list.get(lastIdx)).append("\n");
					list.remove(lastIdx);
				}
				break;
			}
			case "size": {
				sb.append(size).append("\n");
				break;
			}
			case "empty": {
				if (size == 0)
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
			}
			case "top": {
				if (size == 0)
					sb.append(-1).append("\n");
				else
					sb.append(list.get(lastIdx)).append("\n");
				break;
			}
			default: {
				int num = Integer.parseInt(input.substring(5));
				list.add(num);
			}
			}
		}

		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
