package innerclasses;

class A1{
	void m1() {
		System.out.println("m1 is executed from A");
	}
}
interface I1 {
	void m2();
}

class Ex{
	static void m1() {
		new A1() {};
	
	new I1() {
		public void m2() { }
	};
	
	new A1() {
		static final int a = 10;
		int x = 20;
		{
			System.out.println("AIC IIB");
		}
		void m3() {
			System.out.println("AIC NSM");
		}
		class Q{ }
		//abstract void m4();
	};
	}
}
public class Test6 {
	public static void main(String[] args) {
		Ex.m1();
	}
		
	}
