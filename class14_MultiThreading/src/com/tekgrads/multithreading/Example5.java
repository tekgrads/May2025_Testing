package com.tekgrads.multithreading;

class MyThreadYeild extends Thread {
	public void run() {
		for(int i =1;i<11;i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
			Thread.yield();
		}
	}
}

public class Example5 {

	public static void main(String[] args) {
		MyThreadYeild t = new MyThreadYeild();
		t.setName("Child-0");	
		t.start();
		for(int i = 1; i< 11;i++) {
			System.out.println("Main thread "+i);
		}
		
		

	}

}
