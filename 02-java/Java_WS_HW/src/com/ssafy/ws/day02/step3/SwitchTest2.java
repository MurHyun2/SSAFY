package com.ssafy.ws.day02.step3;

import java.io.IOException;
import java.util.Scanner;

public class SwitchTest2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] data = new int[n + 1];
		for (int i = 0; i < m; i++) {
			int idx = sc.nextInt(); // 3, 5, 2
			for (int j = idx; j <=n ; j += idx) {
				data[j] = 1 - data[j];
			}
		}
		
		for(int i = 1; i < n + 1; i++) {
			System.out.print(data[i] + " ");
		}
	}
}
