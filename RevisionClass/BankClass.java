import java.util.Scanner;

public class BankClass {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

BankAccount acc1 = new BankAccount();
BankAccount acc2 = new BankAccount();

System.out.println("Enter details for Account 1:");
acc1.readDetails(scanner);

System.out.println("\nEnter details for Account 2:");
acc2.readDetails(scanner);

// Perform operations
System.out.println("\n--- Transactions for Account 1 ---");
acc1.deposit(5000);
acc1.withdraw(2000);
acc1.currentBalance();
acc1.display();

System.out.println("\n--- Transactions for Account 2 ---");
acc2.deposit(3000);
acc2.withdraw(1000);
acc2.currentBalance();
acc2.display();

scanner.close();
}
}
