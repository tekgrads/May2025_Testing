package collections;

import java.util.Comparator;
import java.util.TreeMap;

public class Test18 {
	public static void main(String[] args) {
		TreeMap t = new TreeMap();
		t.put(103, "z");
		t.put(106, "y");
		t.put(101, 999);
	//	t.put("ff", "z");
	//	t.put(null, "z");
		System.out.println(t);
		
		TreeMap t1 = new TreeMap(new myComparator2());
		t1.put("X", 10);
		t1.put("A", 30);
		t1.put("Z", 20);
		t1.put("L", 40);
		System.out.println(t1);
	}

}
class myComparator2 implements Comparator{
	public int compare(Object o1 , Object o2) {
		String s1 = (String)o1;
		String s2 = (String)o2;
	//	return s2.compareTo(s1);
		return s1.compareTo(s2);
	}
}
