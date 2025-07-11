package com.tekgrads;

interface I {
	 default void m1() {
		System.out.println("Default Method");
	}
}

class TestI implements I {
	
	public void m1() {
		System.out.println("Ovverriden Method");
	}
}



public class Example5  {

	public static void main(String[] args) {
		
			TestI i = new TestI();
			i.m1();
	}

}
