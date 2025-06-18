# ACCESS SPECIFIERS, IIBs, SIBs, INHERITANCE AND PROGRAM USING INHERITANCE

---

## ACCESS SPECIFIERS IN JAVA

Access specifiers, also known as access modifiers, define the visibility and accessibility of classes, variables, methods, and constructors in Java.

We have **4 types** of access specifiers in Java:

### 1. `private`
- Members declared as `private` are only accessible within the class in which they are defined.
- They **cannot** be accessed from outside the class, even by subclasses or other classes in the same package.
- ✅ **Visibility:** Accessible only within the declaring class.
- 💡 **Usage:** Highest level of encapsulation and data hiding.

### 2. `public`
- Members declared as `public` are accessible from **any other class**, regardless of the package.
- ✅ **Visibility:** Global access.
- 💡 **Usage:** Broadest access level.

### 3. `protected`
- Members are accessible within their own package and by **subclasses**, even in other packages.
- ✅ **Visibility:** Within the same package and by subclasses across packages.
- 💡 **Usage:** Suitable for inheritance.

### 4. `default` (no modifier)
- Members with no explicit access modifier are accessible **only within the same package**.
- ✅ **Visibility:** Package-private.
- 💡 **Usage:** Encapsulation within the package.

---

### Summary

| Modifier   | Class | Package | Subclass | World |
|------------|:-----:|:-------:|:--------:|:-----:|
| `public`   | ✅    | ✅      | ✅       | ✅    |
| `protected`| ✅    | ✅      | ✅       | ❌    |
| `default`  | ✅    | ✅      | ❌       | ❌    |
| `private`  | ✅    | ❌      | ❌       | ❌    |

---

### 📌 Notes

- **Classes** can be `public` or default (package-private).
- **Variables** and **methods** can use all 4 access specifiers (`private`, `protected`, `default`, `public`).




# Accessing and Inheriting Access Modifiers in Packages

---

### 1. `private`
- Usage is restricted **within the same class** only.

### 2. `default`
- Can be **used and inherited within the same package**.

### 3. `public`
- Can be **used or inherited by any class**, even if it's **outside the package**.

### 4. `protected`
- Protected members can be **inherited to classes outside the package**.
- **Usage must be within the subclass** only. It cannot be accessed outside unless inherited again.

---

# Static Initialization Blocks (SIBs) & Instance Initialization Blocks (IIBs)

---

## 🔹 Static Initialization Blocks (SIBs)

- Declared using the `static` keyword.
- Executed **only once** when the class is first loaded by the JVM.
- Executed **before any object is created or static methods are called**.
- SIBs can access **static members** of the class.

### ✅ Example:
```java
public class A {
    static {
        System.out.println("SIB block");
    }
    public static void main(String[] args) {
        System.out.println("hello");
    }
}




- SIBs are **not stored in heap memory**.
- If a class has multiple SIBs, they are executed **in the order they appear** in the class.
- They can access **static members** of the class, including **private static fields**.
- If the class has only static blocks (SIBs) and **no `main()` method**, the program will throw an error.
- Inside a static block, **only static variables** can be used—**non-static members are not allowed**.

---

# Instance Initialization Blocks (IIBs)

## What are IIBs?

Instance Initialization Blocks (IIBs) in Java are code blocks that are executed **every time an object of a class is created**.

They are used to **initialize instance variables** and perform operations **common to all constructors** of the class.

## Characteristics of IIBs

### I. Execution Time
- Executed **after** the superclass constructor is called and **before** the current class constructor.

### II. Multiple Blocks
- A class can have **multiple IIBs**, and they are executed **in the order they appear** in the class body.

### III. Common Logic
- Useful for **common initialization logic** that would otherwise be duplicated in each constructor.

### IV. Compilation
- During compilation, the compiler **copies the code from IIBs** into each constructor,
  just **after** the call to the superclass constructor.






# INHERITANCE

## 1. Inheritance

In Java, it is possible to inherit attributes and methods from one class to another. The "inheritance concept" includes:

* **Subclass (child):** The class that inherits from another class
* **Superclass (parent):** The class being inherited from

To inherit from a class, use the `extends` keyword.

### How It Works

When a subclass extends a superclass, it gains access to the **public** and **protected** members of the superclass.

* The subclass can directly use fields and methods from the superclass.
* It promotes code reuse and reduces redundancy.
* The subclass can also add its own unique members or override inherited methods.

---

## Benefits of Inheritance

1. **Code Reusability:**
   Reduces code duplication by allowing subclasses to reuse functionality from superclasses.

2. **Polymorphism:**
   Enables objects of different classes to be treated as objects of a common superclass.

3. **Code Organization and Modularity:**
   Improves structure and maintainability by creating a clear class hierarchy.

4. **Extensibility:**
   Existing class functionality can be extended without modifying original code.

---

# Types of Inheritance in Java

## 1. Single Inheritance

Where a subclass inherits from only one superclass.

```
|---------------|
|   Class A     |
|---------------|
       |
       |
