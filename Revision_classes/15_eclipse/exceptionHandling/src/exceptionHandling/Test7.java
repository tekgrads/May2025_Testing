package exceptionHandling;

public class Test7 {
	public static void main(String[] args) {	
		//#1: resource declaration
		try{
			//#2: resource connection creation
			
			//#3: using this resource

			//#4. closing resource connection (mandatory to execute)                         

		} catch (ArithmeticException e){
			//#4. closing resource connection (mandatory to execute)                         

		} catch (ArrayIndexOutOfBoundsException e){
				//forgot to place
				
				
		}finally{
			//#4. closing resource connection (mandatory to execute)  
					//resources releasing logic (or)
					//objects unrefencing logic (or)
					//cleaup code
		}

		System.out.println("Before tcf");
		try{
			System.out.println(" In try");	//case #1: no exception
		//	System.out.println(10/0);		//case #2: exception caught
		//	System.out.println(args[0]);	//case #3: exception not caught
		//	return;						//case #4: transfer statement
		//	System.exit(0);				//case #5: System.exit(0);

		} catch(ArithmeticException e) {
			System.out.println(" In catch");

		} finally {
			System.out.println(" In finally");

		}
		System.out.println("After tcf");
	}
}
