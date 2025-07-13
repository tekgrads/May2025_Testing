package com.tekgrads;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example17 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("Test");
		list.add("abc");
		list.add("apple");
		list.add("almond");
		list.add("suresh");
		list.add("ramesh");
		
		List<String> result = list.stream().filter(p->p.startsWith("a")).map(p->p.toUpperCase()).collect(Collectors.toList());
		
		System.out.println(result);
		System.out.println("--------------------");
		 list.stream().filter(p->p.startsWith("a")).map(p->p.toUpperCase()).forEach(s->System.out.println(s));
		 
		 
		System.out.println( list.stream().anyMatch(p->p.startsWith("a")));
		System.out.println( list.stream().allMatch(p->p.startsWith("a")));
		System.out.println( list.stream().noneMatch(p->p.startsWith("a")));
		 
	}

}
