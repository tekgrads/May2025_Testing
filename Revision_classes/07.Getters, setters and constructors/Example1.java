/*
class Example1 {
	   
	   Example1() {
		System.out.println("No-param constructor");
	   }

	   Example1(int a) {
		System.out.println("int-param constructor");
	   }

	   public static void main(String[] args) {
		System.out.println("main method");

		Example1 e1 = new Example1();			
		
		Example1 e2 = new Example1(5);			
//		Example1 e3 = new Example1(5.6);	
		Example1 e4 = new Example1( 'a' );	 // ASCII values 
	   }
	}
	*/
	class Example1 {
	   
	   Example1() {
		System.out.println("No-param constructor");
	   }

	   Example1(int a) {
		System.out.println("int-param constructor");
	   }

	   public static void main(String[] args) {
		System.out.println("main method");

		new Example1();

		new Example1(5);

		new Example1('a');
		
	   }
	}