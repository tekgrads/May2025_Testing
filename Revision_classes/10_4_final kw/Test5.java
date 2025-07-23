class Ex
{
	static final int a = 10;

static {
	System.out.println("Ex class is loaded");
      }
}

class Test5
{
	static{
		System.out.println("Test class is loaded");
	}
	public static void main(String[] args) 
	{
		System.out.println("main started");
		System.out.println("a: " + Ex.a);   // sop("a:" + 10);
		System.out.println("main end");
	}
}