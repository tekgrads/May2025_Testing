class A
{
	int x = 10;
}
class  Test8 extends A
{
	int x = 50;
	void m1(){
		int x = 70;
		System.out.println(x);
		System.out.println(this.x);
		System.out.println(super.x);
	}
	public static void main(String[] args) 
	{
		Test8 t1 = new Test8();
		t1.m1();
	}
}
