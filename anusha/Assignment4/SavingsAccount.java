// Subclass extending BankAccount
public class SavingsAccount extends BankAccount {
    // Private field only accessible within this class
    private double interestRate;

    // Static Initialization Block (SIB)
    static {
        System.out.println("SavingsAccount SIB called.");
    }

    // Instance Initialization Block (IIB)
    {
        System.out.println("SavingsAccount IIB called.");
    }

    // Constructor calling superclass constructor
    public SavingsAccount(int accountNumber, String accountHolderName, double balance, String bankName, double interestRate) {
        super(accountNumber, accountHolderName, balance, bankName);
        this.interestRate = interestRate;
        System.out.println("SavingsAccount constructor called.");
    }

    // Getter for interestRate
    public double getInterestRate() {
        return interestRate;
    }
}