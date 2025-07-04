package com.tekgrads;

public class Example6 {

	public static void main(String[] args) {
		String s1 = "abcc";
		System.out.println(s1.length());
		System.out.println(s1.charAt(1));
		System.out.println(s1.indexOf('b'));
		
		System.out.println(s1.lastIndexOf('c'));
		
		System.out.println(s1.substring(1));
		System.out.println(s1.substring(1,2));

		System.out.println(s1.toUpperCase());
	}

}
