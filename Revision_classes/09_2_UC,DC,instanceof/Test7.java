class A
{
	A(){
		System.out.println("A constructor");
	}
	int x = 10;
	void m1(){
		System.out.println("m1 is executed from class A");
	}
}
class  Test7 extends A
{
	int x = 30;
	Test7(){
		super();
		System.out.println(super.x);
		//System.out.println(this.x);
		super.m1();
	}
	public static void main(String[] args) 
	{
		Test7 t = new Test7();
	}
}
