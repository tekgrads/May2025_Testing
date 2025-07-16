class Testp1
{
	public static void m1(int x) {
		System.out.println("value at start  " + x);
		x = 100;
		System.out.println("value at end " + x);
	}
	public static void main(String[] args) 
	{
		int a = 50; 
		 System.out.println("value of a before calling " + a);
		   m1(a);
		 System.out.println("value of a after calling " + a);
	}
}
