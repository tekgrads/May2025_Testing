

Access Specifiers in Java:

Access specifiers (also known as access modifiers) in Java define the visibility or scope of a class, method, constructor, or variable. Java provides four main access specifiers:

1. private:

Accessible only within the same class.

Not accessible from outside the class, even in the same package.

Commonly used for encapsulation.

2. default (no modifier):

Accessible within the same package only.

Known as package-private.

Not accessible from other packages.

3. protected:

Accessible within the same package.

Also accessible in subclasses in other packages using inheritance.

Commonly used in inheritance scenarios.

4. public:

Accessible from anywhere (any class or package).

Use this when you want your class or members to be fully accessible.

| Access Specifier        | Class | Package | Subclass 	   | World |
| ----------------------- | :---: | :-----: | :------: | :---: |
| `private`               |   ✅   |    ❌    |     ❌    |   ❌   |
| *default* (no modifier) |   ✅   |    ✅    |     ❌    |   ❌   |
| `protected`             |   ✅   |    ✅    |     ✅    |   ❌   |
| `public`                |   ✅   |    ✅    |     ✅    |   ✅   |



JAVA PROGRAM USING INHERITANCE

```
public class BankAccount {

    public int accountNumber;
    protected String accountHolderName;
    private double balance;
    String bankName; // default/package-private

    // Static Initialization Block
    static {
        System.out.println("BankAccount SIB called:");
    }

    // Instance Initialization Block
    {
        System.out.println("BankAccount IIB called:");
    }

    public BankAccount(int accountNumber, String accountHolderName, double balance, String bankName) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.bankName = bankName;
        System.out.println("BankAccount constructor called:");
    }

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    // Static Initialization Block
    static {
        System.out.println("SavingsAccount SIB called:");
    }

    // Instance Initialization Block
    {
        System.out.println("SavingsAccount IIB called:");
    }

    public SavingsAccount(int accountNumber, String accountHolderName, double balance, String bankName, double interestRate) {
        super(accountNumber, accountHolderName, balance, bankName);
        this.interestRate = interestRate;
        System.out.println("SavingsAccount constructor called:");
    }

    public double getInterestRate() {
        return interestRate;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create Savings Account object
        SavingsAccount sa = new SavingsAccount(567, "RUCHITHA", 80000.00, "Bank Of India", 4.5);

        System.out.println("AccountHolderName: " + sa.accountHolderName);  // protected
        System.out.println("BankName: " + sa.bankName);                    // package-private
        System.out.println("Balance: " + sa.getBalance());                // private via getter
        System.out.println("InterestRate: " + sa.getInterestRate());      // private via getter
    }
}


```
OUTPUT:

```
BankAccount SIB called:
SavingsAccout SIB called:
BankAccount IIB called:
BankAccount constructor called:
SavingsAccount IIB called:
SavingsAccount constructor called:
AccountHolderName: RUCHITHA
BankName: Bank Of India
Balance: 80000.0
InterestRate: 4.5


```
