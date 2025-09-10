package concurrentCollections;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test4 {
	public static void main(String[] args) {
		CopyOnWriteArrayList l = new CopyOnWriteArrayList();
		l.add("A");
		l.add("B");
		l.add("C");
		System.out.println(l);
		l.addIfAbsent("C");
		l.addIfAbsent("D");
		System.out.println(l);
		ArrayList al = new ArrayList();
		al.add("A");
		al.add("D");
		al.add("E");
	//	al.add(l);
	//	System.out.println(al);
		l.addAllAbsent(al);
		System.out.println(l);
	}

}
