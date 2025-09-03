package collections;

import java.util.LinkedList;
import java.util.ListIterator;

public class Test7 {
	public static void main(String[] args) {
		LinkedList li = new LinkedList();
		li.add("abc");
		li.add("pqr");
		li.add("xyz");
		li.add("hyd");
		li.add("java");
		System.out.println(li);
		ListIterator ltr = li.listIterator();
		while(ltr.hasNext()) {
			String s = (String) ltr.next();
			if(s.equals("pqr")) {
				ltr.remove();
			}
			else if(s.equals("hyd")) {
				ltr.set("HYD");
			}
			else if(s.equals("java")) {
				ltr.add("full stack");
			}
			System.out.println(li);
		}
		
		
	}

}
