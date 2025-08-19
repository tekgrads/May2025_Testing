package stringHandling;

import java.util.Arrays;

public class Test4 {
	public static void main(String[] args) {
		String s = "java programming language";
		System.out.println(s.length());
		System.out.println(s.charAt(10));
		System.out.println(s.substring(5));
		System.out.println(s.substring(5, 16));
		System.out.println(s.charAt(s.length()-1));
		System.out.println(s.indexOf('v'));
		System.out.println(s.indexOf('z'));
		System.out.println(s.indexOf('a', 11));
		System.out.println(s.lastIndexOf('a'));
		System.out.println(s.toUpperCase());
		String s1 = "ABCDEF";
		System.out.println(s1.toLowerCase());
		System.out.println(s.startsWith("program"));
		System.out.println(s.startsWith("java"));
		System.out.println(s.endsWith("e"));
		System.out.println(s.endsWith("g"));
		String[] words = s.split("a");
		System.out.println(Arrays.toString(words));
		System.out.println(s1.replace('C', 'Z'));
		

	}

}
