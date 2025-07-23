class Test10_finalmain
{
	public static final void main(String[] args) 
	{
		System.out.println("Test main");
	}
}
/*
class B extends Test10_finalmain
{
	public static void main(String[] args) 
	{
		System.out.println("B main");
	}
}
*/


class C extends Test10_finalmain
{
	static int a = 10;
	int b = 20;
	static void m1(){
		System.out.println("C m1");
	}
	 void m2(){
		System.out.println("C m2");
	}
	static{
		System.out.println("C SB");
		System.out.println("a: " + a);
		C.m1();
		C c1 = new C();
		System.out.println(c1.b);
		c1.m2();
	}
}
