package com.tekgrads;

import java.util.ArrayList;

public class Example1 {

	public static void main(String[] args) {
		
		ArrayList al = new ArrayList();
		
		al.add(1);
		al.add("One");
		al.add(200.00);
		al.add('c');
		al.add(null);		
		System.out.println(al);
		
		al.remove(2);
		
		System.out.println(al);
		
		al.add(2, "New Element");
		System.out.println(al);
		System.out.println(al.get(2));
		
		System.out.println(al.contains(1));
		
		ArrayList al2 = new ArrayList();
		al2.add(1);
		al2.add("One");
		System.out.println(al.containsAll(al2));
		al2.add("Three");
		System.out.println(al.containsAll(al2));
		
		System.out.println("Pritning ArrayList");
		System.out.println(al);
		al.remove(0);
		al.remove("One");
		System.out.println(al);
		
		
	}

}
