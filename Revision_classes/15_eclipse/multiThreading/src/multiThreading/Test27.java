package multiThreading;

import java.util.concurrent.locks.ReentrantLock;

class Display{
		ReentrantLock l  =new ReentrantLock();
		public void wish(String name) {
			l.lock();
			for(int i = 0; i<3; i++) {
				System.out.print("Goodmorning: ");
				try {
					Thread.sleep(2000);
				}
				catch (InterruptedException e) {}
					System.out.println(name);
				}
			l.unlock();
			
			
		}
		
	}
	class MyThread extends Thread{
		Display d;
		String name;
		public MyThread(Display d, String name) {
			this.d = d;
			this.name = name;
		}
		@Override
		public void run() {
			d.wish(name);
		}
	}
	public class Test27 {
		public static void main(String[] args) {
			Display d = new Display();
			MyThread t1 = new MyThread(d, "Ram");
			MyThread t2 = new MyThread(d, "Ravi");
			MyThread t3 = new MyThread(d, "Raj");
			t1.start();
			t2.start();
			t3.start();
		}
}
