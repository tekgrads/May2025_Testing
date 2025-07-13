package com.tekgrads;

import java.util.Date;
import java.util.function.*;

public class Example13 {

	public static void main(String[] args) {
		Supplier<Date> s = ()->new Date();
		
		System.out.println(s.get());

	}

}
