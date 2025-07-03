package com.tekgrads;

class B {
	int i, j;
	
	B(int i, int j){
		this.i=i;
		this.j=j;
	}
	
//	public String toString() {
//		return "i="+i+", "+"j="+j;
//	}
}
public class Example2 {

	public static void main(String[] args) {
		B b1 = new B(1,2);
		System.out.println(b1);
		
		B b2 = new B(10,20);
		System.out.println(b2);

	}

}
