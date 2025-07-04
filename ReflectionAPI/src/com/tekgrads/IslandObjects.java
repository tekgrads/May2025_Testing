package com.tekgrads;

class P {
	P p1;
}

public class IslandObjects {

	public static void main(String[] args) {
		P p1 = new P();
		P p2 = new P();
		P p3 = new P();
		p1.p1 = p2;
		p2.p1=p3;
		p3.p1=p1;
		
		p1=p2=p3=null;
		
		System.out.println("Completed");

	}

}
