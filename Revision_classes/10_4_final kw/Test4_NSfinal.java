//import java.util.Scanner;

class Test4_NSfinal 
{
	final int x = 10;
	final int y;
	final int z;
	
	{
		/*System.out.println("NSB execution started");
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter value");
		y = scn.nextInt();
		System.out.println("NSB execution end");
		*/
		y = 30;
	}
	Test4_NSfinal(){
		
		z = 15;
	}
	Test4_NSfinal(int z){
		this.z = z;
	}
	public static void main(String[] args) 
	{
		System.out.println("main start");
		Test4_NSfinal t1 = new Test4_NSfinal();
		Test4_NSfinal t2 = new Test4_NSfinal();
		Test4_NSfinal t3 = new Test4_NSfinal(18);
		Test4_NSfinal t4 = new Test4_NSfinal(20);
		System.out.println(t1.x + "   "+ t1.y + "   "+ t1.z);
		System.out.println(t2.x + "   "+ t2.y + "   "+ t2.z);
		System.out.println(t3.x + "   "+ t3.y + "   "+ t3.z);
		System.out.println(t4.x + "   "+ t4.y + "   "+ t4.z);
		System.out.println("main end");
	}
}

