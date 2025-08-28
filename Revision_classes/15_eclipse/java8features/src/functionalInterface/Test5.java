package functionalInterface;

interface I3{
	void m1();
}
public class Test5 {
	int x = 88;
	public void m2() {
		I3 i = new I3() {
			int x = 99;
			@Override
			public void m1() {
				//int x = 100;
				System.out.println(this.x);
			
			}
			
		};
		i.m1();
	}
	public static void main(String[] args) {
		Test5 t1 = new Test5();
		t1.m2();
	}

}
