package collections;

import java.util.Comparator;
import java.util.TreeSet;

class myComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		String s1 = (String) o1;
		String s2 = (String) o2;
		return -s1.compareTo(s2);
	}
	
}

public class Test12 {
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>(new myComparator());
	//	TreeSet<String> ts = new TreeSet<String>();
		ts.add("A");
		ts.add("Z");
		ts.add("H");
		ts.add("F");
		System.out.println(ts);
		
		
	}

}
