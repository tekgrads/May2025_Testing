package com.tekgrads;

import java.util.function.Predicate;

public class Example10 {

	public static void main(String[] args) {
		Predicate<String> p1 = str -> str.length()>10;
		
		System.out.println(p1.test("test"));
		System.out.println(p1.test("test12345679010"));
		System.out.println("---------------");
		Predicate<String> p2 = Predicate.isEqual("Testing");
		System.out.println(p2.test("test"));
		System.out.println(p2.test("Testing"));
		
		Predicate<Integer> p3 = i -> i>10;
		Predicate<Integer> p4 = i -> i%2==0;
		System.out.println("---------------");
		System.out.println(p3.and(p4).test(20));
		System.out.println(p3.and(p4).test(4));
		System.out.println(p3.negate().test(11));
		
	}

}
