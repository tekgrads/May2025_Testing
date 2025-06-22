

public class Example2 {
    public static void main(String[] args) {
        System.out.println("Started the program");
        
        try{
           // int i =1/0;
        //   String age = "test";   // String age = "25"; // Uncomment this line to avoid NumberFormatException
        //   Integer num = Integer.parseInt(age);
          String str = null;//abc
          System.out.println("Length of string: " + str.length()); // This will cause a
        System.out.println("This line will not be executed due to the exception above.");
        }
        //System.err.println("This is not allowed");
        catch(ArithmeticException e){
            System.out.println("Caught an ArithmeticException: " + e.getMessage());
        }
        //System.err.println("This is not allowed");
        catch(NumberFormatException e){
            System.out.println("Caught a NumberFormatException: " + e.getMessage());
        }catch(NullPointerException e){
            System.out.println("Caught a NullPointerException: " + e.getMessage());
        }



        System.out.println("End Of program");
    }
}
