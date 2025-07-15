class Example
{
	int x = m1();
	int m1(){
		System.out.println("Ex NSV");
		return 10;
	}
	
	{
		System.out.println("Ex NSB");
	}
	
	Example(){
		System.out.println("Ex NPC");
	}
	
	void m2(){
		System.out.println("Ex NSM");
	}
}
class  Sample extends Example
{
	int y = m3();
	int m3(){
		System.out.println("Sa NSV");
		return 20;
	}
	{
		System.out.println("Sa NSB");
	}
	
	Sample(){
		System.out.println("Sa NPC");
	}
	
	void m4(){
		System.out.println("Sa NSM");
	}
	
	public static void main(String[] args) 
	{
		Sample s1 = new Sample();
	}
}
