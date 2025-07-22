class A
{
	void m1(int a){
		System.out.println(" A int arg");
	}
}
class B extends A
{
	void m1(float f){
		System.out.println(" B float arg");
	}
	void m1(char ch){
		System.out.println(" B char arg");
	}
}
class  Test17
{
	public static void main(String[] args) 
	{
		B b = new B();
		 b.m1(50);    // A int
		 b.m1('a');    //  B char
		 b.m1(50L);   // B float
		 System.out.println();
		A a = new B();
		 a.m1(50);  // A int 
		 a.m1('a'); // A int 
	//	 a.m1(50L);  
		
	}
}
