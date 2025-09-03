package collections;

import java.util.Vector;

public class Test3 {
	public static void main(String[] args) {
		Vector v = new Vector();
		  v.add(10);
		   v.add("abc");
		   v.add(56.2);
		   v.add(true);
		   v.add(56f);
		   System.out.println(v);
		   v.add(2, 1234);
		   System.out.println(v);
		   System.out.println(v.firstElement());
		   System.out.println(v.lastElement());
		   v.remove(3);
		   System.out.println(v);
	}

}
