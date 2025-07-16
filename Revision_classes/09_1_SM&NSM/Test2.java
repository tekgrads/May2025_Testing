class A
{
	static int a = m1();
	static int m1() {
		System.out.println("A SV");
		return 10;
	}
	
	static{
		System.out.println("class A SB is executed");
	  }
	  
		public static void main(String[] args) 
	{
		System.out.println("A main");
	}
}

class  Test2 extends A
{
	static int b = m2();
	static int m2() {
		System.out.println("Test SV");
		return 20;
	}
		static{
		System.out.println("class Test SB is executed");
	   }
}
