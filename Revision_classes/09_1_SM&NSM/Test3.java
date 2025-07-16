class A
{
	static int a = 10;
	static{
		System.out.println("In A class SB");
		System.out.println("a: " + a);
//	    System.out.println("b: " + b);
		System.out.println("b: " + Test3.b);
		System.out.println("b: " + Test3.getB());
	}
}
class  Test3 extends A
{
	static int b = 20;
	static{
		System.out.println("In B class SB");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		System.out.println("b: " + getB());
	}
	static int getB(){
		return b;
	}
	public static void main(String[] args) 
	{
		System.out.println("In B main");
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
}
