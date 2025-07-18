//Create a thread that prints numbers from 1 to 10 with a 1-second delay between each number using Thread.sleep().

package com.tekgrads.multithreading;
class MyThread3 extends Thread{
	public void run() {
		for(int i = 1; i< 11;i++) {
			System.out.println("Thread "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class ThreadSleep1 {

	public static void main(String[] args) {
		MyThread3 t3=new MyThread3();
		t3.start();

	}

}
