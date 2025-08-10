package exceptionHandling;

public class Test13 {
//	 throw new ArithmeticException();

	static  //throws ArithmeticException
	{
//		 throw new ArithmeticException();
	}

	{
//		 throw new ArithmeticException();
	}

	static  
	{
		 int a = 20;
		 if(a == 10){ throw new ArithmeticException(); }
	}

	{
		 if(true){ throw new ArithmeticException(); }
		 if(false){ throw new ArithmeticException(); }
	}

	
	static  
	{
		 try{ throw new ArithmeticException(); }
		 catch(ArithmeticException e){ e.printStackTrace(); }
	}

	{
		 try{ throw new ArithmeticException(); }
		 catch(ArithmeticException e){e.printStackTrace();}
	}

	Test13() throws ArithmeticException{
		throw new ArithmeticException();
	}

	void m1() throws ArithmeticException{
		throw new ArithmeticException();
	}

	void m2() //throw ArithmeticException
	{
//		throws new ArithmeticException();	
	}

	void m3()  //throws String
	{
//		throw "abc";
	}

	void m4(){
		throw new ArithmeticException(); 
		//System.out.println("Hi");
	}	

	void m5(){
		if(true){
			throw new ArithmeticException();
		}
		System.out.println("Hi");
	}

	void m6() throws ArithmeticException, 
						IllegalArgumentException {
		throw  new ArithmeticException()  
				//,new IllegalArgumentException()
			;
	}

	void m7(int x) throws ArithmeticException, 
							IllegalArgumentException{
		throw new IllegalArgumentException(); 
//		throw new ArithmeticException(); 
	}

	void m8(int x) throws ArithmeticException, 
							IllegalArgumentException{
		if(x < 0){
			throw new IllegalArgumentException(); 
		}

		if (x == 0){
			throw new ArithmeticException(); 
		}

		System.out.println(x +" is correct value");
	}
/*		*/

	public static void main(String[] args){ 
		new Test13();
	}
}
