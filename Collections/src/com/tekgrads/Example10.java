package com.tekgrads;

import java.util.HashSet;

public class Example10 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
		
		set.add(1);		
		set.add(1);
		set.add(2);
		set.add(2);
		set.add(3);
		set.add(null);
		
		System.out.println(set);
		
		
		
	}

}
