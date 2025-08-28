package innerclasses;

class C{
	int x = 20;
	class B{
	int x = 50;
	void m1(){
	System.out.println(x);
	System.out.println(this.x);
	System.out.println(C.this.x);

	}
	void m2(){
	int x = 60;

	System.out.println(x);
	System.out.println(this.x);
	System.out.println(C.this.x);

	}
	}
	void m3(){
	System.out.println(x);
	B b = new B();
	System.out.println(b.x);
	}
	public static void main(String[] args){
	C c1 = new C();
	c1.m3();
	System.out.println();
	C.B b = new C().new B();
	b.m1();
	System.out.println();
	b.m2();

	}
	
	}
public class Test2{
	public static void main(String[] args){
	C c1 = new C();
	c1.m3();
	C.B b = new C().new B();
	b.m1();
	b.m2();
	}
	

}
