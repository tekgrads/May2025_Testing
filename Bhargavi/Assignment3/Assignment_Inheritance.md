# 📝 Java Assignment: Access Specifiers, IIB, SIB, and Inheritance

---

### 🎯 Objective:
To understand how access specifiers, inheritance, Instance Initialization Blocks (IIB), Static Initialization Blocks (SIB), and constructors work together in Java.

---

### 🧩 Problem Statement:
Create a Java application using inheritance where a subclass interacts with its superclass. Demonstrate the usage of:

- `public`, `protected`, `private`, and `default` access specifiers  
- IIB (Instance Initialization Block)  
- SIB (Static Initialization Block)  
- Constructors using `super` keyword  

---

## ✅ Java Program:

### 🔹 `BankAccount` Superclass

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

    public double getBalance() {
        return balance;
    }
}
```

---

### 🔹 `SavingsAccount` Subclass

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

---

### 🔹 `Main` Class

```java
public class Main {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(12345, "Bhargavi", 10000.50, "OpenAI Bank", 5.5);

        System.out.println("Account Number: " + sa.accountNumber);
        System.out.println("Account Holder Name: " + sa.accountHolderName);
        System.out.println("Bank Name: " + sa.bankName);
        System.out.println("Interest Rate: " + sa.getInterestRate());

        // System.out.println("Balance: " + sa.balance); // ❌ Error - private access
        System.out.println("Balance (via getter): " + sa.getBalance());
    }
}
```

---

## 🔍 Output (Execution Order):

```
BankAccount SIB called.
SavingsAccount SIB called.
BankAccount IIB called.
BankAccount constructor called.
SavingsAccount IIB called.
SavingsAccount constructor called.
Account Number: 12345
Account Holder Name: Bhargavi
Bank Name: OpenAI Bank
Interest Rate: 5.5
Balance (via getter): 10000.5
```

---

## 💡 Access Specifier Comments

| Field              | Modifier   | Accessible in Main? | Reason                                        |
|--------------------|------------|----------------------|-----------------------------------------------|
| `accountNumber`     | `public`   | ✅ Yes               | Public fields are accessible everywhere       |
| `accountHolderName` | `protected`| ✅ Yes               | Same package or subclass                      |
| `balance`           | `private`  | ❌ No                | Private to `BankAccount`, accessed via method |
| `bankName`          | *default*  | ✅ Yes               | Same package, hence accessible                |
| `interestRate`      | `private`  | ✅ Yes (via getter)  | Accessed using public method                  |
