package com.tekgrads.multithreading;

class DisplayCharNumber {
	
	
	public synchronized void displayNumber() {
		for(int i = 1 ;i<11;i++) {
			System.out.println(i);
			try {
				Thread.sleep(2000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void displayChar() {
		for(int i = 1 ;i<11;i++) {
			System.out.println((char)('A' + i - 1));
			try {
				Thread.sleep(2000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThreadSyncCharDemo extends Thread {
	
	DisplayCharNumber d;
	
	MyThreadSyncCharDemo(DisplayCharNumber d){
		this.d = d;
		
	}
	
	public void run() {
		d.displayChar();
	}
}


class MyThreadSyncNumberDemo extends Thread {
	
	DisplayCharNumber d;
	
	MyThreadSyncNumberDemo(DisplayCharNumber d){
		this.d = d;
		
	}
	
	public void run() {
		d.displayNumber();
	}
}

public class SynchronizedDemo2 {

	public static void main(String[] args) {
		DisplayCharNumber d = new DisplayCharNumber();
		MyThreadSyncCharDemo t1 = new MyThreadSyncCharDemo(d);
		MyThreadSyncNumberDemo t2 = new MyThreadSyncNumberDemo(d);
		t1.start();
		t2.start();

	}

}
