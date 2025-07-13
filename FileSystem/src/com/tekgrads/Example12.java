package com.tekgrads;

 class Test {
	final int i =10;
	public  final void test() {
		System.out.println("in test");
	}
	
}

class TestC extends Test {
//	@Override
//	public  final void test() {
//		System.out.println("in test");
//	}
}

public class Example12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Test t = new Test();
		//t.i=100;

	}

}
