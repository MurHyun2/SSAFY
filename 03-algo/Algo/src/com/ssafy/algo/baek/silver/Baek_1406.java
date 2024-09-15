package com.ssafy.algo.baek.silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Baek_1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		LinkedList<Character> list = new LinkedList<>();

		char[] ch = br.readLine().trim().toCharArray();

		for (int i = 0; i < ch.length; i++)
			list.add(i, ch[i]);

		ListIterator<Character> iterator = list.listIterator();
		while (iterator.hasNext())
			iterator.next();

		int N = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < N; i++) {
			String input = br.readLine().trim();
			char cmd = input.charAt(0);

			switch (cmd) {
			case 'L': {
				if (iterator.hasPrevious())
					iterator.previous();
				break;
			}
			case 'D': {
				if (iterator.hasNext())
					iterator.next();
				break;
			}
			case 'B': {
				if (iterator.hasPrevious()) {
					iterator.previous();
					iterator.remove();
				}
				break;
			}
			case 'P': {
				char addChar = input.charAt(2);
				iterator.add(addChar);
				break;
			}
			}
		}

		for (Character c : list)
			sb.append(c);

		bw.append(sb.toString());
		bw.flush();
		bw.close();
	}
}