package concurrentCollections;

import java.util.ArrayList;
import java.util.Iterator;

public class Test1 {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("E");
		al.add("A");
		al.add("C");
		al.add("B");
		Iterator<String> itr = al.iterator();
		while(itr.hasNext()) {
			String s1 = (String)itr.next();
			System.out.println(s1);
			al.add("G");
		}
	}

}
