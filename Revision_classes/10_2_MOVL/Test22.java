class A
{
	void m1(Integer io){
		System.out.println("A Integer arg");
	}
	void m1(String s){
		System.out.println("A String arg");
	}
}
class B extends A
{
	void m1(Object obj){
		System.out.println("B Object arg");
	}
	void m1(Integer io){
		System.out.println("B Integer arg");
	}
	void m1(String s){
		System.out.println("B String arg");
	}
}
class  Test22
{
	public static void main(String[] args) 
	{
		B b1 = new B();
		b1.m1("a");                             //B String
		b1.m1(10);                              //  B Integer
		A a1 = new B();
		a1.m1("a");                          // B String
		a1.m1(10);                           // B Integer
	}
}
