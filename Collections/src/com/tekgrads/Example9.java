package com.tekgrads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Example9 {

	public static void main(String[] args) {
		ArrayList l = new ArrayList();

		for(int i=0;i<10;i++) {
			l.add(i);
		}

		System.out.println(l); //[0,1,2,---10]
		
		ListIterator ltr = l.listIterator();
		
		while (ltr.hasNext()) {
			Integer i = (Integer) ltr.next();
			if((i%2) == 0) {
				System.out.println(i);
//				ltr.remove();
//				ltr.add(10);
				ltr.set(10);
			}
		}
		System.out.println(l); 
		
		
		while (ltr.hasPrevious()) {
			Integer i = (Integer) ltr.previous();
				System.out.println(i);
				
		}

	}

}
