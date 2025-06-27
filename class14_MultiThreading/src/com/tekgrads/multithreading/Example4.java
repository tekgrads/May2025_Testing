package com.tekgrads.multithreading;

class MyRunnable1 implements Runnable {
	
	@Override
	public void run() {			
		for(int i =1;i<11;i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	
}
public class Example4 {

	public static void main(String[] args) {
		MyRunnable1 r = new MyRunnable1();
		Thread t = new Thread(r,"Child-0");
//		System.out.println("Priority of child-0"+ t.getPriority());
//		System.out.println("Priority of main"+ Thread.currentThread().getPriority());
		t.setPriority(10);
		t.start();
		for(int i = 1; i< 11;i++) {
			System.out.println("Main thread "+i);
		}

	}

}
