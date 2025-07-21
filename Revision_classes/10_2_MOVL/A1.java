class  A1
{
	static void m1() {
		System.out.println("A m1");
	}
	void m2() {
		System.out.println("A m2");
	}
	
	static void m3() {
		System.out.println("A m3 no param");
	}
	
	int m3(String s) {
		System.out.println("A m3 String param");
		return 50;
	}
}
class  B extends A1
{
	static void m1() {
		System.out.println("B m1");
	}
	void m2() {
		System.out.println("B m2");
	}
	
	void m3(float f, int x) {
		System.out.println("B m3 float, int  param");
	}
}
