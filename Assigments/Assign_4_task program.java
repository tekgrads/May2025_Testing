Assignment--17/6/25
public class Demo {

    // Superclass: BankAccount
    static class BankAccount {
        public int accountNumber;
        protected String accountHolderName;
        private double balance;
        String bankName; // default access

        // Static Initialization Block (SIB)
        static {
            System.out.println("BankAccount SIB called.");
        }

        // Instance Initialization Block (IIB)
        {
            System.out.println("BankAccount IIB called.");
        }

        // Constructor
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

    // Subclass: SavingsAccount
    static class SavingsAccount extends BankAccount {
        private double interestRate;

        // Static Initialization Block (SIB)
        static {
            System.out.println("SavingsAccount SIB called.");
        }

        // Instance Initialization Block (IIB)
        {
            System.out.println("SavingsAccount IIB called.");
        }

        // Constructor
        public SavingsAccount(int accountNumber, String accountHolderName, double balance, String bankName, double interestRate) {
            super(accountNumber, accountHolderName, balance, bankName);
            this.interestRate = interestRate;
            System.out.println("SavingsAccount constructor called.");
        }

        public double getInterestRate() {
            return interestRate;
        }
    }

    // main method
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(123456, "Sai Charitha", 50000.0, "State Bank", 4.5);
        System.out.println("--------------Field access--------------");

        // System.out.println(sa.balance); // balance is private and not accessible
        System.out.println("Balance (via method): " + sa.getBalance());

        System.out.println("Account Holder Name: " + sa.accountHolderName); // protected
        System.out.println("Interest Rate: " + sa.getInterestRate()); // private via getter
        System.out.println("Bank Name: " + sa.bankName); // default (same package)
    }
}
