package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Baek_5397 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < N; i++) {
			LinkedList<Character> list = new LinkedList<>();
			ListIterator<Character> iterator = list.listIterator();

			String str = br.readLine().trim();
			char[] c = str.toCharArray();

			for (char ch : c) {
				switch (ch) {
				case '<': {
					if (iterator.hasPrevious())
						iterator.previous();
					break;
				}
				case '>': {
					if (iterator.hasNext())
						iterator.next();
					break;
				}
				case '-': {
					if (iterator.hasPrevious()) {
						iterator.previous();
						iterator.remove();
					}
					break;
				}
				default: {
					iterator.add(ch);
				}
				}
			}

			for (Character character : list)
				sb.append(character);

			sb.append("\n");
		}

		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}
