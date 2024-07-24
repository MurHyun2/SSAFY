package live_test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		// Queue
		// - FIFO
		// Queue Interface
		// LinkedList를 구현체로 사용.

		Queue<Integer> queue = new LinkedList<>();

		queue.offer(1);
		queue.offer(2);
		queue.offer(3);

		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
}
