package concurrentCollections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Test3 extends Thread{
//	static HashMap m = new HashMap();
	static ConcurrentHashMap m = new ConcurrentHashMap();
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("child thread updating Map");
		m.put(103, "C");
	}
	public static void main(String[] args) throws InterruptedException {
		m.put(101, "A");
		m.put(102, "B");
		Test3 t = new Test3();
		t.start();
		Set s = m.keySet();
		Iterator itr = s.iterator();
		while(itr.hasNext()) {
			Integer i = (Integer) itr.next();
			System.out.println("main thread iterating and current entry is: " +
			    i + " ----" + m.get(i));
			Thread.sleep(5000);
		}
		System.out.println(m);
	}
	
}
