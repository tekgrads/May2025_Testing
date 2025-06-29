package com.tekgrads.multithreading;

import java.util.concurrent.locks.ReentrantLock;

class MyThreadReentrantDemo3 extends Thread {
	
	ReentrantLock l;
	public MyThreadReentrantDemo3(String name, ReentrantLock l) {
		super(name);
		this.l =l;		
	}
	
	public void run() {
		if(l.tryLock()) {				
			System.out.println(Thread.currentThread().getName()+" "+ "got the lock and "
					+ "performing safe operations");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			l.unlock();
		} else {
			System.out.println(Thread.currentThread().getName()+" "+
		"unable to get the lock and hence performing aternative operations");
		}
		
	}
}

public class ReentrantLockDemo3 {

	public static void main(String[] args) {
		ReentrantLock l = new ReentrantLock();
		MyThreadReentrantDemo3 t1 = new MyThreadReentrantDemo3("First Thread",l);
		MyThreadReentrantDemo3 t2 = new MyThreadReentrantDemo3("Second Thread",l);
		t1.start();
		t2.start();
		

	}

}
