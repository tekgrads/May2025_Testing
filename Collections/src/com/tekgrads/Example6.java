package com.tekgrads;

import java.util.Stack;

public class Example6 {

	public static void main(String[] args) {
		Stack s = new Stack();

		s.push("A");

		s.push("B");

		s.push("C");

		System.out.println(s);  //[A,B,C]

		System.out.println(s.search("A"));

		System.out.println(s.search("Z"));  //[-1]
		
		System.out.println(s.peek());
		System.out.println(s);
		
		System.out.println(s.pop());
		System.out.println(s);

	}

}
