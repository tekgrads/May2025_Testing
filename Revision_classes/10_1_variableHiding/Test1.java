class A {
  static int a = 10;
  int x = 20;

}

class B extends A {
	
    static int a = 30; // variable hiding
    int x = 40;

  void m1(){
    System.out.println(a);	
    System.out.println(x);	

    System.out.println(super.a);	
    System.out.println(super.x);	
  }

  void m2() {
    //variable shadowing
	int a = 15;
	int x = 16;

	System.out.println(a);	 
	System.out.println(x);	

	System.out.println(this.a);	 
	System.out.println(this.x);	

  	System.out.println(super.a);	
	System.out.println(super.x);	

  }

  static void m3(){
	System.out.println(a);
/*	System.out.println(x);

	System.out.println(this.a);
	System.out.println(this.x);

	System.out.println(super.a);
	System.out.println(super.x);
*/
	System.out.println(A.a);

	B b1 = new B();	
	//A a1 = b1;	

	System.out.println(b1.x); 
//	System.out.println(a1.x); 
	

  }
}
class Test1 {
  public static void main(String[] args) {
	B b1 = new B();

	System.out.println(b1.a);
	System.out.println(b1.x);

	//System.out.println(super.a);
	//System.out.println(super.x);

	A a1 = b1;
	System.out.println(a1.a);
	System.out.println(a1.x);
	
	System.out.println();
	b1.m1();
	System.out.println();
	b1.m2();
	System.out.println();
	b1.m3();
  }
}
