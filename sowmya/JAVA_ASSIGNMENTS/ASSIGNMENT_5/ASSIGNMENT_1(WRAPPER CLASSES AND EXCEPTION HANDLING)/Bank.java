
public class Bank {

    // Raising Invalid transaction exception
    static class InvalidTranscationException extends Exception {
        public InvalidTranscationException(String message) {
            super(message);
        }
    }

    // Bank account details
    static class BankAccount {
        Integer accountnumber;
        String accountHolderName;
        Double balance;

        public BankAccount(Integer accountnumber, String accountHolderName, Double balance) {
            this.accountnumber = accountnumber;
            this.accountHolderName = accountHolderName;
            this.balance = balance;
        }




       //deposit details with their exceptions
        public void deposit(String amountStr) {
            try {
                Double amount = Double.parseDouble(amountStr);
                if (amount < 0) {
                    throw new InvalidTranscationException("Negative amount not allowed!");
                }
                balance = balance + amount;
                System.out.println("Deposited successfully. New balance: " + balance);
            } catch (NumberFormatException e) {
                System.out.println("Exception: Invalid number format!");
            } catch (InvalidTranscationException e) {
                System.out.println("Exception: " + e.getMessage());
            } finally {
                System.out.println("Transaction complete.\n");
            }
        }



//Withdrawing details wit thier exceptions

        public void withdraw(String amountStr) {
            try {
                Double amount = Double.parseDouble(amountStr);
                if (amount < 0) {
                    throw new InvalidTranscationException("Negative amount not allowed!");
                }
                if (amount > balance) {
                    throw new InvalidTranscationException("Insufficient balance!");
                }
                balance = balance - amount;
                System.out.println("Withdrawn successfully. New balance: " + balance);
            } catch (NumberFormatException e) {
                System.out.println("Exception: Invalid number format!");
            } catch (InvalidTranscationException e) {
                System.out.println("Exception: " + e.getMessage());
            } finally {
                System.out.println("Transaction complete.\n");
            }
        }


//checking the balance of the account
        public void checkBalance() {
            System.out.println("Current balance: " + balance);
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1001, "Alice", 500.0);

        account.deposit("100.50");     // Valid
        account.withdraw("50");        // Valid
        account.deposit("-30");        // Negative amount
        account.withdraw("1000");      // I
	account.deposit("abc");        // Invalid format
        account.checkBalance(); 

}
}