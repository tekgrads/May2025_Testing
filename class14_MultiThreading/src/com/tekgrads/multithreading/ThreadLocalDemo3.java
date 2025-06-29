package com.tekgrads.multithreading;


class CustomerThread extends Thread {
	static Integer custId = 0;
	private static ThreadLocal tl = new ThreadLocal() {
		protected Object initialValue() {
			return ++custId;
		}
	};
	
	CustomerThread(String name){
		super(name);
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName()+" executing with customerid: "+ tl.get());
	}
}
public class ThreadLocalDemo3 {

	public static void main(String[] args) {
		
		CustomerThread c1 = new CustomerThread("Cutosmer Trhead 1");
		
		CustomerThread c2 = new CustomerThread("Cutosmer Trhead 2");
		
		CustomerThread c3 = new CustomerThread("Cutosmer Trhead 3");
		c1.start();
		c2.start();
		c3.start();

	}

}
