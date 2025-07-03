package com.tekgrads;

class D {
	int i;
	int j;
	
	D(int i, int j) {
		this.i=i;
		this.j=j;
	}
	
	@Override
	public String toString() {
		return "D [i=" + i + ", j=" + j + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof D)){
			return false;
		}
		return this.i == ((D)obj).i && this.j == ((D)obj).j;		
	}
	
	
	
	
}
public class Example4 {

	public static void main(String[] args) {
		D d1 = new D(1,2);
		D d2 = new D(1,3);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d1==d2);
		System.out.println(d1.equals(d2));

	}

}
