package com.tekgrads;

class A {
	
	A(){
		System.out.println("In A constructor");
	}
	
}

interface IA {
	
	public A get();
}

public class Example15 {

	public static void main(String[] args) {
	
		IA i = ()-> new A();
		
		i.get();
		
		IA i2 = A::new;
		
		i2.get();

	}

}
