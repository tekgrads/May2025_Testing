class A
{
	static final void m1(){
		System.out.println("A m1()");
	}
	 final void m2(){
		System.out.println("A m2()");
	}
}
class  Test9_finalmethod extends A
{
	static final void m1(){
		System.out.println("test m1()");
	}
	 final void m2(){
		System.out.println("test m2()");
	}
}
