package com.tekgrads;


interface Interf2 {
	public void m1();	
}

abstract class Test {
	public abstract void m1();	
}

class Test2 {
	public void m1() {
		System.out.println("In Test2 m1");
	}
}

class TestImple extends Test {

	@Override
	public void m1() {
		System.out.println("In Concrete m1 method");
		
	}
	
}


public class Example2 {

	public static void main(String[] args) {
		
		Interf2 i = new Interf2() {
			
			@Override
			public void m1() {
				System.out.println("Inside m1 of InterfImpl2");
				
			}
		};
		
		
		i.m1();
		
		
		Test t = new TestImple();
		t.m1();
		
		Test t2  = new Test() {
			
			@Override
			public void m1() {
				System.out.println("Another Impl of m1 in annonymous inner class");
				
			}
		};
		
		t2.m1();
		
		Test2 t3 = new Test2() {
			@Override
			public void m1() {
				System.out.println("In Anonymous m1 method");
				
			}
		};
		
		t3.m1();
	}

}
