 class Test3 extends Test2 
{
	static int b = 30;
	int y = 40;
	static{
		System.out.println("Test3 SB");
	}
	{
		System.out.println("Test3 NSB");
	}
	Test3(){
		System.out.println("Test3 Constructor");
	}
	void m1(){
		System.out.println("Test3 m1");
	}
	static void m4(){
		System.out.println("Test3 m4");
	}
	 void m5(){
		System.out.println("Test3 m5");
	}
		
	public static void main(String[] args) 
	{
		System.out.println("Test3 main");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		m2();
		m4();
		Test3 t1 = new Test3();
		System.out.println("x: " + t1.x);
		System.out.println("y: " + t1.y);
		t1.m1();
		t1.m3();
		t1.m5();
	}
}
