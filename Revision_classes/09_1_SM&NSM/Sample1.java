class Example
{
	static int a = m1();
	static {
		System.out.println("Ex SB");
	}
	int x = m2();
	
	
	{
		System.out.println("Ex NSB");
	}
	
	Example(){
		System.out.println("Ex NPC");
	}
	static int m1(){
		System.out.println("Ex SV is created");
		return 10;
	}
	int m2(){
		System.out.println("Ex NSV is created");
		return 20;
	}
	void abc(){
		System.out.println("Ex abc");
	}
	void bbc(){
		System.out.println("Ex bbc");
	}
}

class  Sample1 extends Example
{
	static int b = m3();
	static {
		System.out.println("Sa SB");
	}
	int y = m4();
	
	{
		System.out.println("Sa NSB");
	}
	
	Sample1(){
		System.out.println("Sa NPC");
	}
	static int m3(){
		System.out.println("Sa SV is created");
		return 30;
	}
	int m4(){
		System.out.println("Sa NSV is created");
		return 40;
	}
	void abc(){
		System.out.println("Sa abc");
	}
	
	public static void main(String[] args) 
	{
		System.out.println("Sample main");
		Sample1 s1 = new Sample1();
		s1.abc();
		s1.bbc();
	}
}
