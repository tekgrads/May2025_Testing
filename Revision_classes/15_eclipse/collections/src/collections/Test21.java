package collections;

import java.util.ArrayDeque;

public class Test21 {
	public static void main(String[] args) {
		
		//FIFO order 	
		/*	ArrayDeque<Object> adq1 = new ArrayDeque<>();
			adq1.offer("a");
			adq1.offer("c");		
			adq1.offer("b");		
			adq1.offer("d");		
			adq1.offer("f");		
			adq1.offer("e");
			System.out.println(adq1);
			System.out.println();
			
			System.out.print(adq1.peek()); 
			System.out.println("->"+adq1);
			System.out.print(adq1.peek()); 
			System.out.println("->"+adq1);
			System.out.print(adq1.peek()); 
			System.out.println("->"+adq1);
			
			System.out.println();

			System.out.print(adq1.poll()); 
			System.out.println("->"+adq1);
			System.out.print(adq1.poll()); 
			System.out.println("->"+adq1);
			System.out.print(adq1.poll()); 
			System.out.println("->"+adq1);
			
			System.out.println();
			*/
		//LIFO order
			ArrayDeque<Object> adq2 = new ArrayDeque<Object>();
			adq2.push("a");
			adq2.push("c");
			adq2.push("b");
			adq2.push("d");
			adq2.push("f");
			adq2.push("e");
			System.out.println(adq2);

			System.out.print(adq2.peek());
			System.out.println("->"+adq2);
			System.out.print(adq2.peek());
			System.out.println("->"+adq2);
			System.out.print(adq2.peek());
			System.out.println("->"+adq2);
			
			System.out.println();

			System.out.print(adq2.pop()); 
			System.out.println("->"+adq2);
			System.out.print(adq2.pop()); 
			System.out.println("->"+adq2);
			System.out.print(adq2.pop()); 
			System.out.println("->"+adq2);
			System.out.println();
			
			System.out.print(adq2.poll()); 
			System.out.println("->"+adq2);
			System.out.print(adq2.poll()); 
			System.out.println("->"+adq2);
			System.out.print(adq2.poll()); 
			System.out.println("->"+adq2);
			
			System.out.println();
	
	}

}
