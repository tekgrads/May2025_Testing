package com.tekgrads;

class C{
	int i;
	C(int i){
		this.i= i;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof C)){
			return false;
		}
		return this.i == ((C)obj).i;		
		
	}
}
public class Example3 {

	public static void main(String[] args) {
		int i = 1;
		int j =1;
		C c1 = new C(1);
		C c2 = new C(1);
		System.out.println(c1 == c2);
		System.out.println(i == j);
		
		System.out.println(c1.equals(c2));

	}

}
