interface I {}
class C implements I{}

class  Test13{

	static void m1(Object obj){ 
		System.out.println("Object param");
	}
	
	static void m1(I i1){ 
		System.out.println("I param");
	}
	static void m1(String s1){ 
		System.out.println("String param");
	}	
		
	public static void main(String[] args) {
		m1(new C());   // I param 
	//	m1(null);          // a e both I and String are suitable

	

	}
} 