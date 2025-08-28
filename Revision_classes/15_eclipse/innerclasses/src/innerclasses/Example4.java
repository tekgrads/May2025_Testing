package innerclasses;

class A{
	  static int a = 10;
  	  int x = 20;
		
	  static class B{
			
		static int a = 50;
		int x = 60;
		void m1(){
		System.out.println(a); //50
		System.out.println(x); //60
		
		A a = new A();
		System.out.println(A.a); //10
		System.out.println(a.x); //20
		}
	  }
		void m2(){
		System.out.println(a); //10
		System.out.println(x); //20
		B b = new B();
		System.out.println(B.a); //50
		System.out.println(b.x);// 60
		}
	/*	public static void main(String[] args){
		A a = new A();
		a.m2();
		B b = new B();
		b.m1();
		}
	*/	
		}

	public class Example4{
		public static void main(String[] args){
		A a1 = new A();
	//	B b1 = new B();
		A.B b1 = new A.B();
		System.out.println(A.a);
		System.out.println(A.B.a);
		System.out.println(a1.x);
		System.out.println(b1.x);
		}
	
}
