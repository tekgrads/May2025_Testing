package com.tekgrads.multithreading;

class A {
	
	public synchronized void d1(B b) {
		System.out.println("Thread starts execution of d1");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread calling b's last method");
		b.last();
	}
	
	public synchronized void last() {
		System.out.println("Inside A last method");
	}
}



class B {
	
	public synchronized void  d2(A a) {
		System.out.println("d2 started by Thread");
		try {
			Thread.sleep(5000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread calling a's last method");
		a.last();
	}
	
	public synchronized void last() {
		System.out.println("Inside B last method");
	}
}


class MyThreadDeadLock extends Thread {
	
	A a = new A();
	B b = new B();
	
	public void m1() {
		this.start();
		a.d1(b);
	}
	public void run() {
		b.d2(a);
	}
}


public class DeadLock {

	public static void main(String[] args) {
		MyThreadDeadLock t = new MyThreadDeadLock();
		t.m1();

	}

}
