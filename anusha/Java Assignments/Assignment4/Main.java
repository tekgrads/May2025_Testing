public class Main {
    public static void main(String[] args) {
        // Creating an object of SavingsAccount
        SavingsAccount sa = new SavingsAccount(1001, "Anusha", 5000.0, "Union Bank of India", 4.5);

        // Accessing fields from BankAccount and SavingsAccount
        System.out.println("\nAccessing fields:");

        // Public field - accessible anywhere
        System.out.println("accountNumber: " + sa.accountNumber);

        // Protected field - accessible in subclass
        System.out.println("accountHolderName: " + sa.accountHolderName);

        // Default/package-private field - accessible only within same package
        System.out.println("bankName: " + sa.bankName);

        // Private field - NOT directly accessible outside BankAccount
        // System.out.println("balance: " + sa.balance); // ❌ Compile-time error if uncommented

        // Private field - NOT directly accessible outside SavingsAccount
        // System.out.println("interestRate: " + sa.interestRate); // ❌ Compile-time error if uncommented

        // Correct way to access private fields via getter methods
        System.out.println("interestRate: " + sa.getInterestRate());
    }
}