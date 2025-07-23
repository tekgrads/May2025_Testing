class Ex
{
	static final int a ;

static {
	a = 10;
	System.out.println("Ex class is loaded");
      }
}

class Test6
{
	static{
		System.out.println("Test class is loaded");
	}
	public static void main(String[] args) 
	{
		System.out.println("main started");
		System.out.println("a: " + Ex.a);
		System.out.println("main end");
	}
}