package com.tekgrads.multithreading;

class MyThreadGroupDemo extends Thread {
	MyThreadGroupDemo(ThreadGroup tg, String name) {
		super(tg, name);
	}
	public void run() {
		System.out.println("Child Thread");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public class ThreadGroupDemo {

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getThreadGroup().getName());
		System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
		
		ThreadGroup parent = new ThreadGroup("Parent");
		ThreadGroup child = new ThreadGroup(parent,"Child");
		
		MyThreadGroupDemo t1 = new MyThreadGroupDemo(parent, "Child Thread 1");
		MyThreadGroupDemo t2 = new MyThreadGroupDemo(parent, "Child Thread 2");
		t1.start();
		t2.start();
		System.out.println(parent.activeCount());
		System.out.println(parent.activeGroupCount());
		parent.list();
		Thread.sleep(10000);
		System.out.println(parent.activeCount());
		System.out.println(parent.activeGroupCount());
		parent.list();
		
	}

}
