package exceptionHandling;

public class Test6 {
	public static void main(String[] args) {
		System.out.println("Before OTC");
		try{
			System.out.println("In OT");

			System.out.println("Before ITC");
			try{
				System.out.println("In IT");
				System.out.println(10/0);
			 }
		/*	catch(ArithmeticException e){ 
			System.out.println("In IAE");
			}
			*/
			catch(NumberFormatException e){ 
				System.out.println("In IC");
			}

			System.out.println("end of OT");

 		}
	/*     catch(ArithmeticException e) {
	    	 System.out.println("In O AE");
		 }
		 */
		catch(NumberFormatException e) {
				System.out.println("In OC");
		}
		System.out.println("After OTC");
	}
}
