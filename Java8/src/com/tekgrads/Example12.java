package com.tekgrads;

import java.util.function.Consumer;

public class Example12 {

	public static void main(String[] args) {
		
		Consumer<String> c1 = s->System.out.println("in consumer c1"+s);
		
		//c1.accept("test");

		Consumer<String> c2 = s->System.out.println("in Consumer c2 "+ s);
		
		Consumer<String> c3 = s->System.out.println("in Consumer c3 "+s);
		
		
		c1.andThen(c2).andThen(c3).accept("Testing");
		
	}

}
