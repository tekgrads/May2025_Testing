interface I {}
class C implements I{}

class  Test12{

	static void m1(Object obj){ 
		System.out.println("Object param");
	}
	
	static void m1(I i1){ 
		System.out.println("I param");
	}
		
		
	public static void main(String[] args) {
		m1(new C());   // I param 
		m1(null);          // I param

		m1((Object)new C());  // obj param
		m1((Object)null);        // obj param

	}
} 