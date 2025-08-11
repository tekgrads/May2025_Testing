package multiThreading;

import java.util.Scanner;

public class Example1 {
	public static void m1() {
		System.out.println("m1 is execution start");
		System.out.println("m1 is execution end");
	}
	
	public static void m2() {
		System.out.println("m2 is execution start");
		Scanner scn = new Scanner(System.in);
		
		System.out.print("Enter name: ");
		String name = scn.nextLine();
		
		System.out.println("m2 is execution end");
		
	}
	
	public static void m3() {
		System.out.println("m3 is execution start");
		System.out.println("m3 is execution end");
	}

}
