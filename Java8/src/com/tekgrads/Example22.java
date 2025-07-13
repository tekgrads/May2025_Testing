package com.tekgrads;

import java.lang.StackWalker.Option;
import java.util.Optional;

public class Example22 {

	public static void main(String[] args) {
		Optional<String> gender = Optional.of("MALE");
		
		if(gender.isPresent()) {
			System.out.println(gender.get());
		}
		
		String str = "Yes";
		String str2 = null;
		
		Optional<String> answer = Optional.ofNullable(str2);
		
		answer.ifPresentOrElse(s->System.out.println(s),()->System.out.println("Not Presetn"));

	}

}
