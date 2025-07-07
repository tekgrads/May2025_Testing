public class BankAccount 
{
Integer accountNumber;
String accountHolderName;
Double balance;

// Constructor

public BankAccount(Integer accountNumber, String accountHolderName, Double balance) 
{
this.accountNumber = accountNumber;
this.accountHolderName = accountHolderName;
this.balance = balance;
}

// Deposit method using wrapper class and exception handling
public void deposit(String amountStr) 
{
try 
{
Double amount = Double.parseDouble(amountStr);

if (amount < 0) 
{
throw new InvalidTransactionException("Negative amount not allowed!");
}

balance += amount;
System.out.println("Deposited successfully. New balance: " + balance);

} 
catch (InvalidTransactionException e) 
{
System.out.println("Exception: " + e.getMessage());
} catch (NumberFormatException e) {
System.out.println("Exception: Invalid number format!");
} finally {
System.out.println("Transaction complete.");
}
}

// Withdraw method
public void withdraw(String amountStr) {
try {
Double amount = Double.parseDouble(amountStr);

if (amount < 0) {
throw new InvalidTransactionException("Negative amount not allowed!");
} else if (amount > balance) {
throw new InvalidTransactionException("Insufficient balance!");
}

balance -= amount;
System.out.println("Withdrawn successfully. New balance: " + balance);

} catch (InvalidTransactionException e) {
System.out.println("Exception: " + e.getMessage());
} catch (NumberFormatException e) {
System.out.println("Exception: Invalid number format!");
} finally {
System.out.println("Transaction complete.");
}
}

// Check current balance
public void checkBalance() {
System.out.println("Current balance: " + balance);
}
}
