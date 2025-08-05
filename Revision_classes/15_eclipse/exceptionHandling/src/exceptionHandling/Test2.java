package exceptionHandling;

public class Test2 {
	public static void main(String[] args) {
		try {
			System.out.println("main start");
			System.out.println(10/0);
			System.out.println("main end");
		}
		catch (ArithmeticException e) {
			System.out.println("catch block executed");
		}
	}

}

/*
Write a program to read runtime values from command line 
and catch the exception occurred in this program 
and display user understandable message on console 
to pass correct values
*/
