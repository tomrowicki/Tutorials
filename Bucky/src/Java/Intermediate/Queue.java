package Java.Intermediate;

import java.util.PriorityQueue;

public class Queue {

	public static void main(String[] args) {

		PriorityQueue<String> q = new PriorityQueue<String>();
		q.offer("first"); // first item gets the highest priority
		q.offer("second");
		q.offer("third");
		
		System.out.printf("%s ", q);
		System.out.println();
		
		System.out.printf("%s ", q.peek()); // returns the element with the highest priority
		System.out.println();
		
		q.poll(); // removes the element with the highest priority
		System.out.printf("%s ", q);
		
	}

}
