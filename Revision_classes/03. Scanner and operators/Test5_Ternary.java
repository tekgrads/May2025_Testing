class Test5_Ternary 
{
	public static void main(String[] args) 
	{
		
		int a = 10;
		/*
			if(a == 10) {
			     System.out.println(20);
	         	}
				 else
					 System.out.println(30);
		*/
		System.out.println((a == 10) ? 20 : 30);
		System.out.println((a != 10) ? 20 : 30);
		
		String s1 = "abc";
		String s2 = "abc";
		System.out.println((s1 == s2) ? "Hi" : "Hello");
		System.out.println((s1 != s2) ? "Hi" : "Hello");
		
	}
}