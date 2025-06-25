ACCESS SPECIFIERS in Java
Access specifiers define visibility of variables, methods, classes, and constructors:

Modifier	Class	Package	Subclass	World	Use Case
public	     ✅	      ✅	✅	        ✅	    Open access across all classes
protected	 ✅	      ✅	✅	        ❌	     Used for inheritance
default	     ✅	      ✅	❌	        ❌	     Encapsulate within package
private	     ✅	      ❌	❌	        ❌	     Max data hiding within class

🔹 Note: Class can only be public or default.

⚡ STATIC & INSTANCE INITIALIZATION BLOCKS
🔷 Static Initialization Block (SIB)
Runs once when class is loaded.

Declared using static { }.

Can access static members only.

Executed before main() and before any object is created.

java
Copy
Edit
class Demo {
    static {
        System.out.println("Static Block");
    }
    public static void main(String[] args) {
        System.out.println("Main Method");
    }
}
✅ Output:
scss
Copy
Edit
Static Block  
Main Method
🔶 Instance Initialization Block (IIB)
Runs every time an object is created.

Declared using { } (without static).

Executes after superclass constructor and before current class constructor.

java
Copy
Edit
class Test {
    {
        System.out.println("Instance Block");
    }
    Test() {
        System.out.println("Constructor");
    }
}
✅ Output:
scss
Copy
Edit
Instance Block  
Constructor
🧬 INHERITANCE IN JAVA
🔹 Definition
Inheritance allows one class (subclass) to acquire properties and behavior of another (superclass).

java
Copy
Edit
class Animal {
    void sound() { System.out.println("Animal Sound"); }
}
class Dog extends Animal {
    void bark() { System.out.println("Dog Barks"); }
}
📌 Types of Inheritance
Type	Description
Single	One class inherits another
Multilevel	Class inherits a class that inherits another
Hierarchical	Multiple classes inherit the same class
Multiple	Achieved via interfaces in Java
Hybrid	Combination of above (via interfaces and classes)

✅ Java Inheritance Example
📁 Folder Structure:

css
Copy
Edit
Bank/
├── BankAccount.java
├── SavingsAccount.java
└── Main.java
🔹 BankAccount.java
java
Copy
Edit
public class BankAccount {
    public int accountNumber;
    protected String accountHolderName;
    private double balance;
    String bankName; // default

    static {
        System.out.println("SIB-BLOCK ON BANK ACCOUNT.");
    }

    {
        System.out.println("IIB-BLOCK ON BANK ACCOUNT");
    }

    public BankAccount(int accountNumber, String accountHolderName, double balance, String bankName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.bankName = bankName;
        System.out.println("BankAccount constructor.");
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
        System.out.println("SavingsAccount ON SIB-BLOCK.");
    }

    {
        System.out.println("SavingsAccount ON IIB-BLOCK.");
    }

    public SavingsAccount(int accountNumber, String accountHolderName, double balance, String bankName, double interestRate) {
        super(accountNumber, accountHolderName, balance, bankName);
        this.interestRate = interestRate;
        System.out.println("SavingsAccount constructor.");
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
        SavingsAccount sa = new SavingsAccount(123, "Sowmya", 50000.00, "SBI", 1.8);

        System.out.println("Account Holder: " + sa.accountHolderName);
        System.out.println("Bank Name: " + sa.bankName);
        System.out.println("Balance: " + sa.getBalance());
        System.out.println("Interest Rate: " + sa.getInterestRate());
    }
}
✅ Output
vbnet
Copy
Edit
SIB-BLOCK ON BANK ACCOUNT.
SavingsAccount ON SIB-BLOCK.
IIB-BLOCK ON BANK ACCOUNT
BankAccount constructor.
SavingsAccount ON IIB-BLOCK.
SavingsAccount constructor.
Account Holder: Sowmya
Bank Name: SBI
Balance: 50000.0
Interest Rate: 1.8
🧠 Key Interview Takeaways
Use super() to call the parent class constructor.

SIBs run once, IIBs run every time.

Access modifiers define visibility and control inheritance.

Private fields require public/protected getters to be accessed in subclasses.

Multiple SIBs/IIBs execute in order of appearance.