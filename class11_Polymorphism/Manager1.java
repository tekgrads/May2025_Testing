class Calc {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public int add(int a, int b, int c, int d) {
        return a + b;
    }

}

public class Manager1 {

    public static void main(String[] args) {
        Calc calc = new Calc();
        System.out.println("Sum of 2 numbers: " + calc.add(10, 20)); // Calls add(int, int)
        System.out.println("Sum of 3 numbers: " + calc.add(10, 20, 30)); // Calls add(int, int, int)
        System.out.println("Sum of 4 numbers: " + calc.add(10, 20, 30, 40)); // Calls add(int, int, int, int)

       // System.out.println("Sum of 4 numbers: " + calc.add(10, 20, 30, 40, 50)); // Calls add(int, int, int, int)
    }
    
}
