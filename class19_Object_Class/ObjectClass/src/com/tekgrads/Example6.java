package com.tekgrads;

class F implements Cloneable{
	int i;
	F(int i){
		this.i=i;
	}
	
	public F cloneMyObj() throws CloneNotSupportedException {
		return (F)this.clone();
	}

	@Override
	public String toString() {
		return "F [i=" + i + "]";
	}
	
	
}

public class Example6 {
	

	public static void main(String[] args) throws CloneNotSupportedException  {
		F f = new F(1);
		
		F f2 = f.cloneMyObj();
		
		System.out.println(f);
		System.out.println(f2);
		

	}

}
