package collections;

import java.util.Stack;

public class Test4 {
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(10);
		s.push("hyd");
		s.push('f');
		s.push(false);
		s.add(99);
		System.out.println(s);
		System.out.println(s.peek());
		System.out.println(s);
		System.out.println(s.pop());
		System.out.println(s);
		System.out.println(s.search(false)); 
		System.out.println(s.search(10)); 
	}
	}

