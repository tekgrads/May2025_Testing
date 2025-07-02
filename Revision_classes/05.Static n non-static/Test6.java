class Test6 
{
	int x = 10;
	{
		System.out.println("NSB1");
	}
	Test6() {
				System.out.println("NPC ");
	            }
	Test6(int x) {
				System.out.println("PC ");
	            }
		{
		System.out.println("NSB2");
	}	
	
	int y = 20;
	{
		System.out.println("NSB3");
	}
				
	public static void main(String[] args) 
	{
	//	Test6 t1 = new Test6();
		Test6 t1 = new Test6(10);
	}
}
