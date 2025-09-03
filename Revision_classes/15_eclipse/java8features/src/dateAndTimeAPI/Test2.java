package dateAndTimeAPI;

import java.time.Year;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter year");
		int n = scn.nextInt();
		Year y = Year.of(n);
		if(y.isLeap()) {
			System.out.println("given year is leap year " + n);
		}
		else {
			System.out.println("given year is not a leap year " + n);
		}
	}
}


