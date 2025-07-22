interface I1 {}
interface I2 {}

class C implements I1, I2{}

class  Test10{
	
	static void m1(I1 i1){ 
		System.out.println("I1 param");
	}
	
	static void m1(I2 i2){ 
		System.out.println("I2 param");
	}
	
		
	public static void main(String[] args) {
		m1(new C());
	//	m1(null);

		I1 i1 = new C();
		m1(i1);   // i1 param

		I2 i2 = new C();
		m1(i2);   // i2 param

		m1((I1) new C());   // i1 param
		m1((I2) new C());   // i2 param
	}
}