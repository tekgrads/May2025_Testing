class C {
	static int a = 10;
//	static int a = 20;		
}

class D {
	int a = 10;			
//	int a = 20;
}

class E {
	static int a = 10;
	 //      int a = 20;
}

class F {
	static int a = 10;

	static void m1() {
		int a = 10;
	}

	static void m2() {
		int a = 10;
	}
 
	static void m3() {
		int a = 10;
	//	int a = 10;
	}

	static void m4() {
		int a = 10;
		a = 20;
	}

	static void m5(int a) {
                 
	}

	static void m6(int a) {
               
	}

//	static void m7(int a, int a) {
	static void m7(int a) {

	}

	static void m8(int a) {
	//	int a = 10;
	}

	static void m9(int a) {
		a = 70;
	}

	static void m10() {
               
		System.out.println(a);
	}
}