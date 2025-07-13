package com.tekgrads;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Example18 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		list.add("Test");
		list.add("abc");
		list.add("apple");
		list.add("almond");
		list.add("suresh");
		list.add("ramesh");
		
		Optional<String> reduce = list.stream().reduce((s1,s2)->s1+"#"+s2);
		
		//System.out.println(reduce.get());
		reduce.ifPresent(r->System.out.println(r));
		reduce.ifPresentOrElse(r->System.out.println(r), ()->System.out.println("No Value Present"));

	}

}
