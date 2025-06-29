package com.tekgrads.multithreading;

import java.util.concurrent.locks.ReentrantLock;

class DisplayReentrant {
	
	ReentrantLock l = new ReentrantLock();
	
	public  void wish(String name) {
		l.lock();
		for(int i =1;i<11;i++) {
			System.out.println("Good Morning "+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name);
		}
		l.unlock();
	}
}


class MyThreadReentrantDemo extends Thread {
	
	DisplayReentrant d;
	String name;
	MyThreadReentrantDemo(DisplayReentrant d, String name){
		this.d = d;
		this.name = name;
	}
	
	public void run() {
		d.wish(name);
	}
}


public class ReentrantDemo2 {

	public static void main(String[] args) {
		DisplayReentrant d = new DisplayReentrant();
		MyThreadReentrantDemo t  = new MyThreadReentrantDemo(d, "Dhoni");
		t.start();		
		MyThreadReentrantDemo t2  = new MyThreadReentrantDemo(d, "Sachin");
		t2.start();
		

	}

}
