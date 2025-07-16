class Example
{
	static int a = m1();
	static int m1() {
		System.out.println("Ex SV");
		return 10;
		}
		static {
			System.out.println("Ex SB");
		}
		static void m2() {
			System.out.println("EX SM");
		}
		public static void main(String[] args) 
	{
		System.out.println("Ex MM");
	}
}
class  Test4
{
	static {
		System.out.println("Test SB");
	}
	
	public static void main(String[] args) 
	{
		Example.m2();
		System.out.println("Test MM");
	//	Example.m2();
	}
}