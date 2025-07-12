import java.util.Scanner;
class BankAccount
{
	private double balance;
	 public void  setBalance( double balance) {
		if(balance <= 0)
		{
			System.out.println("give +ve num");
		}
		else {
		  this. balance = balance;
		}
	}
	public double getBalance(){
		return balance;
	}
}
class  Bank
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter any number");
		double amt = scn.nextDouble();
		BankAccount ba1 = new BankAccount();
		ba1.setBalance(amt);
		//double balance = ba1.getBalance();
	//	System.out.println("Current balance:" + balance);
		System.out.println("Current balance:" + ba1.getBalance());
	}
}
