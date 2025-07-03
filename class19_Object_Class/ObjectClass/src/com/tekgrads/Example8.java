package com.tekgrads;

class H implements Cloneable{
	int i;
	int j;
	H(int i, int j){
		this.i=i;
		this.j=j;
	}
	
	public H cloneMyObj() throws CloneNotSupportedException {
		return (H)this.clone();
	}

	@Override
	public String toString() {
		return "H [i=" + i + ", j=" + j + "]";
	}
	
	
}
public class Example8 {

	public static void main(String[] args) throws CloneNotSupportedException {			
		H h1 = new H(1,2);
		System.out.println(h1);
		chageHValues(h1);
		System.out.println("After executing chageHValues");
		System.out.println(h1);
		
		int i =100;
		
		System.out.println("i ="+i);
		chagePrimitive(i);
		System.out.println("After executing chagePrimitive");
		System.out.println("i ="+i);
	}
	
	
	
	public static void chageHValues(H h2) {
		System.out.println("Entered in chageHValues");
		
		h2.i=100;
		h2.j=1000;
		
		System.out.println("Exited from chageHValues");
	}
	
	public static void chagePrimitive(int i) {
		System.out.println("Entered in chagePrimitive");
		
		
		i =1000;
		System.out.println("Exited from chagePrimitive");
	}
	
	
	

}
