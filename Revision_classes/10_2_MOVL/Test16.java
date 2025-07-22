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
}
class  Test16
{
	public static void main(String[] args) 
	{
		B b = new B();
		 b.m1(50);    // B int
		 b.m1('a');    //  B int
		 b.m1(50L);   // A float
		 System.out.println();
		A a = new B();
		 a.m1(50);  //A float
		 a.m1('a'); // A float
		 a.m1(50L);  //A float
		
	}
}
