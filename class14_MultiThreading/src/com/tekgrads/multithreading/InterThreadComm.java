package com.tekgrads.multithreading;


class ThreadComm extends Thread {
	int total = 0;
	public void run() {
		synchronized(this) {
			System.out.println("Child Thread Execution Started");
		for(int i=0;i<=100;i++) {
			total = total+i;
		}
		System.out.println("Child Thread Giving Notification");
		this.notify();
		}
	}
}

public class InterThreadComm {

	public static void main(String[] args)   {
		ThreadComm t = new ThreadComm();
		t.start();
//		try {
//			Thread.currentThread().sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		synchronized(t) {
		try {
			System.out.println("Main thread calling wait");
			t.wait(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		System.out.println("Main Thread got notification "+t.total);

	}

}
