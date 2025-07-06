package com.tekgrads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Example3 {

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		
		System.out.println(l);
		
		l.addFirst(0);
		l.addLast(5);
		System.out.println(l);
		
		
		ArrayList al = new ArrayList();
		
		LinkedList ll = new LinkedList(al);
		

	}

}
