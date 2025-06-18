## Objective:
To understand how access specifiers, inheritance, Instance Initialization Blocks (IIB), Static Initialization Blocks (SIB), and constructors work in Java.

## Problem Statement:
Create a Java application using inheritance where a subclass interacts with its superclass. Demonstrate the usage of:
- Access Specifiers (`public`, `protected`, `private`, and default)
- IIB (Instance Initialization Block)
- SIB (Static Initialization Block)
- Constructors (using `super`)

### 1. `BankAccount` Superclass:

```java
public class BankAccount {
    public int accountNumber;
    protected String accountHolderName;
    private double balance;
    String bankName;

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

    // Getter for private balance
    public double getBalance() {
        return balance;
    }
}
```

### 2. `SavingsAccount` Subclass:

```java
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
```

### 3. `Main` Class with `main()` Method:

```java
public class Main {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(12345, "Rishitha", 50000.0, "State Bank", 5.5);

        // Accessible: public field
        System.out.println("Account Number: " + sa.accountNumber);

        // Accessible: protected field (within subclass or same package)
        System.out.println("Account Holder Name: " + sa.accountHolderName);

        // Not accessible: private field
        // System.out.println("Balance: " + sa.balance); // ❌ Compile-time error
        System.out.println("Balance (via getter): " + sa.getBalance());

        // Accessible: default/package-private (same package)
        System.out.println("Bank Name: " + sa.bankName);

        // Accessible: private field via public getter
        System.out.println("Interest Rate: " + sa.getInterestRate());
    }
}
```

##  Output:
1. `BankAccount SIB`
2. `SavingsAccount SIB`
3. `BankAccount IIB`
4. `BankAccount constructor`
5. `SavingsAccount IIB`
6. `SavingsAccount constructor`


