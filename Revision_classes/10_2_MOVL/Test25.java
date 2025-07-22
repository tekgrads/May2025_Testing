class A
{
	int x = m1();
	static int m1(){
		System.out.println("A m1");
		return 50;
	}
}
class B extends A
{
	int y = m1();
	static int m1(){
		System.out.println("B m1");
		return 60;
	}
}
class Test25
{
	public static void main(String[] args) 
	{
		B b1 = new B();
		System.out.println("x: " + b1.x);                   
		System.out.println("y: " + b1.y);                      
	}
}