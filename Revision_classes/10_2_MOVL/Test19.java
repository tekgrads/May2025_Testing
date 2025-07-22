class A
{
	void m1(float f ){
		System.out.println(" A float arg");
	}
}
class B extends A
{
	void m1(int  a){
		System.out.println(" B int arg");
	}
	void m1(long  l){
		System.out.println(" B long arg");
	}
	void m1(float  f){
		System.out.println(" B float arg");
	}
}
class  Test19
{
	public static void main(String[] args) 
	{
		B b = new B();
		 b.m1(50);    // B int
		 b.m1('a');    //  B int
		 b.m1(50L);   // B long
		 System.out.println();
		A a = new B();
		 a.m1(50);  //B float
		 a.m1('a'); // B float
		 a.m1(50L);  //B float
		
	}
}
