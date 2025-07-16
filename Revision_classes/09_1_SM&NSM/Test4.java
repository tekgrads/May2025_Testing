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
}
class  Test4
{
	public static void main(String[] args) 
	{
		System.out.println(B.b);
	}
}
