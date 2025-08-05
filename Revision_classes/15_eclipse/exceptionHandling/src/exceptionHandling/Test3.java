package exceptionHandling;

public class Test3 {
	public static void main(String[] args) {
		try{
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
		//	System.out.println(10/0);
			System.out.println(a/b);

		}catch(Exception e) {
			e.printStackTrace();

			System.out.println("==========================");
			System.out.println(e); //e.toString()

			System.out.println("==========================");
			System.out.println(e.getMessage()); 
		}
	}
}
