package com.tekgrads;


interface Interf {
	public void m1();	
}

class InterfImpl implements Interf {

	@Override
	public void m1() {
		System.out.println("Inside m1 of InterfImpl");
		
	}
	
}


public class Example1 {

	public static void main(String[] args) {
		
		Interf i = new InterfImpl();
		
		i.m1();
	}

}
