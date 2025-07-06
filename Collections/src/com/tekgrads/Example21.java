package com.tekgrads;

import java.util.ArrayList;
import java.util.List;

public class Example21 {

	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(1);
		al.add("test");
		System.out.println(al);

		List<String> list = new ArrayList<>();

		list.add("Test");
		list.add("Test2");
		// list.add(1);
		System.out.println(list);

		List<?> list2 = new ArrayList<>();

//		list2.add("Test");
//		list2.add(1);
		
		
		List<? extends Number> list3 = new ArrayList<>();
		
		//list3.add(1);
		
		List<? super Number> list4 = new ArrayList<>();
		list4.add(1);
		list4.add(2.0);
		
		System.out.println(list4);
		
		

	}

}
