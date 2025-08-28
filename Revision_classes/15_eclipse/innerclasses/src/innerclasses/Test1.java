package innerclasses;
// non-static inner class
class Example {
	static int a = 10;
	int x = 20;
	private int y = 30;
	class A{
	void m1(){
	System.out.println(a);
	System.out.println(x);
	System.out.println(y);
	}
 }
	void m2() {
		A a1 = new A();
		a1.m1();
	
	}		
}
public class Test1 {
  public static void main(String[] args) {
	Example.A a1 = new Example().new A();
	a1.m1();
	Example a2 = new Example();
	a2.m2();
	
}
}
		

