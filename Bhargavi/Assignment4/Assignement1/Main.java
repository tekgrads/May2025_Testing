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
