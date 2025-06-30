class Test6_Logical 
{
	public static void main(String[] args) 
	{
		int a = 10;
		int b = 20;
		System.out.println(a == 10 &&  b == 20); // t n t =  t
		System.out.println(a == 5 &&  b == 20); // f n f == > f
		System.out.println(a == 10 &&  b == 15);  // t n f ==  f
		System.out.println(a == 15 &&  b == 25); // f n f == f
		System.out.println();
		System.out.println();
		
		System.out.println(a == 10 ||  b == 20);   // t   n  t  == t
		System.out.println(a == 5  ||  b == 20); //  f n  t ==  t 
		System.out.println(a == 10 ||  b == 15);  //  t n f  == t
		System.out.println(a == 15 ||  b == 25); // f n f  == f
		System.out.println();
		System.out.println();
		boolean bo1 = true;
		boolean bo2 = false;
		System.out.println(bo1  == bo2);  // f
	//	bo1 = false;
		//bo1 = !bo1;
		System.out.println(!bo1  == bo2);  // f == f  tr
		System.out.println(bo1 == !bo2); // t == t tru
		
	}
}