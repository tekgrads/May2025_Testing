

###  `InvalidTransactionException.java`

```java
public class InvalidTransactionException extends Exception {
    public InvalidTransactionException(String message) {
        super(message);
    }
}
```

---

### `BankAccount.java`

```java
public class BankAccount {
    private Integer accountNumber;
    private String accountHolderName;
    private Double balance;

    public BankAccount(Integer accountNumber, String accountHolderName, Double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(String amountStr) {
        try {
            Double amount = Double.parseDouble(amountStr);
            if (amount < 0) {
                throw new InvalidTransactionException("Negative amount not allowed!");
            }
            balance += amount;
            System.out.println("Deposited successfully. New balance: " + balance);
        } catch (NumberFormatException e) {
            System.out.println("Exception: Invalid number format!");
        } catch (InvalidTransactionException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("Transaction complete.");
        }
    }

    public void withdraw(String amountStr) {
        try {
            Double amount = Double.parseDouble(amountStr);
            if (amount < 0) {
                throw new InvalidTransactionException("Negative amount not allowed!");
            }
            if (amount > balance) {
                throw new InvalidTransactionException("Insufficient balance!");
            }
            balance -= amount;
            System.out.println("Withdrawn successfully. New balance: " + balance);
        } catch (NumberFormatException e) {
            System.out.println("Exception: Invalid number format!");
        } catch (InvalidTransactionException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("Transaction complete.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}
```

---

###  `Main.java`

```java
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1001, "Alice", 500.0);

        account.deposit("100.50");     // Valid
        account.withdraw("50");        // Valid
        account.deposit("-30");        // Negative amount
        account.withdraw("1000");      // Insufficient balance
        account.deposit("abc");        // Invalid format
        account.checkBalance();        // Final balance
    }
}
```

---

### Expected Output:

```
Deposited successfully. New balance: 600.5
Transaction complete.
Withdrawn successfully. New balance: 550.5
Transaction complete.
Exception: Negative amount not allowed!
Transaction complete.
Exception: Insufficient balance!
Transaction complete.
Exception: Invalid number format!
Transaction complete.
Current balance: 550.5
```

