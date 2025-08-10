package exceptionHandling;

public class Test10 {
	public static void main(String[] args) {
		m6();

	//	System.out.println(m8());
	}

 //Case #1: Local variable declaration                     
	static void m1(){
		try{
			int a = 10;
			System.out.println(a);

		} catch(ArithmeticException e) {
		//	System.out.println(a);
		} finally {
		//	System.out.println(a);
		}
	//	System.out.println(a);
	}
	
 //Case #2: Declaring LV before try, initializing inside try
	static void m2() {
		int a;
		try{
			a = 10;
			System.out.println(a);
		}catch(ArithmeticException e){
		//	 System.out.println(a);
		}
	//	System.out.println(a);
	}

	static void m3() {
		int a;
		try{
			a = 10;
	    //	a = 10/0;
		//	a = Integer.parseInt("a");

			System.out.println(a);
		}catch(ArithmeticException e){
			a = 20;
			System.out.println(a);
		}
		System.out.println(a);
	}

	static void m4() {
		int a ;
		try{
			a = 10;
			System.out.println(a);

		}catch(ArithmeticException e){
			a = 20;
			System.out.println(a);

		}catch(ArrayIndexOutOfBoundsException e) {
		//	a = 30;

	    //	System.out.println(a);
		}
	//	System.out.println(a);
	}

	static void m5() {
		int a;
		try{
		//	int b = Integer.parseInt("b");
			a = 10;
			System.out.println(a);

		}catch(ArithmeticException e){
			a = 20;
			System.out.println(a);

		}finally{
			System.out.println("hi");
		//	System.out.println(a);
		}

		System.out.println(a);
	}

	static void m6() {
		int a=0;
		try{
			a = 10;
			System.out.println(a);

		}catch(ArithmeticException e){
			System.out.println(a);
		}finally{
			System.out.println(a);
		}
		System.out.println(a);
	}

 //Case #3: returning a value from a method
  
 /* static int m7() {
		
		try{
			return 10;

		}catch(ArithmeticException e) {

		}
	}
  */
	static int m8(){
		
		try{
			return 10;

		}catch(ArithmeticException e) {
			return 20;
		}
	}

	static int m9(){
		
		try{
			return 10;

		}catch(ArithmeticException e) {
			return 20;
		}
	//	System.out.println("Hi");
	}

	static int m10(){
		
		try{
			return 10;

		}catch(ArithmeticException e) {
			return 20;
		}
		finally{
			System.out.println("Hi");
		}
	}

	static int m11(){
		int res = 0;
		try{
			res = 10;

		}catch(ArithmeticException e) {
			res = 20;
		}
		System.out.println("Hi");
		return res;
	}
}
