class A
{
	int x = m1();
	int m1(){
		System.out.println("A m1 ");
		return 50;
	}
}
class B extends A
{
	int y = m1();
	int m1(){
		System.out.println("B m1 ");
		return 60;
	}
}
class Test24
{
	public static void main(String[] pa) 
	{
		B b1 = new B();
		System.out.println("x: " + b1.x);                   
		System.out.println("y: " + b1.y);                      
	}
}

