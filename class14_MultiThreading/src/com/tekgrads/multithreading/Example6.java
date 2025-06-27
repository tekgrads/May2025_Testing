package com.tekgrads.multithreading;


class MyThread4 extends Thread {
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
public class Example6 {

	public static void main(String[] args) {
		MyThread4 t = new MyThread4();
		t.start();
		try {
			t.join(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 1;i<11;i++) {
			System.out.println("Main Thread "+i);
		}
	}

}
