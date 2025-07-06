package com.tekgrads;

import java.util.Arrays;
import java.util.Comparator;

public class Example5 {

	public static void main(String[] args) {
		Integer x[] = {100,1,200,1000,20,1500,2};
		System.out.println(Arrays.toString(x));
		Arrays.sort(x);	
		System.out.println(Arrays.toString(x));
		Arrays.sort(x, new MyComparator());
		
		System.out.println(Arrays.toString(x));

	}

}

class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if(o1>o2) {
			return -1;
		} else if(o1<o2) {
			return 1;
		} else {
			return 0;
		}
	}
	
}
