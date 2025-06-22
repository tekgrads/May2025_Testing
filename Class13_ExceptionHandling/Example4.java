public class Example4 {
    public static void main(String[] args) {
        System.out.println("Started the program");
         int k = 1 / 0;
        try {            
            System.out.println("Start of try");
            //System.exit(0);
            int i = 1 / 0; // This will cause an ArithmeticException
            System.out.println("End Of try");
        }
        // } catch (ArithmeticException e) {
        //     System.out.println("Caught an ArithmeticException: " + e.getMessage());
        // } 
        // catch (NumberFormatException e) {
        //     System.out.println("Caught an NumberFormatException: " + e.getMessage());
        // }
        
        finally {
            System.out.println("Finally block executed");
        }
        System.out.println("End of Program");
    }
}
