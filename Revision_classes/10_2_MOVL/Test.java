class A1			{ void m1(){ }  }
											
class B1 extends A1	{ void m1(){ }	} 


class A2			{ void m1(){ } }
											
//class B2 extends A2	{ int  m1() { return 5; }	}

class A3			{ long m1(){ return 5;} }											
//class B3 extends A3	{ int m1() { return 7;}	}

class P {  }
class Q extends P {  }  //sub type is called as co-varient returns
class R { }

class A41 {P m1()  { return new P();  } }
class B41 extends A41	 { P m1()  { return new Q();  } }
class C41 extends A41	{ Q m1(){ return new Q();  } }
//class D41 extends A41	{ Object m1(){ return new Q();  } } 
//class E41 extends A41	{ R m1(){ return new R();  } } 


//Rule #2

class A5			{ int m1(){ return 5;} }											
class B5 extends A5 { int m1(){return 7; } }
//class C5 extends A5 { static int m1() { return 7;}	}

class A6			{ static int m1(){ return 5;} }											
class B6 extends A6	{ static int m1(){return 7; } }
//class C6 extends A6	{ int m1() { return 7;}	}


//Rule #3: on AM (private < default < protected < public)

class A7			{ int m1(){ return 5;} }										
//class B7 extends A7 { private int m1() { return 7;}	}
class C7 extends A7	{ int m1() { return 7;}	}
class D7 extends A7	{ protected int m1() { return 7;}	}
class E7 extends A7 { public int m1() { return 7;}	}

//========================================================================
class A8			{ private int m1() { return 5;} }							
class B8 extends A8 { private int m1() { return 7;}	}
class C8 extends A8 { private long m1(){ return 7;}	}
class D8 extends A8	{ static double m1() { return 7;}	}
class E8 extends A8	{ protected static int m1() { return 7;}	}
class F8 extends A8 { public int m1() { return 7;}	}

//=========================================================

class A9 {
	void m1(){ }
//	void m1(){ }		//overrdiing, we can not override in same class -> CE
	void m1(int a){ }	//overloading, allowed in same class, diff signature method
//	void m1(int i){ }	     
	void m1(float a){ }	
	void m1(int a, int b){ }	

	int  m1(String a){ return 5; }	
	static int  m1(double a){ return 5; }	
	private static int  m1(long a){ return 5; }	

	//String m1(int a){ return "a";}

}

class TestCase {
	void testProcess() {
		System.out.println("Hi");
	}
}

class TestCase1 extends TestCase {
	@Override  //Java 5 new feature
//	void testprocess() {
	void testProcess() {
		System.out.println("Hello");
	}
}

class TestCase2 extends TestCase {
	void testProcess() {
		System.out.println("Hello");
	}
}


class Test {
	public static void main(String[] args) {

		TestCase t1 = new TestCase1();
		t1.testProcess();

		TestCase t2 = new TestCase2();
		t2.testProcess();

	}
}
