package com.tekgrads.multithreading;


class MyThread6 extends Thread {
	public void run() {
		for(int i = 1; i< 11;i++) {
			System.out.println("Child Thread "+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
public class Example9 {

	public static void main(String[] args) {
		MyThread6 t = new MyThread6();
		t.start();
		t.interrupt();
		for(int i = 1;i<11;i++) {
			System.out.println("Main Thread "+i);
		}
	}

}
