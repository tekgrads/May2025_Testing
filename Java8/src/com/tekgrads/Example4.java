package com.tekgrads;

interface Interf4 {
	public void m1();
}

class Test3 {
	int x = 888;

	public void m2() {
		Interf4 i = new Interf4() {

			int x = 999;

			@Override
			public void m1() {
				System.out.println(this.x);

			}
		};
		i.m1();
	}
}

class Test4 {
	int x = 888;

	public void m2() {
		int y= 20;
		
		Interf4 i2 = () -> {
			int x = 999;
			//y=200;
			System.out.println(this.x);
			System.out.println(y);
		};
		i2.m1();
	}
}

public class Example4 {

	public static void main(String[] args) {

		Test3 t3 = new Test3();

		t3.m2();

		Test4 t4 = new Test4();

		t4.m2();

	}

}
