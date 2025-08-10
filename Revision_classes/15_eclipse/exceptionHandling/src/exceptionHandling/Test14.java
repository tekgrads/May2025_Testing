package exceptionHandling;
//class A extends Throwable {  }
//class A extends Error { 
//class A extends RuntimeException{ }

class A extends Exception {
	A(){ 
		super();	
	}
	A(String msg){
		super(msg);
	}
}

public class Test14 {
	public static void main(String[] args) throws A 
	{
		try{
			throw new A();
			//throw new A("Donot pass -ve number");
    	}catch(A a) {
			System.out.println(a.getMessage());	
		}
	}
}

