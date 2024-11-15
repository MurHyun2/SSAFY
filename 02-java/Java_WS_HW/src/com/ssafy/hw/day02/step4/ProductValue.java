package com.ssafy.hw.day02.step4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class ProductValue {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		int[] arr = new int[T];
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			int input = Integer.parseInt(br.readLine());

			arr[i] = input;
			list.add(arr[i]);
		}
		Collections.sort(list, Collections.reverseOrder());

		for (Integer i : arr) {
			int num = 1;
			for (Integer j : list) {
				if (i.equals(j)) {
					bw.write(num + " ");
					break;
				}
				num++;
			}
		}
		bw.flush();
		bw.close();
	}
}
