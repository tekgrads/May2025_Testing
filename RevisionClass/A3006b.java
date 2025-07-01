import java.util.Scanner;

public class BankAccount 
{
    String bankName;
    String branchName;
    String ifscCode;
    long accountNumber;
    String accountHolderName;
    double balance;

public void readDetails() 
{
Scanner scanner = new Scanner(System.in);

System.out.print("Enter Bank Name: ");
bankName = scanner.nextLine();

System.out.print("Enter Branch Name: ");
branchName = scanner.nextLine();

System.out.print("Enter IFSC Code: ");
ifscCode = scanner.nextLine();

System.out.print("Enter Account Number: ");
accountNumber = scanner.nextLong();
scanner.nextLine();

System.out.print("Enter Account Holder Name: ");
accountHolderName = scanner.nextLine();

System.out.print("Enter Balance: ");
balance = scanner.nextDouble();

}

public void displayDetails() {
System.out.println("\n--- Account Details ---");
System.out.println("Bank Name         : " + bankName);
System.out.println("Branch Name       : " + branchName);
System.out.println("IFSC Code         : " + ifscCode);
System.out.println("Account Number    : " + accountNumber);
System.out.println("Account Holder    : " + accountHolderName);
System.out.println("Balance           : ₹" + balance);
}
public static void main(String[] args) 
{
BankAccount account = new BankAccount();
account.readDetails();
account.displayDetails();
}
}
