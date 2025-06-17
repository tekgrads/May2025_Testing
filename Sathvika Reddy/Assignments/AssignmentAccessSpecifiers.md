
# 📝 Java Assignment: Access Specifiers, IIB, SIB, and Inheritance

## 🎯 Objective:
To understand how access specifiers, inheritance, Instance Initialization Blocks (IIB), Static Initialization Blocks (SIB), and constructors work in Java.

## 🧩 Problem Statement:
Create a Java application using inheritance where a subclass interacts with its superclass. Demonstrate the usage of:
- Access Specifiers (`public`, `protected`, `private`, and default)
- IIB (Instance Initialization Block)
- SIB (Static Initialization Block)
- Constructors (using `super`)

## 🛠️ Task Breakdown

### 1. Create the `BankAccount` Superclass:

public class BankAccount {
    public int accountNumber;
    protected String accountHolderName;
    private double balance;
    String bankName;

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
}
```

### 2. Create the `SavingsAccount` Subclass:

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
        super(accountNumber, accountHolderName, balance, bankName);
        this.interestRate = interestRate;
        System.out.println("SavingsAccount constructor called.");
    }

    // Getter to access private interestRate
    public double getInterestRate() {
        return interestRate;
    }
}
```

### 3. Main Class to Run the Application:

public class Main {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(12345, "Sathvika", 10000.50, "State Bank", 3.5);

        // Accessing fields
        System.out.println("Account Holder Name: " + sa.accountHolderName); // protected - accessible
        System.out.println("Bank Name: " + sa.bankName); // default - accessible in same package
        System.out.println("Interest Rate: " + sa.getInterestRate()); // private - accessed through getter

        // Below line gives compile-time error: balance is private in BankAccount
        // System.out.println("Balance: " + sa.balance);

        // Uncommenting above line will show: balance has private access in BankAccount
    }
}
```

## 🔍 Execution Order (Expected Output)
```
BankAccount SIB called.
SavingsAccount SIB called.
BankAccount IIB called.
BankAccount constructor called.
SavingsAccount IIB called.
SavingsAccount constructor called.
Account Holder Name: Sathvika
Bank Name: State Bank
Interest Rate: 3.5
```

## 💡 Access Specifier Comments
- `accountNumber`: public - accessible everywhere.
- `accountHolderName`: protected - accessible within subclass.
- `balance`: private - **not** accessible outside `BankAccount`.
- `bankName`: default - accessible within the same package.
