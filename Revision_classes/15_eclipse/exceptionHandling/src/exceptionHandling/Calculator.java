package exceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		while(true) {		
			try{	
				System.out.print("\nEnter FNO: ");
				int a = scn.nextInt();

				System.out.print("Enter SNO: ");
				int b = scn.nextInt();

				int c = Addition.add( a , b);
				System.out.println("Result: "+c);

			}catch(InputMismatchException e){
				System.out.println("Please pass only integer");
				scn.nextLine();
			}catch(NegativeNumberException e){
				System.out.println(e.getMessage());
			}
		}
    
	}
}
