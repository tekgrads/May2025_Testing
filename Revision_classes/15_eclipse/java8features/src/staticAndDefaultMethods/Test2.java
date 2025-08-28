package staticAndDefaultMethods;

//static method in interface
interface I6{
	public static  void m1() {
		System.out.println("static method in interface");
	}
}
public class Test2 implements I6{
/*	public static void m1() {
		
	}
	
	
	public void m1() {
		
	}
	*/
	private void m1() {
		System.out.println("m1 method in Test");
	}
	
	
	public static void main(String[] args) {
		Test2 t1 = new Test2();
	//	m1();
	//	t1.m1();
	//	Test2.m1();
		I6.m1();
		t1.m1();
		
		
	}

}
