//creating the thread using implementing the runnable interface
package com.tekgrads.multithreading;
class Runnable1 implements Runnable{
	@Override
	public void run() {
	for(int i=0;i<5;i++) {
		System.out.println("creating the thread using runnable interface "+i);
		}
	}
	
}

public class ThreadCreate2 {

	public static void main(String[] args) {
		Runnable1 r=new Runnable1();
		Thread t2=new Thread();
		t2.start();
		r.run();
		for(int i=0;i<5;i++) {
			System.out.println("creating the thread using runnable interface on main  "+i);
			}
		

	}

}
