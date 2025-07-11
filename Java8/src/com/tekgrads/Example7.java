package com.tekgrads;

interface J {
	public static void m1() {
		System.out.println("iterface static method");
	}
}

class TestS implements J {
	
	public static void m1() {
		
	}
	
//	public void m1() {
//		
//	}
	
}

public class Example7 {

	public static void main(String[] args) {
		J.m1();
		
		TestS ts = new TestS();
		
		//ts.m1(); np
		
		//Tests.m1(); np

	}

}
