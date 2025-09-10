package concurrentCollections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test5 extends Thread{
//	static ArrayList l = new ArrayList();
	static CopyOnWriteArrayList l = new CopyOnWriteArrayList();
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("child thread updating Map");
		l.add("C");
	}
	public static void main(String[] args) throws InterruptedException {
		l.add("A");
		l.add("B");
		Test5 t = new Test5();
		t.start();
		Iterator itr = l.iterator();
		while(itr.hasNext()) {
			String s = (String) itr.next();
			System.out.println("main thread iterating and current entry is: " +
			    s);
			Thread.sleep(5000);
		}
		System.out.println(l);
	}
	
}
