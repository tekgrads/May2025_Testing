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


public BankAccount(int accNum, String holderName, double bal, String bank) {
this.accountNumber = accNum;
this.accountHolderName = holderName;
this.balance = bal;
this.bankName = bank;
System.out.println("BankAccount constructor called.");
}

public double getBalance() {
return balance;
}
}
