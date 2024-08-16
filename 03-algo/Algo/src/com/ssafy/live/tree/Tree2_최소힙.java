package com.ssafy.live.tree;

public class Tree2_최소힙 {
	static int[] heap = new int[100];
	static int heapSize = 0;

	public static void main(String[] args) {

		heapPush(20);
		heapPush(19);
		heapPush(28);
		heapPush(-5);
		heapPush(40);
		heapPush(-18);

		while (heapSize != 0) {
			int popItem = heapPop();
			System.out.println(popItem);
		}

	}

	// swap
	static void swap(int p, int ch) {
		int temp = heap[p];
		heap[p] = heap[ch];
		heap[ch] = temp;
	}

	// 삽입 연산
	static void heapPush(int data) {
		// 1. 완전 이진트리 마지막에 data 추가
		heap[heapSize + 1] = data;

		int p = heapSize / 2;
		int ch = heapSize;

		while (ch != 1 && heap[p] > heap[ch]) {
			swap(p, ch);

			ch = p;
			p = ch / 2;
		}
		heapSize++;
	}

	// 삭제 연산
	static int heapPop() {
		// 1. 루트에 있는 데이터 저장
		int popItem = heap[1];

		// 2. 마지막 노드를 루트로 옮긴다.
		heap[1] = heap[heapSize--];

		// 3. 자식과 부모 비교하여 swap 반복
		// 자식이 부모보다 작으면 swap
		// 둘 이상이면 더 작은 자식과 swap
		int p = 1;
		int ch = p * 2;

		if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
			ch++;
		}

		while (ch <= heapSize && heap[ch] < heap[p]) {
			swap(p, ch);

			// 4. swap 이후에 인덱스 갱신
			p = ch;
			ch = p * 2;

			if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
				ch++;
			}
		}

		return popItem;
	}
}
