
# Java Inheritance Assignment

##  Problem Statement:
Create a Java application using inheritance where a subclass interacts with its superclass. Demonstrate the usage of:

- Access Specifiers (`public`, `protected`, `private`, and default)
- Instance Initialization Block (IIB)
- Static Initialization Block (SIB)
- Constructors (using `super`)


##  File 1: `BankAccount.java`


public class BankAccount {
    public int accountNumber;
    protected String accountHolderName;
    private double balance;
    String bankName; // default access

    // Static Initialization Block
    static {
        System.out.println("BankAccount SIB called.");
    }

    // Instance Initialization Block
    {
        System.out.println("BankAccount IIB called.");
    }

    // Constructor
    public BankAccount(int accountNumber, String accountHolderName, double balance, String bankName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.bankName = bankName;
        System.out.println("BankAccount constructor called.");
    }

    // Getter for balance (to demonstrate access to private field)
    public double getBalance() {
        return balance;
    }
}


##  File 2: `SavingsAccount.java`


public class SavingsAccount extends BankAccount {
    private double interestRate;

    // Static Initialization Block
    static {
        System.out.println("SavingsAccount SIB called.");
    }

    // Instance Initialization Block
    {
        System.out.println("SavingsAccount IIB called.");
    }

    // Constructor
    public SavingsAccount(int accountNumber, String accountHolderName, double balance, String bankName, double interestRate) {
        super(accountNumber, accountHolderName, balance, bankName); // Calling superclass constructor
        this.interestRate = interestRate;
        System.out.println("SavingsAccount constructor called.");
    }

    // Getter for interestRate
    public double getInterestRate() {
        return interestRate;
    }
}


##  File 3: `Main.java`


public class Main {
    public static void main(String[] args) {
        System.out.println("Creating SavingsAccount object...\n");
        SavingsAccount sa = new SavingsAccount(1001, "Sathvika", 50000.0, "ABC Bank", 4.5);

        System.out.println("\nAccessing fields:");

        // System.out.println(sa.balance); // Compile-time error: balance is private in BankAccount
        System.out.println("Balance (via getter): " + sa.getBalance()); // Access via public method

        System.out.println("Account Holder Name: " + sa.accountHolderName); // protected - accessible in subclass

        System.out.println("Interest Rate: " + sa.getInterestRate()); // private, but accessed via public getter

        System.out.println("Bank Name: " + sa.bankName); // default access, same package
    }
}
```

---

##  Output

BankAccount SIB called.
SavingsAccount SIB called.
Creating SavingsAccount object...

BankAccount IIB called.
BankAccount constructor called.
SavingsAccount IIB called.
SavingsAccount constructor called.

Accessing fields:
Balance (via getter): 50000.0
Account Holder Name: Sathvika
Interest Rate: 4.5
Bank Name: ABC Bank



##  How to Compile and Run

Assuming all `.java` files are in a folder named `java_assignment`:

cd C:\Users\sathv\Downloads\java_assignment
javac BankAccount.java SavingsAccount.java Main.java
java Main

