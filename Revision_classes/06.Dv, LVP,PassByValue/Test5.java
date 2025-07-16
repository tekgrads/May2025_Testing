class Test5 {
	static int a = 10;

	public static void main(String[] args) {
		
		System.out.println(a);
		System.out.println(Test5.a);
		System.out.println();

		int  a = 50;
		System.out.println(a);
		System.out.println(Test5.a);
		System.out.println();

		a = 60;
		System.out.println(a);
		System.out.println(Test5.a);
		System.out.println();

		Test5.a = 70;
		System.out.println(a);
		System.out.println(Test5.a);
		System.out.println();
		
/*
		b = 90;
		System.out.println(b);
		System.out.println(Test3.b);
		*/

	}
}