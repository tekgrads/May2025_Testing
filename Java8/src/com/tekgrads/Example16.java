package com.tekgrads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Example16 {

	public static void main(String[] args) {
		
		Stream<Integer>  stream = Stream.of(1,2,3,4,4);
		Stream<Integer> stream2 = Stream.of(new Integer[]{1,2,3,4});
		
		System.out.println(stream2.count());
		
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<=100;i++) {
			list.add(i);
		}
			
			
		Stream<Integer> stream3 = list.stream();
		System.out.println(stream3.count());
		
//		Stream<Date> stream4 = Stream.generate(()->new Date());
//		
//		System.out.println(stream4.count());
		
		System.out.println(IntStream.range(1, 100).sum());
		System.out.println(IntStream.range(1, 100).average());
		List<Integer> evens = IntStream.range(1, 100).filter(i->i%2==0).boxed().collect(Collectors.toList());
		
		System.out.println(evens);
		
		List<Integer> evens2 = list.stream().filter(i->i%2==0).collect(Collectors.toList());
		System.out.println(evens2);
		
		
		
	}

}
