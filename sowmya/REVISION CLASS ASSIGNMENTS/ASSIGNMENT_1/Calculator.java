// Calculator.java
public class Calculator {


    public static int add(int a, int b) {
        int c=a+b;
        System.out.println("Addition: " +c);
        return c;

    }

    public static int subtract(int a, int b) {
        int c=a-b;
        System.out.println("subtraction is: " +c);
                return c;


    }

    public static int multiply(int a, int b) {
         int c=a*b;
        System.out.println("Multilpication is : "+c);
                return c;


    }

    public static double divide(int a, int b) {
        int c=a/b;
        System.out.println("division is: " +c);
                return c;


    }

    // Main method
    public static void main(String[] args) {

        add(10,20);
        subtract(20,15);
        multiply(9,10);
        divide(10,5);
          }
}
