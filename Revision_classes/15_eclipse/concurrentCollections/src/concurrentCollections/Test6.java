package concurrentCollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test6 {
	public static void main(String[] args) {
		CopyOnWriteArrayList l = new CopyOnWriteArrayList();
	//	ArrayList l = new ArrayList();
		l.add("A");
		l.add("B");
		l.add("C");
		l.add("D");
		Iterator itr = l.iterator();
		while(itr.hasNext()) {
			String s = (String)itr.next();
			System.out.println(s);
			if(s.equals("D"))
			itr.remove();
		}
		System.out.println(l);
	}

}
