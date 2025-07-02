class Example
{
	static int a = 10;
	
	static{
		System.out.println("SB");
	}
		
}
class Test3 
{
	public static void main(String[] args) 
	{
		System.out.println(Example.a);
	}
}