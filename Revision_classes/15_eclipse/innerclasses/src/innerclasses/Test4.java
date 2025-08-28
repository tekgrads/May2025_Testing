package innerclasses;

public class Test4 {
	static int a = 10;
	int b = 10;
	static void m1(final int c, int d){
		final int e = 30;
		int f = 40;
		System.out.println(c);
		System.out.println(d);
		class B{
		 void m1(){
		System.out.println(a);
	//	System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		}
	
  }
		B b1 = new B();
		b1.m1();
		
		
}
		public static void main(String[] args) {
		Test4 t1 = new Test4();
		t1.a = 5;
		t1.b = 6;
		System.out.println(t1.b);
		t1.m1(15,16);
		//Test4.B b1 = new Test4().new B();
	
		
		}

}
