package com.tekgrads;

abstract class ABS {
	int a =10;
	public void m1() {
		
	}
}


interface Left {
	int a=10;
	default void m1() {
		System.out.println("left DM");
	}
}

interface Right {
	default void m1() {
		System.out.println("Right RM");
	}
}


class TestLR implements Left, Right{
	
	public void m1() {
		//System.out.println("Ovveridden m1");
		Right.super.m1();
	}
}

public class Example6 {

	public static void main(String[] args) {
		TestLR tlr = new TestLR();
		tlr.m1();

	}

}
