package collections;

import java.util.HashSet;

public class Test8 {
	public static void main(String[] args) {
		HashSet hs = new HashSet();
		hs.add(10);
		hs.add("abc");
		hs.add(56.2);
		hs.add(true);
		hs.add(56f);
	    hs.add('b');
	    hs.add(null);
	    System.out.println(hs.add(10));
	    System.out.println(hs.add('a'));
		System.out.println(hs);
		
	}

}
