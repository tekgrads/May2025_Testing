package com.tekgrads;

import java.util.HashMap;

public class Example16 {

	public static void main(String[] args) {
		HashMap map = new HashMap();
		
		map.put(1, "Suresh");
		map.put(2, "Ramesh");
		map.put(3, "Rakesh");
		map.put(4, "Hareesh");
		map.put(null, "Test");
		map.put(5, null);
		map.put(4, "Sateesh");
		
		System.out.println(map);
		
		System.out.println(map.get(1));
		System.out.println(map.get(null));
		

	}

}
