package functionalInterface;
	interface I{
		void m1();
	}
	
/*	class A implements I{
		public void m1() {
			System.out.println("m1 implementaion ");
		}
	}
	public class Test {
		public static void main(String[] args) {
			I i1 = new A();
			i1.m1();
		}

	}
*/	
	// with lambda 
	public class Test{
		public static void main(String[] args) {
			I i1 = ()-> System.out.println("m1 implementation");
			
			i1.m1();
		}
	

}
