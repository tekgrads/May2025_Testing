class A
{
	int x = m1();
	//int x = 10;
	 int m1(){
		System.out.println("A m1");
		x = 50;
		return 60;
	}
}
class B extends A
{
	int x;
	 int m1(){
		System.out.println("B m1");
		x = 70;
		return 80;
	}
}
class Test26
{
	public static void main(String[] args) 
	{
		B b1 = new B();
		A a1 = b1;
		System.out.println("x: " + b1.x);                   
		System.out.println("x: " + a1.x);                      
	}
}