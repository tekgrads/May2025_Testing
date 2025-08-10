package exceptionHandling;

public class Addition {
		static int add(int a, int b) 
							throws NegativeNumberException {

			if(a < 0  || b < 0)
				throw new NegativeNumberException(
								"Do not pass -ve numbers");
			

			return a + b;
		}
	

}
