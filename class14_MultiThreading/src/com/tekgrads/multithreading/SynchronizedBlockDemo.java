package com.tekgrads.multithreading;

class DisplayBlock {
	
	public void wish(String name) {
		System.out.println("Before Synchronized Block");
		synchronized(this) {
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
}


class MyThreadSyncBlockDemo extends Thread {
	
	DisplayBlock d;
	String name;
	MyThreadSyncBlockDemo(DisplayBlock d, String name){
		this.d = d;
		this.name = name;
	}
	
	public void run() {
		d.wish(name);
	}
}


public class SynchronizedBlockDemo {

	public static void main(String[] args) {
		DisplayBlock d = new DisplayBlock();
		MyThreadSyncBlockDemo t  = new MyThreadSyncBlockDemo(d, "Dhoni");
		t.start();
		//DisplayBlock d2 = new DisplayBlock();
		MyThreadSyncBlockDemo t2  = new MyThreadSyncBlockDemo(d, "Sachin");
		t2.start();
		

	}

}
