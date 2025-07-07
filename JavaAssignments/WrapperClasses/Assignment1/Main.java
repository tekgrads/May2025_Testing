public class Main 
{
public static void main(String[] args) 
{
// Creating account

BankAccount account = new BankAccount(1001, "Alice", 500.0);

// Test cases
account.deposit("100.50");   // Valid deposit
account.withdraw("50");      // Valid withdrawal
account.deposit("-30");      // Invalid deposit (negative)
account.withdraw("1000");    // Invalid withdrawal (insufficient funds)
account.deposit("abc");      // Invalid input format
account.checkBalance();      // Final balance
}
}
