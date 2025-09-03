package collections;

import java.util.ArrayList;

public class Test1 {
	public static void main(String[] args) {
	   ArrayList al = new ArrayList();
		   al.add(10);
		   al.add("abc");
		   al.add(56.2);
		   al.add(true);   
		   al.add(56f);
		   al.add('b');
		   al.add(null);
		   al.add(10);
		   System.out.println(al);
		   al.remove(2);
		   System.out.println(al);
		   al.removeFirst();
		   System.out.println(al);
		   System.out.println(al.get(3));
		   System.out.println(al.indexOf("abc"));
		   System.out.println(al.indexOf("xyz"));
		   al.removeLast();
		   System.out.println(al);
	   
	}
}
