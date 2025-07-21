class A
{
	int x = 10;
	int y = 20;
	void m1(){
		System.out.println("m1 in A: " + x + "-----" + y);
	}
}
class B extends A
{
	int x = 30;
	int y = 40;
	void m2(){
		System.out.println("m2 in B: " + x + "-----" + y);
		System.out.println(super.x + "-----" + super.y);
	}
	void m3(){
		x = 50;
		y = 60;
		super.x = 70;
		super.y = 80;
	}
}
class  Test2
{
	public static void main(String[] args) 
	{
		B b1 = new B();
		A a1 = b1;
		B b2 = new B();
		A a2 = b2;
		b1.m3();
		System.out.println(b1.x + "-----" + b1.y);
		System.out.println();
		System.out.println(a1.x + "-----" + a1.y);
		System.out.println();
		System.out.println(b2.x + "-----" + b2.y);
		System.out.println();
		System.out.println(a2.x + "-----" + a2.y);
		b1.m1();
		b1.m2();
		b2.m1();
		b2.m2();
	}
}
