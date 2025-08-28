package innerclasses;

public class Example3 {
	static class A{
		private int y = 20;
		static void m1() {
		 System.out.println("inner class SM m1"); 
		}
		void m2(){ 
			System.out.println("inner class NSM m2"); 
			}
		}
		public static void main(String[] args){
		A.m1();
		A a = new A();
		System.out.println( a.y );
		a.m2();
		
		}

}
