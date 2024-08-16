package com.ssafy.live.tree;

import java.util.PriorityQueue;

class Person implements Comparable<Person> {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.age - o.age;
	}

	@Override
	public String toString() {
		return this.name + ":" + this.age;
	}
}

public class Tree2_우선순위큐 {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int[] arr = { 20, 19, 28, -5, 40, -18 };

		for (int i = 0; i < arr.length; i++) {
			pq.add(arr[i]);
		}

		// 기본적으로 내림차순
		while (!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}

		System.out.println();

		// 오름차순으로 하려면?
		// add 할때 부호 반대로 & poll 할때도 부호 반대
		pq = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {
			pq.add(-arr[i]);
		}

		while (!pq.isEmpty()) {
			System.out.print(-pq.poll() + " ");
		}

		System.out.println();

//		PriorityQueue<Person> personPQ = new PriorityQueue<>();
//
//		// Comparator을 구현한 PersonComparator 클래스를 넣어줌.
//		PriorityQueue<Person> personPQ = new PriorityQueue<>(new PersonComparator());

		// 람다식
		PriorityQueue<Person> personPQ = new PriorityQueue<>(
			(p1, p2) -> {return p2.age - p1.age;}
		);

		personPQ.add(new Person("Luna", 3));
		personPQ.add(new Person("Daisy", 5));
		personPQ.add(new Person("Max", 7));

		while (!personPQ.isEmpty()) {
			Person now = personPQ.poll();
			System.out.println(now.toString());
		}
	}
}
