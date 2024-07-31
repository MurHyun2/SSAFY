package com.ssafy.offline.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 람다이해 {
	static class Student implements Comparable<Student> {
		String name;
		int age;

		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Student(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + "]";
		}

		@Override
		public int compareTo(Student o) {
			int val = 0;
			val = this.name.compareTo(o.name);
//			val = this.age - o.age;
			return val;
		}
	}

	static class StudentComp implements Comparator<Student> {

		@Override
		public int compare(Student o1, Student o2) {
			return o1.age - o2.age;
		}

	}

	static class IntArrayComp implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
		}

	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 5 }, { 4, 1 }, { 1, 4 }, { 3, 2 } };
		/*
		 * 익명 클래스 new 클래스명 | 인터페이스명() { 내용정의 }
		 */
//		Arrays.sort(arr, new IntArrayComp());
		Comparator<int[]> comp = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
			}
		};

//		Arrays.sort(arr, comp);

		// 람다표현식 사용
		Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		System.out.println(Arrays.deepToString(arr));

		// 정렬 : Comparable, Comparator - compare(비교1, 비교2)
		List<Student> students = new ArrayList<>();
		students.add(new Student("홍길동", 22));
		students.add(new Student("임꺽정", 32));
		students.add(new Student("장보고", 25));

		Collections.sort(students, new StudentComp());

		for (Student student : students) {
			System.out.println(student.toString());
		}
	}
}
