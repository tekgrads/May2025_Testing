abstract class Test2 
{
	abstract void m1();
	static int a = 10;
	int x = 20;
	static{
		System.out.println("Test2 SB");
	}
	{
		System.out.println("Test2 NSB");
	}
	Test2(){
		System.out.println("Test2 Constructor");
	}
	static void m2(){
		System.out.println("Test2 m2");
	}
	 void m3(){
		System.out.println("Test2 m3");
	}
		
	public static void main(String[] args) 
	{
		System.out.println("Test2 main");
		System.out.println("a: " + a);
		m2();
	/*	Test2 t1 = new Test2();
		System.out.println("x: " + t1.x);
		t1.m3();
	*/	
	}
}
