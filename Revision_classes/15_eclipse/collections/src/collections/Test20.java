package collections;

import java.util.PriorityQueue;

public class Test20 {
	public static void main(String[] args) {
		
		PriorityQueue<Object> pq = new PriorityQueue<>();
		
		pq.offer("a");
		pq.offer("c");
		pq.offer("b");
		pq.offer("e");
		pq.offer("f");
		pq.add("d");
		System.out.println(pq); 

		System.out.println(pq.element()); 	
		System.out.println(pq); 
		System.out.println(pq.element()); 
		System.out.println(pq); 
		System.out.println(pq.element()); 
		System.out.println(pq); 
				
		System.out.println(pq.poll());	
		System.out.println(pq);
		System.out.println(pq.poll()); 		
		System.out.println(pq);
		System.out.println(pq.poll());	
		System.out.println(pq);
		
	}

}