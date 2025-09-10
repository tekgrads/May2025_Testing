package concurrentCollections;

import java.util.concurrent.CopyOnWriteArraySet;

public class Test8 {
	public static void main(String[] args) {
		CopyOnWriteArraySet s = new CopyOnWriteArraySet();
		s.add("D");
		s.add("B");
		s.add("A");
		s.add(null);
		s.add(10);
		s.add("C");
		s.add("D");
		System.out.println(s);
	}

}
