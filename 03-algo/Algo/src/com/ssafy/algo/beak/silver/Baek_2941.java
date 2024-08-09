package com.ssafy.algo.beak.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2941 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/beak/input/2941.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[r][c];
		
		for (int x = 0; x < arr.length; x++) {
			String str = br.readLine().trim();
			char[] ch = str.toCharArray();
			
			for (int y = 0; y < arr[c].length; y++) {
				arr[x][y] = ch[y] + '0';
			}
			
		}
		// 입력 종료
		
	}
}
