package com.tekgrads.multithreading;


class MyThread extends Thread {
	
	
//	public void start() {
//		//super.start();
//		System.out.println("Start Method");
//	}
	
	@Override
	public void run() {
		//System.out.println(Thread.currentThread().getName() +" in MyThread class");
		//System.out.println(Thread.currentThread().getPriority());
		//Thread.currentThread().setPriority(10);
		for(int i =1;i<11;i++) {
			System.out.println("Child Thread "+i);
		}
	}
	
	public void run(int i) {
		System.out.println("Overloaded Run method");
	}
	
}

public class Example1 {

	public static void main(String[] args) {
		
		MyThread myThread = new MyThread();
		myThread.start();
		myThread.start();
		for(int i = 1; i< 11;i++) {
			System.out.println("Main thread "+i);
		}
		//System.out.println(Thread.currentThread().getName()+" in main method");
		//System.out.println(Thread.currentThread().getPriority());
		
		//System.out.println(Thread.currentThread().getName()+" in main method");
		

	}

}
