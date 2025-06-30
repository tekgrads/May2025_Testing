/*class Addition {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		int c = a + b;

		System.out.println("Result: "+ c);
	}
}
*/
import java.util.Scanner;

class Ex11_AdditionScanner {
	public static void main(String[] args) {
		
	
		Scanner scn = new Scanner(System.in);

		System.out.print("Enter value1: ");
		int num1 = scn.nextInt(); 

		System.out.print("Enter value2: ");
		int num2 = scn.nextInt();

		int num3 = num1 + num2;

		System.out.println("The addition of two numbers  " + num1 + " and " + num2+ "  is " + num3);

	}
}

