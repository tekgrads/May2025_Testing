package functionalInterface;

interface I4{
	void m1();
}
public class Test6 {
	int x = 88;
	public void m2() {
		I4 i = () ->{ int x = 99;
			System.out.println(this.x);
		};
		i.m1();
	}
	public static void main(String[] args) {
		Test6 t1 = new Test6();
		t1.m2();
	}

}
