package com.tekgrads.multithreading;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		for(int i =1;i<11;i++) {
			System.out.println("Child Thread "+i);
		}		
	}	
}

public class Example2 {

	public static void main(String[] args) {
		MyRunnable r = new MyRunnable();		
		Thread t = new Thread(r);
		Thread t2 = new Thread(r);
		t.start();
		t2.start();
		r.run();
		//r.start();
		for(int i = 1; i< 11;i++) {
			System.out.println("Main thread "+i);
		}

	}

}
