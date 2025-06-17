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

public class Main {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(123456, "Alice", 50000.75, "Global Bank", 4.5);

        System.out.println("\n--- Accessing Fields ---");

        System.out.println("Account Number: " + sa.accountNumber);
        System.out.println("Account Holder Name: " + sa.accountHolderName);
        System.out.println("Balance (via getter): " + sa.getBalance());
        System.out.println("Interest Rate (via getter): " + sa.getInterestRate());
        System.out.println("Bank Name: " + sa.bankName);
    }
}
