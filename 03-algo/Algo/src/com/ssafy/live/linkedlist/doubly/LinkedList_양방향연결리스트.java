package com.ssafy.live.linkedlist.doubly;

class Node {
	String data;
	Node prev;
	Node next;
}

class DoublyLinkedList {
	Node head;
	Node tail;
	int size;

	public DoublyLinkedList() {
		// 이렇게 구현하면 모든 삽입을 중간 삽입으로 처리 가능
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	// 삽입
	void addData(int i, String data) {
		// i인덱스에 데이터 삽입
		// 0이면 제일 앞에 추가
		// size와 같으면 제일 뒤에 추가
		if (0 > i || size < i) {
			System.out.println("삽입할 위치가 잘못되었습니다.");
			return;
		}

		// 삽입할 위치 앞에 있는 노드 찾기
		Node curr = head;
		for (int k = 0; k < i; k++) {
			curr = curr.next;
		}

		// 새 노드 만들어귀
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = curr.next;
		newNode.prev = curr;

		// 기존 노드 연결 재구성
		curr.next.prev = newNode;
		curr.next = newNode;

		size++;
	}

	// 삭제
	void removeData(int i) {
		// 0번 : 제일 앞에 있는 데이터 삭제
		// size - 1 : 마지막 데이터 삭제

		if (0 > i || size <= i) {
			System.out.println("삭제할 수 없는 범위입니다.");
			return;
		}

		// 삭제할 노드의 앞 노드로 이동
		// rmNode는 지역변수 이므로 메서드 리턴과 동시에 접근 불가 : GC가 처리
		Node rmNode = head.next;
		for (int j = 0; j < i; j++) {
			rmNode = rmNode.next;
		}

		rmNode.prev.next = rmNode.next;
		rmNode.next.prev = rmNode.prev;
		
		size--;
	}

	// 조회
	void printReverse() {
		Node curr = tail.prev;
		String str = "";

		while (curr != head) {
			if(curr.prev != head)
				str = "<-" + curr.data + str;
			else
				str = curr.data + str;
			curr = curr.prev;
		}
		System.out.println(str);
	}
}

public class LinkedList_양방향연결리스트 {
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();

		list.addData(0, "A");
		list.addData(0, "B");
		list.addData(0, "D");
		list.addData(1, "C");
		list.printReverse();
		System.out.println(list.size);

		list.removeData(1);
		list.printReverse();

		list.removeData(1);
		list.printReverse();
	}
}
