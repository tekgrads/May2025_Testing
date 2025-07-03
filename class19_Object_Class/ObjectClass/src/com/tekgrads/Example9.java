package com.tekgrads;

class I implements Cloneable{
	int a;
	
	I(int a ){
		this.a = a;
	}
	
	public I cloneMyObj() throws CloneNotSupportedException {
		return (I)this.clone();
	}

	@Override
	public String toString() {
		return "I [a=" + a + "]";
	}	
	
	
}

class J implements Cloneable{
	int b;
	I i;
	
	J(int b, I i){
		this.b=b;
		this.i=i;
	}
	
	public J cloneMyObj() throws CloneNotSupportedException {
		return (J)this.clone();
	}

	@Override
	public String toString() {
		return "J [b=" + b + ", i=" + i + "]";
	}
	
	
	
}

public class Example9 {

	public static void main(String[] args) throws CloneNotSupportedException  {
		I i1 = new I(1);
		I i2 = i1.cloneMyObj();
		i2.a=100;
		System.out.println("----------------------");
		J j1 = new J(2, i1);
		System.out.println("j1= "+j1);
		J j2 = j1.cloneMyObj();
		System.out.println("j2= "+j2);
		j2.i.a = 100;
		System.out.println("j1= "+j1);
		System.out.println("j2= "+j2);
		
		
	}

}
