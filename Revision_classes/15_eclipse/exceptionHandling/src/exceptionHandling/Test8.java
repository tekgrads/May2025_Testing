package exceptionHandling;

public class Test8 {
	public static void main(String[] args) {	
		System.out.println("main start");
		System.out.println("Result: "+ m1());
		
		m2();
		System.out.println("main end");
	}

	static int m1() {
		try{
			System.out.println("In try");
		//	return 10;
			return 10/0;


		}catch(ArithmeticException e) {
			System.out.println("In catch");
		//	return 20;
			
		}
		/*finally {
			System.out.println("In finally");
			return 50;
		}
		*/
		System.out.println("Hello World!"); //CE: unreachable statement
    	return 70;
	}
	
	static void m2() {
		try{
		}
		finally {
			return;
		}
	}	
}
