🔹 BankAccount.java
java
Copy
Edit
public class BankAccount {
    public int accountNumber;
    protected String accountHolderName;
    private double balance;
    String bankName; // default/package-private

    static {
        System.out.println("BankAccount SIB called.");
    }

    {
        System.out.println("BankAccount IIB called.");
    }

    public BankAccount(int accountNumber, String accountHolderName, double balance, String bankName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.bankName = bankName;
        System.out.println("BankAccount constructor called.");
    }

    public double getBalance() {
        return balance;
    }
}
🔹 SavingsAccount.java
java
Copy
Edit
public class SavingsAccount extends BankAccount {
    private double interestRate;

    static {
        System.out.println("SavingsAccount SIB called.");
    }

    {
        System.out.println("SavingsAccount IIB called.");
    }

    public SavingsAccount(int accountNumber, String accountHolderName, double balance, String bankName, double interestRate) {
        super(accountNumber, accountHolderName, balance, bankName);
        this.interestRate = interestRate;
        System.out.println("SavingsAccount constructor called.");
    }

    public double getInterestRate() {
        return interestRate;
    }
}
🔹 Main.java
java
Copy
Edit
public class Main {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(12345, "Alice", 10000.50, "Tech Bank", 3.5);

        System.out.println("\n--- Accessing Fields ---");

        // Public field: Accessible
        System.out.println("Account Number: " + sa.accountNumber);

        // Protected field: Accessible within the same package
        System.out.println("Account Holder Name: " + sa.accountHolderName);

        // Private field: Not accessible directly -> compile-time error
        // System.out.println("Balance: " + sa.balance); // ❌ Compile-time error
        System.out.println("Balance (via getter): " + sa.getBalance()); // ✅

        // Private field in subclass: Not accessible directly
        // System.out.println("Interest Rate: " + sa.interestRate); // ❌ Compile-time error
        System.out.println("Interest Rate (via getter): " + sa.getInterestRate()); // ✅

        // Default/package-private field: Accessible within the same package
        System.out.println("Bank Name: " + sa.bankName);
    }
}
🧾 Sample Output
pgsql
Copy
Edit
BankAccount SIB called.
SavingsAccount SIB called.
BankAccount IIB called.
BankAccount constructor called.
SavingsAccount IIB called.
SavingsAccount constructor called.

--- Accessing Fields ---
Account Number: 12345
Account Holder Name: Alice
Balance (via getter): 10000.5
Interest Rate (via getter): 3.5
Bank Name: Tech Bank
