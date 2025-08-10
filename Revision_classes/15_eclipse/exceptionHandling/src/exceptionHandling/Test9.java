package exceptionHandling;

public class Test9 {
	public static void main(String[] args) {
		try{
			//System.out.println("In OT"); 
		 //  System.out.println(10/0); 
		//	System.out.println(args[0]); 
			try{
       			System.out.println("In IT");    
				System.out.println(10/0); 

			} catch(ArithmeticException e) {
				System.out.println("In IC1");
			} catch(NumberFormatException e) {
				System.out.println("In IC2");    

			} finally{
				System.out.println("In IF");    
			}
			System.out.println("After ITCF");
		} 
		catch(ArithmeticException e) {
			System.out.println("In OC");    

		} finally {
			System.out.println("In OF");    
		}
		System.out.println("After OTCF");    

	}
}
