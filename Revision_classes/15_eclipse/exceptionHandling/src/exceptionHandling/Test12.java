package exceptionHandling;

public class Test12 {
	public static void main(String[] args) {

		//m1();
		//m2();
		//m3();

		//m4(5);
	   //  m4(-5);
		try{
		//	m5(5);
			m5(-5);
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}

		try{
			m6(5);
			//m6(-5);
			m6(0);

		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("main end");
	}

	static void m1() {
		ArithmeticException e = new ArithmeticException();
		throw e;
	}

	static void m2() {
		ArithmeticException e = new ArithmeticException("Do not pass zero");
		throw e;
	}

	static void m3() {
		throw new ArithmeticException("Do not pass zero");
	}

	static void m4(int i){
		if(i<0)
			throw new IllegalArgumentException("Do not pass -ve number");

		System.out.println(i + 10);
	}

	static void m5(int i) throws IllegalArgumentException {
		if(i<0)
			throw new IllegalArgumentException("Do not pass -ve number");

		System.out.println(i + 10);
	}

	static void m6(int i) throws IllegalArgumentException, ArithmeticException {

		if(i<0)
			throw new IllegalArgumentException("Do not pass -ve number");

		if(i==0)
			throw new ArithmeticException("Do not pass zero");

		System.out.println(10/i);
	}

	static  void m7() //throw ArithmeticException
	{
		//throws new ArithmeticException();
	}

	static void m8(){
		throw new ArithmeticException();
		//System.out.println("Hi");
	}

	static void m9(){
		if(true) 
			throw new ArithmeticException();
		System.out.println("Hi");
		
		
		
	}
}


