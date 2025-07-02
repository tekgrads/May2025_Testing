class Example
{
	static int a = 10;
	static int b = 20;
	
	int x = 30;
	int y = 40;

    static void m1(){
		System.out.println("m1");
	}
    void m2(){
		System.out.println("m2");
	}
}
class Test1
{
	public static void main(String[] args) 
	{
		Example e1;
		e1 = new Example();
	//	e1.m2();
		
		Example e2;
		e2 = new Example();
	}
}