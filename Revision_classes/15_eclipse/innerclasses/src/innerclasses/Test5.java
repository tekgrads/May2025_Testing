package innerclasses;

public class Test5 {
	void m1(){
		final int x = 2;
		class B{
		void m2(){
		System.out.println("In B m2 x: "+x);
		int x = 4;
		System.out.println("In B m2 x: "+x); // cannot differentiate if same name
		}
		}
		B b = new B();
		b.m2();
		}
		public static void main(String[] args){
		Test5 t1 = new Test5();
		t1.m1();
		}

}
