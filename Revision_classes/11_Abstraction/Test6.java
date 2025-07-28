abstract class Example {
	abstract void m1();
	abstract void m2();
}

abstract class Sample extends Example{
	void m1(){
		System.out.println("m1 is executed from Sample class");
	}

	abstract void m3();
}

class Xyz extends Sample{
	void m2(){
		System.out.println("m2 is executed from Xyz class");

		m3();
		m4();
	}

	void m3(){
		System.out.println("m3 is executed from Xyz class");
	}

	void m4(){
		System.out.println("m4 is executed from Xyz class");
	}
}

class Test6{
	public static void main(String[] args){
		Example e1 = new Xyz();
		e1.m1(); 
		e1.m2();		

//		e1.m3();
		//e1.m4();

		((Sample)e1).m3();		//Tight Coupling and SB
	//	((Sample)e1).m4();

		((Xyz)e1).m4();

/**/

	}
}