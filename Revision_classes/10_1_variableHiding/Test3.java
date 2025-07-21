class A
{
	static int a = 10;
	int x = 20;
	static{
		System.out.println("A is loaded ");
	}
}
class B extends A
{
	static int b = 30;
	int y = 40;
	static{
		System.out.println("B is loaded ");
	  }
	}
	class C extends A
{
	static int c = 50;
	int z = 60;
	static{
		System.out.println("C is loaded ");
	  }
	}
class  Test3
{
	static{
	    System.out.println("Test is loaded ");
	}
	public static void main(String[] args) 
	{
		System.out.println("Test main start ");
		B b1 = new B();
		C c1 = new C();
		b1.a = 15;
		b1.x = 16;
		
		System.out.println("b1.a: " + b1.a);
		System.out.println("c1.a: " + c1.a);
		System.out.println("b1.x: " + b1.x);
		System.out.println("c1.x: " + c1.x);
		
	}
}
