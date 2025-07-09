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
