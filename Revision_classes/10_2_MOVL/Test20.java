class A
{
	void m1(Object o){
		System.out.println("A Object arg");
	}
}
class B extends A
{
	void m1(String s1){
		System.out.println("B string arg");
	}
}
class  Test20
{
	public static void main(String[] args) 
	{
		B b1 = new B();
		b1.m1("a"); //B string
		b1.m1(10); // A obj
		A a1 = new B();
		a1.m1("a"); // A obj
		a1.m1(10); // A obj
	}
}
