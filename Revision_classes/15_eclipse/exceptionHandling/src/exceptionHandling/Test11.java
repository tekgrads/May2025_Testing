package exceptionHandling;

public class Test11 {
	public static void main(String[] args) {
		System.out.println("main start");
		m1();
		System.out.println("main end");
	}

	static void m1() {
		System.out.println("m1 start");
	//	m2();
		try{	
			m2();
		}
		catch(Exception e){
			e.printStackTrace();
		//	System.out.println("catch block");
		}
		System.out.println("m1 end");
		
	}

	static void m2() {
		System.out.println("m2 start");
		m3();
		System.out.println("m2 end");
	}

	static void m3() {
		System.out.println("m3 start");
		System.out.println(10/0);	
		System.out.println("m3 end");
	}
}
