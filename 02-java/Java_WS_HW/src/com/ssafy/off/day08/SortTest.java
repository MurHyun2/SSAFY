package com.ssafy.off.day08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {
	static class IdolComparator implements Comparator<Idol> {

		@Override
		public int compare(Idol o1, Idol o2) {
			return (o1.fanCount - o2.fanCount) * -1;
		}

	}

	public static void main(String[] args) {
		List<Idol> list = new ArrayList<>();
		list.add(new Idol("나카리나", 24, 100));
		list.add(new Idol("가카리나", 24, 70));
		list.add(new Idol("라카리나", 25, 10));
		list.add(new Idol("다카리나", 24, 1000));
		list.add(new Idol("마카리나", 26, 500));
		
		List<String> list2 = new ArrayList<>();
		list2.add("가나다");
		list2.add("다");
		list2.add("나다");
		
		Collections.sort(list, new IdolComparator());
		Collections.sort(list2, Collections.reverseOrder());

		for (Idol idol : list) {
			System.out.println(idol);
		}
		
		for (String string : list2) {
			System.out.println(string);
		}
	}
}
