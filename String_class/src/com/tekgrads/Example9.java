package com.tekgrads;

public class Example9 {

	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("abc");
		
		StringBuffer s2 = new StringBuffer("abc");
		
		System.out.println(s1 == s2);
		
		System.out.println(s1.equals(s2));
		
		System.out.println(s1.hashCode() == s2.hashCode());
		
		System.out.println(s1.reverse());

	}

}
