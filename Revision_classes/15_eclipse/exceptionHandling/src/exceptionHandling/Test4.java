package exceptionHandling;

public class Test4 {
	//try {}
	//catch{}
	public static void main(String[] args) {
		//try { } // cannot use try alone
	//	catch(Exception e){}// cannot use catch alone
		try {}
		finally {}
		
	/*	catch{}
		finally {}
		*/
	//	finally {}
		try {}
	//	catch(Exception e) {}
		finally {}
	//	catch(Exception e) {}
		try {}
		//System.out.println("a");
		catch(Exception e) {}
	//	System.out.println("a");
		finally{}
		
	/*	try {}
		catch (Exception e) {}
		catch (ArithmeticException e) {}
		catch (IndexOutOfBoundsException e) {}
		*/
		try {}
		catch (ArithmeticException e) {}
		catch (IndexOutOfBoundsException e) {}
		catch (Exception e) {}
			
		
		
	}

}
