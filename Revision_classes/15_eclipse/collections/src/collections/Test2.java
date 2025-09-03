package collections;

import java.util.LinkedList;

public class Test2 {
	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		   l.add(10);
		   l.add("abc");
		   l.add(56.2);
		   l.add(true);
		   l.add(56f);
		   l.add('b');
		   l.add(null);
		   l.add(10);
		   System.out.println(l);
		   l.addFirst("xyz");
		   System.out.println(l);
		   l.addLast(99);
		   System.out.println(l);
		   System.out.println(l.getFirst());
		   System.out.println(l.getLast());
		   l.removeFirst();
		   System.out.println(l);
		   l.removeLast();
		   System.out.println(l);
	}

}
