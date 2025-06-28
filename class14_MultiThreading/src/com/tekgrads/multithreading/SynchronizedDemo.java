package com.tekgrads.multithreading;

class Display {
	
	public synchronized  void wish(String name) {
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
	}
}


class MyThreadSyncDemo extends Thread {
	
	Display d;
	String name;
	MyThreadSyncDemo(Display d, String name){
		this.d = d;
		this.name = name;
	}
	
	public void run() {
		d.wish(name);
	}
}


public class SynchronizedDemo {

	public static void main(String[] args) {
		Display d = new Display();
		MyThreadSyncDemo t  = new MyThreadSyncDemo(d, "Dhoni");
		t.start();
		Display d2 = new Display();
		MyThreadSyncDemo t2  = new MyThreadSyncDemo(d2, "Sachin");
		t2.start();
		

	}

}
