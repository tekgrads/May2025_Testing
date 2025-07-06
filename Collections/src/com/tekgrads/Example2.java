package com.tekgrads;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

public class Example2 {

	public static void main(String[] args) {
		ArrayList l1=new ArrayList();

		LinkedList l2=new LinkedList();

		System.out.println(l1 instanceof Serializable); //true

		System.out.println(l2 instanceof Cloneable); //true

		System.out.println(l1 instanceof RandomAccess); //true

		System.out.println(l2 instanceof RandomAccess); //false
		
		List l = Collections.synchronizedList(l1);
		
		

	}

}
