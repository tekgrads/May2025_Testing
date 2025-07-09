# What is Multithreading in Java

What is Multithreading in Java?
Multithreading is a programming concept where multiple threads (lightweight subprocesses) run concurrently to perform multiple tasks simultaneously.

✅ Why Multithreading?
Improves CPU utilization

Enables parallelism

Makes programs faster and more responsive

Useful in real-time apps like games, servers, GUIs, etc.

EXAMPLE:
Method 1: Extend the Thread class
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

Method 2: Implement the Runnable interface
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

Thread Lifecycle
New → thread object created

Runnable → ready to run

Running → executing run() method

Blocked/Waiting → waiting for a resource

Terminated → finished execution

EXAMPLE:


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
