package com.tekgrads;

import java.util.LinkedList;

public class Example4 {

	public static void main(String[] args) {
		LinkedList ll=new LinkedList();

		ll.add("durga");

		ll.add(30);

		ll.add(null);

		ll.add("durga");
		System.out.println(ll);

		ll.set(0,"software");
		System.out.println(ll);

		ll.add(0,"venkey");
		System.out.println(ll);

		ll.addFirst("ece");
		System.out.println(ll);

	}

}
