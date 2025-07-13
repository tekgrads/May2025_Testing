package com.tekgrads;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example20 {

	public static void main(String[] args) {
		List<List<Integer>> listOfIntegerList = new ArrayList<>();
		List<Integer> firstList = new ArrayList<>();
		firstList.add(1);
		firstList.add(2);
		firstList.add(3);
		List<Integer> secondList = new ArrayList<>();
		secondList.add(4);
		secondList.add(5);
		secondList.add(6);
		List<Integer> thirdList = new ArrayList<>();
		thirdList.add(7);
		thirdList.add(8);
		thirdList.add(9);
		listOfIntegerList.add(firstList);
		listOfIntegerList.add(secondList);
		listOfIntegerList.add(thirdList);
		
		System.out.println(listOfIntegerList);
		
		List<Integer> result = listOfIntegerList.stream()
				.flatMap(p->p.stream())
				.collect(Collectors.toList());
		System.out.println(result);

	}

}
