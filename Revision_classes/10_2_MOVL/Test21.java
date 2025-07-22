class A
{
	void m1(String s1){
		System.out.println("A string arg");
	
	}
}
class B extends A
{
	void m1(Object o){
		System.out.println("B Object arg");
	}
}
class  Test21
{
	public static void main(String[] args) 
	{
		B b1 = new B();
		b1.m1("a"); // A str
		b1.m1(10); // B obj
		A a1 = new B();
		a1.m1("a"); // A str
	//	a1.m1(10); 
	}
}
