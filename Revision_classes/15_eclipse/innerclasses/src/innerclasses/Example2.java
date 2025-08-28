package innerclasses;

public class Example2 {
	static int a = 10;
	int x = 20;
	private int y = 30;
	static class A{
	public static void main(String[] args){
	System.out.println(a);
//	System.out.println(x);
//	System.out.println(y);
	Example2 e = new Example2();
	System.out.println(e.a);
	System.out.println(e.x);
	System.out.println(e.y);
	A a1 = new A();
//	System.out.println(a1.a);
//	System.out.println(a1.x);
	
	}
	}

}
