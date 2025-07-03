package com.tekgrads;

class E {
	int i;
	int j;
	
	E(int i, int j) {
		this.i=i;	
		this.j=j;
	}
	
	public int hashCode() {
		return Integer.toString(i).hashCode()+Integer.toString(j).hashCode();
	}
	
	
}
public class Example5 {

	public static void main(String[] args) {
		E e1 = new E(1,2);
		E e2 = new E(1,3);
		System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());
		
	}

}
