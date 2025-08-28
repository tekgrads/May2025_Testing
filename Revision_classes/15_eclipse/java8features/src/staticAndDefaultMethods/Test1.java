package staticAndDefaultMethods;

interface I5{
	public default void m1() {
		System.out.println("default method");
	}
}
public class Test1 implements I5{
	//public  default void m1() {
		public void m1() {
		System.out.println("Implementation of m1()");
		I5.super.m1();
	}
	public static void main(String[] args) {
		I5 i = new Test1();
		i.m1();
	}

}
