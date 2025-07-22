class A
{
	void m1(Object obj){
		System.out.println("A Object arg");
	}
	
}
class B extends A
{
	void m1(Object obj){
		System.out.println("B Object arg");
	}
	void m1(String s){
		System.out.println("B String arg");
	}
}
class  Test23
{
	public static void main(String[] args) 
	{
		B b1 = new B();
		b1.m1("a");                             //B String
		b1.m1(10);                              //  B Object
		A a1 = new B();
		a1.m1("a");                          // B Object
		a1.m1(10);                           // B Object
	}
}
