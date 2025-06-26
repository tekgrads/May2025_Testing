package com.tekgrads.multithreading;

class MyThread2 extends Thread {
	
	@Override
	public void run() {	
		for(int i =1;i<11;i++) {
			System.out.println("Child Thread "+i);
		}
	}
	
}
public class Example3 {

	public static void main(String[] args) {
		MyThread2 myThread = new MyThread2();
		Thread t = new Thread(myThread);
		t.start();
		for(int i = 1; i< 11;i++) {
			System.out.println("Main thread "+i);
		}

	}

}
