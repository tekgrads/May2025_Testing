package com.tekgrads;
import java.util.function.Function;
public class Example11 {

	public static void main(String[] args) {
		Function<String,Integer> f = s -> s.length();
		
		System.out.println(f.apply("test"));
		Function<Integer,Integer> f1 = i->i*i;
		System.out.println(f1.apply(10));
		
		Function<String, Integer> f2 = s -> s.length() - s.replaceAll(" ", "").length();
		
		System.out.println(f2.apply("hi this is a fucntion"));
		
		Function<String, String> f4 = s -> s.toUpperCase();
		
		Function<String, String> f5 = s -> s.substring(0,9);
		
		System.out.println(f4.andThen(f5).apply("hi this is a fucntion"));
		
		
		
	}

}