|---------------|
|   Class B     |
|---------------|
```

---

## 2. Multilevel Inheritance

Inheritance where a class inherits from another class, which in turn inherits from another class (a chain of inheritance).

```
|---------------|
|   Class A     |
|---------------|
       |
|---------------|
|   Class B     |
|---------------|
       |
|---------------|
|   Class C     |
|---------------|
```

---

## 3. Multiple Inheritance *(via Interfaces in Java)*

A class inherits properties and methods from more than one parent interface.

```
|---------------|       |---------------|
|   Class A     |       |   Class B     |
|---------------|       |---------------|
         \             /
       |---------------------|
       |      Class C        |
       |---------------------|
```

---

## 4. Hierarchical Inheritance

One base class (superclass) is inherited by multiple subclasses.

```
|----------------------------------|
|            Class A              |
|----------------------------------|
      /         |         \
|--------|  |--------|  |--------|
| Class B|  | Class C|  | Class D|
|--------|  |--------|  |--------|
```

---

## 5. Hybrid Inheritance

A combination of two or more types of inheritance: hierarchical, multiple, multilevel, or single.

```


---



# Java Program Using Inheritance (Markdown for Git)

## 📌 Features Demonstrated

* Inheritance using `extends`
* Access Specifiers: `public`, `protected`, `private`, and default
* Static Initialization Block (SIB)
* Instance Initialization Block (IIB)
* Constructor chaining using `super()`




## 📁 Project Structure

```
Bank/
├── BankAccount.java
├── SavingsAccount.java
└── Main.java
```

---

## 🧾 BankAccount.java

```java
public class BankAccount {
    public int accountNumber;
    protected String accountHolderName;
    private double balance;
    String bankName; // default/package-private

    // Static Initialization Block
    static {
        System.out.println("SIB-BLOCK ON BANK ACCOUNT.");
    }

    // Instance Initialization Block
    {
        System.out.println("IIB-BLOCK ON BANK ACCOUNT");
    }

    // Constructor
    public BankAccount(int accountNumber, String accountHolderName, double balance, String bankName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.bankName = bankName;
        System.out.println("BankAccount constructor.");
    }

    // Getter for private field
    public double getBalance() {
        return balance;
    }
}
```

---

## 🧾 SavingsAccount.java

```java
public class SavingsAccount extends BankAccount {
    private double interestRate;

    // Static Initialization Block
    static {
        System.out.println("SavingsAccount ON SIB-BLOCK.");
    }

    // Instance Initialization Block
    {
        System.out.println("SavingsAccount ON IIB-BLOCK.");
    }

    // Constructor
    public SavingsAccount(int accountNumber, String accountHolderName, double balance, String bankName, double interestRate) {
        super(accountNumber, accountHolderName, balance, bankName);
        this.interestRate = interestRate;
        System.out.println("SavingsAccount constructor.");
    }

    // Getter for private field
    public double getInterestRate() {
        return interestRate;
    }
}
```

---

## 🧾 Main.java

```java
public class Main {
    public static void main(String[] args) {
        // Create SavingsAccount object
        SavingsAccount sa = new SavingsAccount(123, "sowmya", 50000.00, "State Bank of India", 1.8);

        System.out.println("Account Holder Name: " + sa.accountHolderName); // protected
        System.out.println("Bank Name: " + sa.bankName);                   // default access (same package)
        System.out.println("Balance: " + sa.getBalance());                 // using public getter for private field
        System.out.println("Interest Rate: " + sa.getInterestRate());     // using public getter

        // Cannot access private field directly
        // System.out.println("Balance: " + sa.balance); // ❌ Compile-time error
    }
}
```

---

## ✅ Output

```
SIB-BLOCK ON BANK ACCOUNT.
SavingsAccount ON SIB-BLOCK.
IIB-BLOCK ON BANK ACCOUNT
BankAccount constructor.
SavingsAccount ON IIB-BLOCK.
SavingsAccount constructor.
Account Holder Name: sowmya
Bank Name: State Bank of India
Balance: 50000.0
Interest Rate: 1.8
```

---

