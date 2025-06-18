// Superclass representing a generic bank account
public class BankAccount {
    // Fields with different access specifiers
    public int accountNumber;
    protected String accountHolderName;
    private double balance;           // Only accessible within this class
    String bankName;                  // Default (package-private) access

    // Static Initialization Block (SIB)
    static {
        System.out.println("BankAccount SIB called.");
    }

    // Instance Initialization Block (IIB)
    {
        System.out.println("BankAccount IIB called.");
    }

    // Constructor to initialize all fields
    public BankAccount(int accountNumber, String accountHolderName, double balance, String bankName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.bankName = bankName;
        System.out.println("BankAccount constructor called.");
    }
}