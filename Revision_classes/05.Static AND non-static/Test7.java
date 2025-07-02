class Test7
{
	int x = m1();
	int m1(){
		System.out.println("NSV1 is executed  ");  // 2
		return 10;
	}
	
	{
		System.out.println(" NSB1 is executed "); //3
	}
	
	Test7() {
		System.out.println("NPC is executed  ");  //8
	}
	
	Test7(String s) {
		System.out.println("SPC is executed  "); // 8
	}
	
	{
		System.out.println(" NSB2 is executed ");  //4
	}
	int y = m2();
	int m2(){
		System.out.println("NSV2 is executed  ");   //5
		return 20;
	}
	public static void main(String[] args) 
	{
		System.out.println("MM execution start ");  //1
//		Test7 t1 = new Test7();
		
    	Test7 t2 = new Test7("Hyd");
		System.out.println("MM execution end"); //9
	}
	int z = m3();
	int m3(){
		System.out.println("NSV3 is executed  "); //6
		return 30;
	}
	
	{
		System.out.println(" NSB3 is executed ");  //7
	}
	void m4(){
		System.out.println(" NSM is executed ");
	}
}
