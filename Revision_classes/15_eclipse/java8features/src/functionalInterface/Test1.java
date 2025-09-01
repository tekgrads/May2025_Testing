package functionalInterface;

	interface I1{
		void add(int a, int b);
	}
	
	class B implements I1{

		@Override
		public void add(int a, int b) {
			System.out.println("The sum of two numbers is : " + (a + b));
		}
		
	}
	public class Test1 {
		public static void main(String[] args) {
		  B b1 = new B();
		  b1.add(10, 20);
		}

	}

/*	public class Test1{
	
 	public static void main(String[] args) {
		I1 i1 = (a, b) -> System.out.println("sum of two numbers is:" + (a + b));
		
				  i1.add(10, 20);
		}
	

}
*/