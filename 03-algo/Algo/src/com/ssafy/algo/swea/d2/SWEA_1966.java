package com.ssafy.algo.swea.d2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src/com/ssafy/algo/swea/input/1966.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int i = 1; i <= T; i++) {
			int n = Integer.parseInt(br.readLine().trim());

			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine().trim());

			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

//			bubbleSort(arr);
//			selectionSort(arr);
			insertionSort(arr);

			bw.append("#" + i + " ");
			for (int item : arr) {
				bw.append(item + " ");
			}
			bw.newLine();
			bw.flush();
		}

		bw.close();
	}

	static int[] bubbleSort(int[] arr) {
		int temp;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}

			}
		}

		return arr;
	}

	static int[] selectionSort(int[] arr) {
		int temp;

		for (int i = 0; i < arr.length - 1; i++) {
			int minIdx = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}

			temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}

		return arr;
	}

	static int[] insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j;

			for (j = i - 1; j >= 0 && arr[j] > temp; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = temp;
		}

		return arr;
	}
}
