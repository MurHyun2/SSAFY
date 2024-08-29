package com.ssafy.offline.daily;

import java.util.Arrays;

public class 오늘의할일 {

	static int N, R;
	static int[] arr, intData;
	static String[] data;

	public static void main(String[] args) {
		N = 4;
		R = 3;
		data = new String[] { "햄", "계란", "단무지", "시금치" };
		intData = new int[] { 10, 20, 30, 40 };

		System.out.println("조합반복문()");
		조합반복문();
		System.out.println();

		System.out.println("조합반복재귀(0, 0)");
		arr = new int[R];
		조합반복재귀(0, 0);
		System.out.println();

		System.out.println("부분집합반복()");
		arr = new int[N];
		부분집합반복();
		System.out.println();

		System.out.println("부분집합재귀(0)");
		부분집합재귀(0);
		System.out.println();

		System.out.println("조합재귀(0, 0)");
		arr = new int[R];
		조합재귀(0, 0);
		System.out.println();

		System.out.println("부분집합비트마스킹()");
		부분집합비트마스킹();
	}

	// R의 갯수가 정해져 있는 경우 반복문으로 가능
	static void 조합반복문() {
		for (int i = 0; i <= N - R + 0; i++) {
			for (int j = i + 1; j <= N - R + 1; j++) {
				for (int k = j + 1; k <= N - R + 2; k++) {
					System.out.printf("%d %d %d\n", i, j, k);
				}
			}
		}
	}

	static void 조합반복재귀(int start, int depth) {
		if (depth == R) {
			System.out.println(Arrays.toString(arr));
			for (int i = 0; i < R; i++) {
				System.out.print(data[arr[i]] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= N - R + depth; i++) {
			arr[depth] = i;
			조합반복재귀(i + 1, depth + 1);
		}
	}

	static void 부분집합반복() {
		for (int i = 0; i < 2; i++) {
			arr[0] = i;
			for (int j = 0; j < 2; j++) {
				arr[1] = j;
				for (int k = 0; k < 2; k++) {
					arr[2] = k;
					for (int l = 0; l < 2; l++) {
						arr[3] = l;

						for (int m = 0; m < N; m++) {
							if (arr[m] == 0)
								continue;

							System.out.print(intData[m] + " ");
						}

						System.out.println();
					}
				}
			}
		}
	}

	static void 부분집합재귀(int idx) {
		if (idx == R) {
			for (int i = 0; i < R; i++) {
				if (arr[i] == 0)
					continue;

				System.out.print(intData[i] + " ");
			}
			System.out.println();
			return;
		}
		// 미선택
		arr[idx] = 0;
		부분집합재귀(idx + 1);

		arr[idx] = 1;
		부분집합재귀(idx + 1);
	}

	// idx : 현재 판단하는 값
	// selectIdx : 선택된 항목
	static void 조합재귀(int idx, int selectIdx) {

		if (selectIdx == R) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		if (idx == N) {
			return;
		}
		// 선택
		arr[selectIdx] = intData[idx];
		조합재귀(idx + 1, selectIdx + 1);

		// 미선택
		조합재귀(idx + 1, selectIdx);
	}

	static void 부분집합비트마스킹() {
		// 2^N개 만큼 경우의 수가 나온다.
//		System.out.println(1 << 1);
//		System.out.println(1 << 2);
//		System.out.println(1 << 3);
//		System.out.println(1 << 4);

		for (int i = 0; i < (1 << N); i++) { // i : 하나의 경우의 수
//			System.out.println(i + " " + Integer.toBinaryString(i) + " ");
			// 하나의 경우에 대한 N개의 데이터에 대한 선택과 비선택 여부 체크
			for (int j = 0; j < N; j++) {
				if ((i & (1 << j)) != 0) {
					System.out.print(intData[j] + " ");
				}
			}
			System.out.println();
		}
	}
}
