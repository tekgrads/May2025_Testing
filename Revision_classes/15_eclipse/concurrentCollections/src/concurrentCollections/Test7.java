package concurrentCollections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test7 {
	public static void main(String[] args) {
		CopyOnWriteArrayList l = new CopyOnWriteArrayList();
		l.add("A");
		l.add("B");
		l.add("C");
		Iterator itr = l.iterator();
		l.add("D");
		while(itr.hasNext()) {
			String s = (String)itr.next();
			System.out.println(s);
			}
		System.out.println(l);
	}

}
