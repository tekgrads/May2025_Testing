package methodAndConstructorReference;

interface I1{
	public void m1();
}
/*
public class Test1 {
	public static void main(String[] args) {
		I1 i1 = () -> System.out.println("m1 implementation using lambda");
		i1.m1();
	}
}
*/
public class Test1{
	public static void m2() {
//		public  void m2() {
		System.out.println("method reference");
	}
//	 static int m2() {
//		System.out.println("method reference");
//		return 10;
//	}
//	public static void m2(int a) {
//		System.out.println("method reference");
//		}
	public static void main(String[] args) {
		Test1 t = new Test1();
		I1 i1 = Test1 :: m2;  // classname :: method name
	//	I1 i1 = t :: m2;  // obj reference :: method name
		i1.m1();
	}
}


