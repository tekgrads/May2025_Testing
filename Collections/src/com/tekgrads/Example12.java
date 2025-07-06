package com.tekgrads;

import java.util.Comparator;
import java.util.TreeSet;

public class Example12 {

	public static void main(String[] args) {
		TreeSet treeSet = new TreeSet(new MyComparator());
		
		treeSet.add(100);
		treeSet.add(10);
		treeSet.add(50);		
		treeSet.add(6);
		treeSet.add(6);
		treeSet.add(1);
		//treeSet.add(null);
		
		System.out.println(treeSet);

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
