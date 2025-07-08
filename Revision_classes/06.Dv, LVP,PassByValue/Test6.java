/*
class Test6 
{
	static int a;
	static void m1(int x) {
		a = x;
		System.out.println(a);
	}
	
	public static void main(String[] args) 
	{
		System.out.println(a); 
		m1(50);
		System.out.println(a);
	}
}
*/

/*
class Test6
{
	static int a;
	static void m1(int a) {
		a = a;
		System.out.println(a); //50
	}
	
	public static void main(String[] args) 
	{
		System.out.println(a);
		m1(50);
		System.out.println(a); // 0
	}
}
*/
/*
class Test6 
{
	static int a;
	static void m1(int a) {
		Test6.a = a;
		System.out.println(a);
	}
	
	public static void main(String[] args) 
	{
		System.out.println(a);
		m1(50);
		System.out.println(a);
	}
}
*/

class Test6
{
	static int a;
	static void m1(int a) {
		 a = Test6.a ;
		System.out.println(a);
	}
	
	public static void main(String[] args) 
	{
		System.out.println(a);
		m1(50);
		System.out.println(a);
	}
}


