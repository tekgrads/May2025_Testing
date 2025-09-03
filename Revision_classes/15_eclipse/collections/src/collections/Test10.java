package collections;

import java.util.LinkedHashSet;

public class Test10 {
	public static void main(String[] args) {
		LinkedHashSet lhs = new LinkedHashSet();
		lhs.add(10);
		lhs.add("abc");
		lhs.add(56.2);
		lhs.add(true);
		lhs.add(56f);
	    lhs.add('b');
	    lhs.add(null);
	    System.out.println(lhs.add(10));
		System.out.println(lhs);
		
	}

}