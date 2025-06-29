package com.tekgrads.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class MyThreadReentrantDemo4 extends Thread {
	
	ReentrantLock l;
	public MyThreadReentrantDemo4(String name, ReentrantLock l) {
		super(name);
		this.l =l;		
	}
	
	public void run() {
		do {
		try {
			if(l.tryLock(5000, TimeUnit.MILLISECONDS)) {				
				System.out.println(Thread.currentThread().getName()+" "+ "got the lock and "
						+ "performing safe operations");
				
				try {
					Thread.sleep(30000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				l.unlock();
				System.out.println(Thread.currentThread().getName()+" releasing the lock");
				break;
			} else {
				System.out.println(Thread.currentThread().getName()+" "+
			"unable to get the lock and hence try again");
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}while(true);
		
	}
}

public class ReentrantLockDemo4 {

	public static void main(String[] args) {
		ReentrantLock l = new ReentrantLock();
		MyThreadReentrantDemo4 t1 = new MyThreadReentrantDemo4("First Thread",l);
		MyThreadReentrantDemo4 t2 = new MyThreadReentrantDemo4("Second Thread",l);
		t1.start();
		t2.start();
		

	}

}
