package com.tekgrads.multithreading;

public class Example8 {

	public static void main(String[] args) {
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 1;i<11;i++) {
			System.out.println("Main Thread "+i);
		}
	}

}
