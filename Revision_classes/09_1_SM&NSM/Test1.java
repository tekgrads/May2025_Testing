class A
{
	static int a = 10;
	static{
		System.out.println("class A SB is executed");
	  }
		public static void main(String[] args) 
	{
		System.out.println("A main");
	}
}

class  Test1 extends A
{
	static int b = 20;
		static{
		System.out.println("class Test SB is executed");
	   }
	public static void main(String[] args) 
	{
		System.out.println("Test main");
		System.out.println("a: " + a);
		System.out.println("b:" + b);
	}
}
