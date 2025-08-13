package multiThreading;

import java.util.concurrent.locks.ReentrantLock;

class MyThread2 extends Thread{
		static ReentrantLock l = new ReentrantLock();
	    public MyThread2(String name) {
	    	super(name);
	    }
	    @Override
	    public void run() {
	    	if(l.tryLock()) {
	    		System.out.println(Thread.currentThread().getName()+" got lock and performing operations");
	    		try {
	    			Thread.sleep(2000);
	    		}
	    		catch (InterruptedException e) {
				}
	    		
	    	l.unlock();
	    	}
	    	else {
	    		System.out.println(Thread.currentThread().getName()+" unable to get lock so performing alternative operations");
	    	}
	    	
	    }
	}
	public class Test28 {
		public static void main(String[] args) {
			MyThread2 t1 = new MyThread2("first thread");
			MyThread2 t2 = new MyThread2("second thread");
			t1.start();
			t2.start();
		}
}
