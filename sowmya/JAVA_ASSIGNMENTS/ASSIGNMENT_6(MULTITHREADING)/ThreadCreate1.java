//creating the thread using extends keyword
package com.tekgrads.multithreading;

class Thread1 extends Thread{
	@Override
	public void run() {
	for(int i=0;i<5;i++) {
		System.out.println("creating the thread using extends "+i);
		}
	}
}


public class ThreadCreate1 {

	public static void main(String[] args) {
		Thread1 t1=new Thread1();
		t1.start();
		for(int i=0;i<5;i++) {
			System.out.println("creating the thread on main: "+i);
			}

	}

}
