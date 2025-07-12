public class CalculatorMain {
    public static void main(String[] args) {
        Addition add = new Addition();
        Subtraction sub = new Subtraction();
        Multiplication mul = new Multiplication();
        Division div = new Division();

        // Custom inputs
        int x = 50;
        int y = 25;

        System.out.println("Addition: " + add.add(x, y));
        System.out.println("Subtraction: " + sub.subtract(x, y));
        System.out.println("Multiplication: " + mul.multiply(x, y));
        System.out.println("Division: " + div.divide(x, y));
    }
}
