public class SavingsAccount extends BankAccount {
private double interestRate;


static {
System.out.println("SavingsAccount SIB called.");
}


{
System.out.println("SavingsAccount IIB called.");
}

public SavingsAccount(int accNum, String holderName, double bal, String bank, double rate)
{
super(accNum, holderName, bal, bank);
this.interestRate = rate;
System.out.println("SavingsAccount constructor called.");
}


public double getInterestRate() {
return interestRate;
}
}
