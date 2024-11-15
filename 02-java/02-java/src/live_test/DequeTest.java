package live_test;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeTest {
	public static void main(String[] args) {
		Deque<String> deque = new ArrayDeque<>();

		deque.addFirst("a");
		deque.addLast("d");
		deque.addFirst("b");
		deque.addFirst("c");

		while (!deque.isEmpty()) {
			System.out.println(deque);
			deque.removeFirst();
		}
	}
}
