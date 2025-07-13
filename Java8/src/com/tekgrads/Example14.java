package com.tekgrads;

interface Intf {
	public void m1();
}

class TestIntf {
	public static void m2() {
		System.out.println("In TestInf m2 method");
	}
	
	public  void m3() {
		System.out.println("In TestInf m3 method");
	}
}

public class Example14 {

	public static void main(String[] args) {
		
		Intf f = ()->System.out.println("lambda of m1 in intf");
		f.m1();
		
		Intf f2 = TestIntf :: m2;
		
		f2.m1();
		
		TestIntf test = new TestIntf();
		
		Intf f3  = test :: m3;
		
		f3.m1();
	}

}
