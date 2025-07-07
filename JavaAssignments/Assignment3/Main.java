public class Main {
public static void main(String[] args) 
{
SavingsAccount sa = new SavingsAccount(12345, "John Doe", 10000.50, "HDFC", 4.5);

System.out.println("\n--- Accessing Fields ---");

// System.out.println("Balance: " + sa.balance); // ❌ Error: private
System.out.println("Balance (via getter): " + sa.getBalance()); // ✅

System.out.println("Account Holder Name: " + sa.accountHolderName); // ✅ protected

// System.out.println("Interest Rate: " + sa.interestRate); // ❌ private
System.out.println("Interest Rate (via getter): " + sa.getInterestRate()); // ✅

System.out.println("Bank Name: " + sa.bankName); // ✅ default
}
}
