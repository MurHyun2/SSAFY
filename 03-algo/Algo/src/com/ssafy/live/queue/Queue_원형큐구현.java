package com.ssafy.live.queue;

import java.util.Arrays;

public class Queue_원형큐구현 {
	// 데이터를 3개 담을 수 있다.
	static String[] queue = new String[4];
	static int front, rear;
	static int N = queue.length;
	static int size;
	
	public static void main(String[] args) {
		enQueue("L");
		enQueue("D");
		enQueue("M");
		enQueue("A");
		
		System.out.println(size());
		System.out.println(Arrays.toString(queue));
		
		deQueue();
		deQueue();
		System.out.println(Arrays.toString(queue));
		
		enQueue("123");
		System.out.println(Arrays.toString(queue));
	}

	// 포화상태 확인
	static boolean isFull() {
		return (N + front - rear) % N == 1;
	}

	// 공백상태 확인
	static boolean isEmpty() {
		return front == rear;
	}

	// 삽입
	static void enQueue(String data) {
		if (isFull()) {
			System.out.println("Queue Full");
			return;
		}
		size++;
		rear = (rear + 1) % N;
		queue[rear] = data;
	}

	// 삭제
	static String deQueue() {
		if (isEmpty()) {
			System.out.println("Queue Empty");
			return null;
		}
		size--;
		front = (front + 1) % N;
		String item = queue[front];
		queue[front] = null;
		return item;
	}

	// 조회
	static String queuePeek() {
		if (isEmpty()) {
			System.out.println("Queue Empty");
			return null;
		}
		return queue[(front + 1) % N];
	}
	
	// 데이터 개수
	static int size() {
		return (rear - front + N) % N;
	}
}
