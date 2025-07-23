class A
{
	static void m1() {
			System.out.println("A m1");
	}
    void m2() {
			System.out.println("A m2");
	}
	static void m3() {
			System.out.println("A m3 no param ");
	}
    int m3(String s) {
			System.out.println("A m3 String param");
			return 50;
	}
}
class B extends A
{
	static void m1() {
			System.out.println("B m1");
	}
    void m2() {
			System.out.println("B m2");
	}
	
    void m3(float f , int i ) {
			System.out.println("B m3 float, int param");
	}
}
class  Test1
{
	public static void main(String[] args) 
	{
		B b1 = new B();
		b1.m1();
		b1.m2();
		b1.m3();
		b1.m3("abc");
//		b1.m3(45.3, 20);
		b1.m3(45.3f, 20);
		
		A a1 = new B();
		a1.m1();
		a1.m2();
		a1.m3();
		a1.m3("abc");
//		a1.m3(45.3f, 20);
	}
}



/*
A a1 = new A(); 

B b1 = new B();

A a2 = new B();   Super class reference can point to sub class object

B b2 = new A();   Sub class reference cannot poin to super class object
*/