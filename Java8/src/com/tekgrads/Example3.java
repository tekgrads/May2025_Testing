package com.tekgrads;


interface Interf3 {
	public void m1();	
	//public void m2();	
}

public class Example3 {

	public static void main(String[] args) {
		
		Interf3 i = ()->System.out.println("in lambda Expression m1 method");
				
		i.m1();
	}

}
