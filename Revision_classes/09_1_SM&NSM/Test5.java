class A
{
	static int a = 10;
	static {
		System.out.println("Hi!");
	}
}
class B extends A
{
	static int b = 20;
	static {
		System.out.println("Hello!");
	}
}
class  Test5
{
	public static void main(String[] args) 
	{
		System.out.println(B.a);
	}
}