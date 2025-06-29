package com.tekgrads.multithreading;

class MyThreadDaemon extends Thread {
	
	public void run() {
		for(int i =0;i<10;i++) {
			System.out.println("Child Thread");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class DaemonThreads {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().isDaemon());
		//Thread.currentThread().setDaemon(true);
		MyThreadDaemon t  = new MyThreadDaemon();
		System.out.println(t.isDaemon());
		//t.setDaemon(true);
		t.start();
		System.out.println("Main Completed");
		

	}

}
