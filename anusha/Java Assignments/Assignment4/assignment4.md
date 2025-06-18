BankAccount.java

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

Main.java

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

SavingsAccount.java

// Subclass extending BankAccount
public class SavingsAccount extends BankAccount {
    // Private field only accessible within this class
    private double interestRate;

    // Static Initialization Block (SIB)
    static {
        System.out.println("SavingsAccount SIB called.");
    }

    // Instance Initialization Block (IIB)
    {
        System.out.println("SavingsAccount IIB called.");
    }

    // Constructor calling superclass constructor
    public SavingsAccount(int accountNumber, String accountHolderName, double balance, String bankName, double interestRate) {
        super(accountNumber, accountHolderName, balance, bankName);
        this.interestRate = interestRate;
        System.out.println("SavingsAccount constructor called.");
    }

    // Getter for interestRate
    public double getInterestRate() {
        return interestRate;
    }
}

Output:
BankAccount SIB called.
SavingsAccount SIB called.
BankAccount IIB called.
BankAccount constructor called.
SavingsAccount IIB called.
SavingsAccount constructor called.

Accessing fields:
accountNumber: 1001
accountHolderName: Anusha
bankName: Union Bank of India
interestRate: 4.5